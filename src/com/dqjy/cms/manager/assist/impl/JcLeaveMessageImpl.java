package com.dqjy.cms.manager.assist.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqjy.cms.dao.assist.JcLeaveMessageDao;
import com.dqjy.cms.entity.assist.JcLeaveMessage;
import com.dqjy.cms.manager.assist.JcLeaveMessageservice;
import com.dqjy.common.util.PagingUtile;


@Service
@Transactional
public class JcLeaveMessageImpl  implements JcLeaveMessageservice {
	
	private JcLeaveMessageDao dao;

	@Autowired
	public void setDao(JcLeaveMessageDao dao) {
		this.dao = dao;
	}
	public Boolean addMessage(JcLeaveMessage jcLeaveMessage) {
		// TODO Auto-generated method stub
		return dao.addJcLeaveMessageDao(jcLeaveMessage);
	}
	
	public List<JcLeaveMessage> getJcLeaveMessage(String hql, String type,int Stauts) {
		// TODO Auto-generated method stub
		Object[] find={type,Stauts};
		List<JcLeaveMessage> jcLeaveMessages = dao.getJcLeaveMessage(hql, find);
		return jcLeaveMessages;
	}
	public List<Object> getJcLeaveMessagePageList(String hql,List<Object> list, PagingUtile page) {
			List<Object> jcLeaveMessages=dao.getJcLeaveMessagePageList(hql, list, page);
		 	return jcLeaveMessages;
	}
	public List<JcLeaveMessage> getJcLeaveMessagea(String hql) {
		// TODO Auto-generated method stub
		List<JcLeaveMessage> jcLeaveMessage = dao.getJcLeaveMessage(hql);
		return jcLeaveMessage;
	}
	public Boolean deleteMessage(JcLeaveMessage jcLeaveMessage) {
		// TODO Auto-generated method stub
		return dao.deleteMessage(jcLeaveMessage);
	}
	public <JcLeaveMessage> JcLeaveMessage get(Class<JcLeaveMessage> c,
			int id) {
		return dao.get(c, id);
	}
	public Boolean updataMess(String hql, Object... value) {
		// TODO Auto-generated method stub
		return dao.updataMess(hql, value);
	}
	
}
