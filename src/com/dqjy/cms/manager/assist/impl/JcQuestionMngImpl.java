package com.dqjy.cms.manager.assist.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqjy.cms.dao.assist.JcQuestionDao;
import com.dqjy.cms.manager.assist.JcQuestionMng;






/*
 *Des:问题试卷
 *2015年11月27日16:20:54
 * **/
@Service
@Transactional
public class JcQuestionMngImpl  implements JcQuestionMng {
	@SuppressWarnings("unused")
	private JcQuestionDao jcQuestionDao;
	@Autowired
	public void setJcQuestionDao(JcQuestionDao jcQuestionDao) {
		this.jcQuestionDao = jcQuestionDao;
	}
	
}
