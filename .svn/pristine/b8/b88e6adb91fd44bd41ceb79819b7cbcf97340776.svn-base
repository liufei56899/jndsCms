package com.dqjy.cms.action.front;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dqjy.cms.entity.assist.JcStudent;
import com.dqjy.cms.manager.assist.CmsJcStudentMng;
import com.dqjy.common.web.ResponseUtils;

/**
 * 前台招生报名入口
 * 
 * 类名：CmsJcStudentAct
 * 功能：
 * 详细：
 * 作者：ws
 * 版本：1.0
 * 日期：2015-1-22 下午5:38:04
 * 
 *
 */
@Controller
public class CmsJcStudentAct {
	private static final Logger log = LoggerFactory.getLogger(CmsJcStudentAct.class);
	@RequestMapping(value = "/student.jspx", method = RequestMethod.POST)
	public void submit(JcStudent jcStudent,Errors errors,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws JSONException {
		
		JSONObject json = new JSONObject();
		
		if(jcStudent.getBkname()==null || jcStudent.getBkname().length()==0){
			json.put("success", false);
			json.put("status", 1);//
			ResponseUtils.renderJson(response, json.toString());
			return ;
		}else{
			jcStudent.setBkname(jcStudent.getBkname());
		}
		
		if(jcStudent.getIdcard()==null || jcStudent.getIdcard().length()!=18){
			json.put("success", false);
			json.put("status",2);//
			ResponseUtils.renderJson(response, json.toString());
			return ;
		}else{
			jcStudent.setIdcard(jcStudent.getIdcard());
		}
		
		try{
			JcStudent student=mange.save(jcStudent);
			if(student!=null && student.getId()!=0){
				json.put("success", true);
				json.put("status", 0);
			}
		}catch (Exception e) {
			json.put("success", false);
			json.put("status", -1);//异常
		}
		
		ResponseUtils.renderJson(response, json.toString());
	}
	@Autowired
	private CmsJcStudentMng mange;
}
