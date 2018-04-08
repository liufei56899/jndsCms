package com.dqjy.cms.action.admin.assist;

import static com.dqjy.common.page.SimplePage.cpn;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqjy.cms.entity.assist.CmsGuestbook;
import com.dqjy.cms.entity.assist.CmsGuestbookCtg;
import com.dqjy.cms.entity.assist.CmsGuestbookExt;
import com.dqjy.cms.entity.assist.JcLeaveMessage;
import com.dqjy.cms.entity.main.CmsSite;
import com.dqjy.cms.manager.assist.CmsGuestbookCtgMng;
import com.dqjy.cms.manager.assist.CmsGuestbookMng;
import com.dqjy.cms.manager.assist.JcLeaveMessageservice;
import com.dqjy.cms.manager.assist.impl.JcLeaveMessageImpl;
import com.dqjy.cms.manager.main.CmsLogMng;
import com.dqjy.cms.web.CmsUtils;
import com.dqjy.cms.web.WebErrors;
import com.dqjy.common.page.Pagination;
import com.dqjy.common.util.PagingUtile;
import com.dqjy.common.web.CookieUtils;
import com.dqjy.common.web.RequestUtils;
import com.dqjy.common.web.ResponseUtils;

@Controller
public class CmsGuestbookAct {
	private static final Logger log = LoggerFactory
			.getLogger(CmsGuestbookAct.class);

	@RequestMapping("/guestbook/v_list.do")
	public String list(Integer queryCtgId, Boolean queryRecommend,
			Boolean queryChecked, Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		Pagination pagination = manager.getPage(site.getId(), queryCtgId,null,
				queryRecommend, queryChecked, true, false, cpn(pageNo),
				CookieUtils.getPageSize(request));
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageNo", pagination.getPageNo());
		return "guestbook/list";
	}

	@RequestMapping("/guestbook/v_add.do")
	public String add(HttpServletRequest request, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		List<CmsGuestbookCtg> ctgList = cmsGuestbookCtgMng
				.getList(site.getId());
		model.addAttribute("ctgList", ctgList);
		return "guestbook/add";
	}

	@RequestMapping("/guestbook/v_edit.do")
	public String edit(Integer id, Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		CmsGuestbook cmsGuestbook = manager.findById(id);
		List<CmsGuestbookCtg> ctgList = cmsGuestbookCtgMng
				.getList(site.getId());

		model.addAttribute("cmsGuestbook", cmsGuestbook);
		model.addAttribute("ctgList", ctgList);
		model.addAttribute("pageNo", pageNo);
		return "guestbook/edit";
	}

	@RequestMapping("/guestbook/o_save.do")
	public String save(CmsGuestbook bean, CmsGuestbookExt ext, Integer ctgId,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateSave(bean, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		String ip = RequestUtils.getIpAddr(request);
		bean = manager.save(bean, ext, ctgId, ip);
		log.info("save CmsGuestbook id={}", bean.getId());
		cmsLogMng.operating(request, "cmsGuestbook.log.save", "id="
				+ bean.getId() + ";title=" + bean.getTitle());
		return "redirect:v_list.do";
	}

	@RequestMapping("/guestbook/o_update.do")
	public String update(Integer queryCtgId, Boolean queryRecommend,
			Boolean queryChecked, String oldreply,CmsGuestbook bean, CmsGuestbookExt ext,
			Integer ctgId, Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		WebErrors errors = validateUpdate(bean.getId(), request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		Date now=new Date();
		if(StringUtils.isNotBlank(ext.getReply())&&!oldreply.equals(ext.getReply())){
			bean.setReplayTime(now);
			if(bean.getAdmin()!=null){
				if(!bean.getAdmin().equals(CmsUtils.getUser(request))){
					bean.setAdmin(CmsUtils.getUser(request));
				}
			}else{
				bean.setAdmin(CmsUtils.getUser(request));
			}
		}
		bean = manager.update(bean, ext, ctgId);
		log.info("update CmsGuestbook id={}.", bean.getId());
		cmsLogMng.operating(request, "cmsGuestbook.log.update", "id="
				+ bean.getId() + ";title=" + bean.getTitle());
		return list(queryCtgId, queryRecommend, queryChecked, pageNo, request,
				model);
	}

	@RequestMapping("/guestbook/o_delete.do")
	public String delete(Integer queryCtgId, Boolean queryRecommend,
			Boolean queryChecked, Integer[] ids, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateDelete(ids, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		CmsGuestbook[] beans = manager.deleteByIds(ids);
		for (CmsGuestbook bean : beans) {
			log.info("delete CmsGuestbook id={}", bean.getId());
			cmsLogMng.operating(request, "cmsGuestbook.log.delete", "id="
					+ bean.getId() + ";title=" + bean.getTitle());
		}
		return list(queryCtgId, queryRecommend, queryChecked, pageNo, request,
				model);
	}

	private WebErrors validateSave(CmsGuestbook bean, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		CmsSite site = CmsUtils.getSite(request);
		bean.setSite(site);
		return errors;
	}

	private WebErrors validateEdit(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		CmsSite site = CmsUtils.getSite(request);
		if (vldExist(id, site.getId(), errors)) {
			return errors;
		}
		return errors;
	}

	private WebErrors validateUpdate(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		CmsSite site = CmsUtils.getSite(request);
		if (vldExist(id, site.getId(), errors)) {
			return errors;
		}
		return errors;
	}

	private WebErrors validateDelete(Integer[] ids, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		CmsSite site = CmsUtils.getSite(request);
		if (errors.ifEmpty(ids, "ids")) {
			return errors;
		}
		for (Integer id : ids) {
			vldExist(id, site.getId(), errors);
		}
		return errors;
	}

	private boolean vldExist(Integer id, Integer siteId, WebErrors errors) {
		if (errors.ifNull(id, "id")) {
			return true;
		}
		CmsGuestbook entity = manager.findById(id);
		if (errors.ifNotExist(entity, CmsGuestbook.class, id)) {
			return true;
		}
		if (!entity.getSite().getId().equals(siteId)) {
			errors.notInSite(CmsGuestbook.class, id);
			return true;
		}
		return false;
	}
	/*
	 * 在线留言
	 * 2015.8.26 
	 * 
	 * **/
	
	@RequestMapping("addmessage.do")
	@ResponseBody
	public String addleaveMessage(String course,String sendname,String sex,String profession,String phone,String email,String question,String type,HttpServletRequest request,ModelMap model) {
		JcLeaveMessage jcLeaveMessage =new JcLeaveMessage();
		jcLeaveMessage.setSendname(sendname);
		sex ="0".equals(sex)? "男":"女";
		jcLeaveMessage.setSex(sex);
		jcLeaveMessage.setProfession(profession);
		jcLeaveMessage.setPhone(phone);
		jcLeaveMessage.setEmail(email);
		jcLeaveMessage.setQuestion(question);
		jcLeaveMessage.setType(type);
		jcLeaveMessage.setStauts(0);
		jcLeaveMessage.setSendtime(new Date());
		jcLeaveMessage.setCourse(course);
		if(jcLeaveMessageImpl.addMessage(jcLeaveMessage)){
			return "true";
		}
		return "flase";
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@RequestMapping(value="findmessage.do")
	public void findmessage(String type,String pagStr,HttpServletRequest request,ModelMap model,HttpServletResponse response) throws IOException {
		response.setContentType("text/json; charset=UTF-8");
		String hql=null;
		//**得到留言总数*/
		hql ="from JcLeaveMessage where type=? and stauts=? order by sendtime  desc";
		List<JcLeaveMessage> a =  jcLeaveMessageImpl.getJcLeaveMessage(hql, type, 1);
		PagingUtile page =new PagingUtile();
		page.getPageCounta(a.size());
		page.setPageStr(pagStr);
		List list =new ArrayList();
		list.add(type);
		list.add(1);
		List<Object> b=jcLeaveMessageImpl.getJcLeaveMessagePageList(hql, list,page);
		List info=null;
		if(b!=null){
		 info =new ArrayList<JcLeaveMessage>();
		for (Object object : b) {
			info.add((JcLeaveMessage)object);
		}
			info.add(page);
		}
		net.sf.json.JSONArray j = net.sf.json.JSONArray.fromObject(info);
		PrintWriter pw=response.getWriter();
		pw.write(j.toString());
		
		
	}
	/*留言管理跳转 **/
	@RequestMapping("/messge/leave.do")
	public String loadmessage(HttpServletRequest request,HttpServletResponse response){
		return "data/leaveMessage";
	}
	/*留言管理查询 **/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/message/query.do")
	public void messageQery(String pagStr,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/json;charset=utf-8");
		PrintWriter print =response.getWriter();
		String hql ="from JcLeaveMessage  ORDER BY sendtime desc";
		List<JcLeaveMessage>jcLeaveMessage = jcLeaveMessageImpl.getJcLeaveMessagea(hql);
		PagingUtile page =new PagingUtile();
		page.getPageCounta(jcLeaveMessage.size());
		page.setPageStr(pagStr);
		List list =new ArrayList();
		List<Object> b= jcLeaveMessageImpl.getJcLeaveMessagePageList(hql, list, page);
		if(b!=null){
			for (Object object : b) {
				list.add((JcLeaveMessage)object);
			}
			list.add(page);
		}
		net.sf.json.JSONArray 	json = net.sf.json.JSONArray.fromObject(list);
		print.write(json.toString());
	}
	/*留言管理删除 **/
	@RequestMapping("/messge/delete.do")
	@ResponseBody
	public String delMessage(String id,HttpServletRequest request,HttpServletResponse response){
		
		JcLeaveMessage jcLeaveMessage =new JcLeaveMessage();
		jcLeaveMessage.setId(Integer.parseInt(id));
		if(jcLeaveMessageImpl.deleteMessage(jcLeaveMessage)){
			return "true";
		}else{
			return "false";
		}
	}
	/*留言管理审核 **/
	@RequestMapping("/messge/shenhe.do")
	@ResponseBody
	public String sheMessage(String id,HttpServletRequest request,HttpServletResponse response){
		String hql ="UPDATE  JcLeaveMessage SET stauts = '1'  WHERE id=?  ";
		if(jcLeaveMessageImpl.updataMess(hql,Integer.parseInt(id))){
			return "true";
		}else{
			return "false";
		}
	}
	/*留言管理更新 **/
	@RequestMapping("updata.do")
	@ResponseBody
	public String updata(String huida,String type,HttpServletRequest request,HttpServletResponse response){
		String hql ="UPDATE  JcLeaveMessage SET huida = ?  WHERE id=?  ";
		if(jcLeaveMessageImpl.updataMess(hql,huida,Integer.parseInt(type))){
			return "true";
		}else{
			return "false";
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/messge/show.do")
	public void showMessage(String id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/json;charset=utf-8");
		PrintWriter pw =response.getWriter();
		JcLeaveMessage jcLeaveMessage =new JcLeaveMessage(); 
		jcLeaveMessage =jcLeaveMessageImpl.get(jcLeaveMessage.getClass(), Integer.parseInt(id));
		List list =new ArrayList();
		list.add(jcLeaveMessage);
		net.sf.json.JSONArray 	json = net.sf.json.JSONArray.fromObject(list);
		pw.write(json.toString());
	}
	@Autowired
	private CmsGuestbookCtgMng cmsGuestbookCtgMng;
	@Autowired
	private CmsLogMng cmsLogMng;
	@Autowired
	private CmsGuestbookMng manager;
	
	@Autowired
	private JcLeaveMessageservice jcLeaveMessageImpl;
	
}