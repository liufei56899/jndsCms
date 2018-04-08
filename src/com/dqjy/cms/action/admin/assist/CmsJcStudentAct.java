package com.dqjy.cms.action.admin.assist;

import static com.dqjy.common.page.SimplePage.cpn;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dqjy.cms.entity.assist.JcStudent;
import com.dqjy.cms.manager.assist.CmsJcStudentMng;
import com.dqjy.cms.manager.main.CmsLogMng;
import com.dqjy.common.page.Pagination;
import com.dqjy.common.web.CookieUtils;

@Controller
public class CmsJcStudentAct {
	private static final Logger log = LoggerFactory.getLogger(CmsJcStudentAct.class);

	@RequestMapping("/jcStudent/v_list.do")
	public String list(String queryType,Integer pageNo, HttpServletRequest request, ModelMap model) {
		Pagination pagination = manager.getPage(queryType,cpn(pageNo), CookieUtils
				.getPageSize(request));
		model.addAttribute("pagination",pagination);
		model.addAttribute("pageNo",pagination.getPageNo());
		return "student/list";
	}
	
	
	@RequestMapping("/jcStudent/v_view.do")
	public String viewResume(Integer id,HttpServletRequest request,
			ModelMap model) {
		JcStudent resume = manager.findById(id);
		model.addAttribute("jcStudent", resume);
		return "student/viewstudent";
	}
	

	
	@Autowired
	private CmsJcStudentMng manager;
	@Autowired
	private CmsLogMng cmsLogMng;
}