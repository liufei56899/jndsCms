package com.dqjy.cms.action.admin.assist;

import static com.dqjy.common.page.SimplePage.cpn;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqjy.cms.entity.assist.JcAnswer;
import com.dqjy.cms.entity.assist.JcExamination;
import com.dqjy.cms.entity.assist.JcQuestion;
import com.dqjy.cms.entity.assist.JcQuestionArray;
import com.dqjy.cms.entity.main.CmsSite;
import com.dqjy.cms.entity.main.CmsUser;
import com.dqjy.cms.manager.assist.JcExaminationMng;
import com.dqjy.cms.web.CmsUtils;
import com.dqjy.cms.web.FrontUtils;
import com.dqjy.cms.web.WebErrors;
import com.dqjy.common.page.Pagination;
import com.dqjy.common.web.CookieUtils;

@Controller
public class JcExaminationAct {
	private static final Logger log = LoggerFactory.getLogger(JcExaminationAct.class);

	@RequestMapping("/jcExamination/v_list.do")
	public String list(Integer pageNo, HttpServletRequest request, ModelMap model) {
		Pagination pagination = manager.getPage(cpn(pageNo), CookieUtils
				.getPageSize(request));
		model.addAttribute("pagination",pagination);
		model.addAttribute("pageNo",pagination.getPageNo());
		return "jcExamination/list";
	}

	
	
	@RequestMapping("/jcExamination/v_add.do")
	public String add(ModelMap model) {
		return "jcExamination/add";
	}

	@RequestMapping("/jcExamination/v_edit.do")
	public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		model.addAttribute("jcExamination", manager.findById(id));
		model.addAttribute("pageNo",pageNo);
		return "jcExamination/edit";
	}
	@RequestMapping("/jcExamination/getQuestionList.do")
	public void getQestionList(String examId, HttpServletRequest request, ModelMap model,HttpServletResponse response){
		//查询问题列表
		JcQuestion question=new JcQuestion();
		question.setExaminationid(examId);
		List<JcQuestion> questionList=manager.findQuestionsByExamin(question);
		try {
			response.reset();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("utf-8");
			response.getWriter().print(JSONArray.fromObject(questionList).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/jcExamination/validAnswer.do")
	public void validAnswer(JcExamination bean,JcQuestionArray qus, HttpServletRequest request, ModelMap model,HttpServletResponse response){
		//校验是否都选择了答案
		String message="";
		if (qus.getQuestions()!=null) {
			for (JcQuestion question : qus.getQuestions()) {
				//如果是选择题，判断是否至少勾选了答案
				if (question.getClasstype()!=null&& question.getClasstype().equals("1")) {
					boolean isChecked=false;
					for (JcAnswer answer : question.getAnswers()) {
						if (answer.getIsright()!=null) {
							isChecked=true;
							break;
						}
					}
					if (!isChecked) {
						message="请为问题【"+question.getContent()+"】至少勾选一项正确答案.";
						break;
					}
				}
			}
		}
		try {
	        response.setCharacterEncoding("utf-8");
			response.getWriter().print(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/jcExamination/o_save.do")
	public String save(JcExamination bean,JcQuestionArray qus, HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateSave(bean, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		//
		CmsUser user = CmsUtils.getUser(request);
		bean = manager.save(bean,user,qus);
		log.info("save JcExamination id={}", bean.getId());
		return "redirect:v_list.do";
	}

	@RequestMapping("/jcExamination/o_update.do")
	public String update(JcExamination bean,JcQuestionArray qus, Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		WebErrors errors = validateUpdate(bean.getId(), request);
		//
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		CmsUser user = CmsUtils.getUser(request);
		bean = manager.update(bean,user,qus);
		log.info("update JcExamination id={}.", bean.getId());
		return list(pageNo, request, model);
	}

	@RequestMapping("/jcExamination/o_delete.do")
	public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		WebErrors errors = validateDelete(ids, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		JcExamination[] beans = manager.deleteByIds(ids);
		for (JcExamination bean : beans) {
			log.info("delete JcExamination id={}", bean.getId());
		}
		return list(pageNo, request, model);
	}
	
	@RequestMapping("/jcExamination/delQuestion.do")
	@ResponseBody
	public String delQuestion(String qid, HttpServletRequest request,ModelMap model){
		String flag="";
		if (qid!=null) {
			flag=manager.delQuestion(qid);
		}
		return flag;
	}
	
	private WebErrors validateSave(JcExamination bean, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
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
		JcExamination entity = manager.findById(id);
		if(errors.ifNotExist(entity, JcExamination.class, id)) {
			return true;
		}
		return false;
	}
	
	
	
	
	/****
	 * Des 查询专业试卷
	 * 2015年11月28日09:43:23
	 * @throws IOException 
	 * */
	@RequestMapping(value="/jcExamination/professional.do")
	@SuppressWarnings("unused")
	public void  findZyPaper(String channelId,HttpServletResponse response) throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter pw=response.getWriter();
		JSONArray  jsonArray=null;
		List<JcExamination> jcExaminationList =null;
		try {
				if( channelId !=null ){
				jcExaminationList = manager.findByChannelId(channelId);
				}
				jsonArray  =	JSONArray.fromObject(jcExaminationList);
				System.out.println(jsonArray.toString());
		} catch (Exception e) {
				// TODO: handle exception
			pw.write("false");
		}
		 pw.write(jsonArray.toString());
	}
	/***
	 * DES:跳转答题页面
	 * 2015年11月28日 14:08:19
	 * @throws UnsupportedEncodingException 
	 * @throws IOException 
	 * */
	@RequestMapping(value="/jcExamination/goAnswerpaper.do")
	public String  goAnswerpaper(String retUrl,String examinationid,String describe,String tm ,Model md,String channelId, HttpServletRequest request) throws UnsupportedEncodingException{
		md.addAttribute("examinationid", examinationid);
		 describe =	java.net.URLDecoder.decode(describe, "utf-8");
		md.addAttribute("describe",describe);
//		SimpleDateFormat sm =new SimpleDateFormat("yyyy-MM-dd");
//		
//		 tm =	sm.format(new Date(Long.parseLong(tm)));
//		md.addAttribute("tm",tm);
		
		//
		md.addAttribute("retUrl",retUrl);
		md.addAttribute("channelId",channelId);
		List<JcExamination> examList=manager.findByChannelId(channelId);
		JcExamination nextExam=null;
		JcExamination prevExam=null;
		for (int i = 0; i < examList.size(); i++) {
			if (examList.get(i).getId().toString().equals(examinationid)) {
				//
				if (i==0) {
					if (examList.size()>1) {
						nextExam =examList.get(i+1);
					}
				}else if(i==examList.size()-1&&examList.size()>1){
					prevExam=examList.get(i-1);
				}else{
					nextExam=examList.get(i+1);
					prevExam=examList.get(i-1);
				}
			}
		}
		
		if (nextExam!=null) {
			md.addAttribute("nextExam",nextExam);
		}
		
		if (prevExam!=null) {
			md.addAttribute("prevExam",prevExam);
		}
		return "jcExamination/answerpaper";
	}
	/***
	 * 试卷查询
	 * 2015年11月28日 15:09:43
	 * @throws IOException 
	 * */
	@RequestMapping(value="/jcExamination/queryAnswerpaper.do")
	public void queryAnswerpaper(String examinationid,HttpServletResponse response) throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out=response.getWriter();
		JcQuestion jcquestion =new JcQuestion();
		jcquestion.setExaminationid(examinationid);
		List<JcQuestion> jcquestionList =	manager.findQuestionsByExamin(jcquestion);
		JSON json =JSONArray.fromObject(jcquestionList);
		out.print(json.toString());
	}
	
	
	@Autowired
	private JcExaminationMng manager;
}