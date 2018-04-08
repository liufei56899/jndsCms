package com.dqjy.cms.manager.assist.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqjy.cms.dao.assist.JcAnswerDao;
import com.dqjy.cms.manager.assist.JcAnswerMng;





/*
 *Des:问题回答
 *2015年11月27日16:20:54
 * **/
@Service
@Transactional
public class JcAnswerMngImpl  implements JcAnswerMng {
	@SuppressWarnings("unused")
	private JcAnswerDao jcAnswerDao ;
	@Autowired
	public void setJcAnswerDao(JcAnswerDao jcAnswerDao) {
		this.jcAnswerDao = jcAnswerDao;
	}
	
	
}
