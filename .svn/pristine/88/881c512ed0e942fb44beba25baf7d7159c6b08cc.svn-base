package com.dqjy.cms.action.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dqjy.cms.entity.main.Content;
import com.dqjy.cms.entity.main.ContentAttachment;
import com.dqjy.cms.manager.main.ContentCountMng;
import com.dqjy.cms.manager.main.ContentMng;
import com.dqjy.cms.service.ContentCountCache;
import com.dqjy.common.util.Office2PDF;
import com.dqjy.common.web.ResponseUtils;

@Controller
public class ContentCountAct {
	@RequestMapping(value = "/content_view.jspx", method = RequestMethod.GET)
	public void contentView(Integer contentId, HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		if (contentId == null) {
			ResponseUtils.renderJson(response, "[]");
			return;
		}
		int[] counts = contentCountCache.viewAndGet(contentId);
		String json;
		if (counts != null) {
			json = new JSONArray(counts).toString();
			ResponseUtils.renderJson(response, json);
		} else {
			ResponseUtils.renderJson(response, "[]");
		}
	}
	@RequestMapping("/wmgetcontent.jspx")
	public void wmgetcontent(Integer contentId,HttpServletRequest request, 
			HttpServletResponse response) throws JSONException {
		JSONObject json = new JSONObject();
		Content content=manager.findById(contentId);
		List<ContentAttachment> catt=content.getAttachments();
		if(null!=catt&&0<catt.size()){
			String filepath=catt.get(0).getPath();
			if(!filepath.contains(".swf")){
				String tomcatpath=request.getSession().getServletContext().getRealPath("");
				tomcatpath.replace("\\","/");
				final String tomcccc=tomcatpath+filepath;
				Office2PDF pffo=new Office2PDF(tomcccc);	
				pffo.conver();
				filepath=filepath.substring(0, filepath.lastIndexOf("."))+".swf";
			}
			json.put("attrpath", filepath);
		}
		ResponseUtils.renderJson(response, json.toString());
	}

	@RequestMapping(value = "/content_up.jspx", method = RequestMethod.GET)
	public void contentUp(Integer contentId, HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		if (contentId == null) {
			ResponseUtils.renderJson(response, "false");
		} else {
			contentCountMng.contentUp(contentId);
			ResponseUtils.renderJson(response, "true");
		}
	}

	@RequestMapping(value = "/content_down.jspx", method = RequestMethod.GET)
	public void contentDown(Integer contentId, HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		if (contentId == null) {
			ResponseUtils.renderJson(response, "false");
		} else {
			contentCountMng.contentDown(contentId);
			ResponseUtils.renderJson(response, "true");
		}
	}
	@Autowired
	private ContentMng manager;
	@Autowired
	private ContentCountCache contentCountCache;
	@Autowired
	private ContentCountMng contentCountMng;
}
