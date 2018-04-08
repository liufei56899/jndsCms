package com.dqjy.cms.dao.assist.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dqjy.cms.dao.assist.JcQuestionDao;
import com.dqjy.cms.entity.assist.JcAnswer;
import com.dqjy.cms.entity.assist.JcExamination;
import com.dqjy.cms.entity.assist.JcQuestion;
import com.dqjy.common.hibernate3.HibernateBaseDao;
import com.dqjy.common.hibernate3.Updater;

/**
 * Des:问题回答 Dao
 * 2015年11月27日16:23:31
 * 
 * */
@Repository
public class JcQuestionDaoImpl extends
		HibernateBaseDao<JcQuestion, Integer> implements JcQuestionDao {
	@Override
	protected Class<JcQuestion> getEntityClass() {
		return JcQuestion.class;
	}

	public JcQuestion findById(Integer id) {
		JcQuestion entity = get(id);
		return entity;
	}

	public JcQuestion save(JcQuestion bean) {
		getSession().save(bean);
		return bean;
	}

	public JcQuestion deleteById(Integer id) {
		JcQuestion entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	public List<JcQuestion> findList(JcQuestion question) {
		// TODO Auto-generated method stub
		List<JcQuestion> list=super.findByProperty("examinationid", question.getExaminationid());
		
		return list;
	}
	
	
}