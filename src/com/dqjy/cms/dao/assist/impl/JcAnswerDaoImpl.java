package com.dqjy.cms.dao.assist.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dqjy.cms.dao.assist.JcAnswerDao;
import com.dqjy.cms.entity.assist.JcAnswer;
import com.dqjy.cms.entity.assist.JcQuestion;
import com.dqjy.common.hibernate3.HibernateBaseDao;

/**
 * Des:问题回答 Dao
 * 2015年11月27日16:23:31
 * 
 * */
@Repository
public class JcAnswerDaoImpl extends
		HibernateBaseDao<JcAnswer, Integer> implements JcAnswerDao {
	@Override
	protected Class<JcAnswer> getEntityClass() {
		return JcAnswer.class;
	}
	public JcAnswer findById(Integer id) {
		JcAnswer entity = get(id);
		return entity;
	}

	public JcAnswer save(JcAnswer bean) {
		getSession().save(bean);
		return bean;
	}

	public JcAnswer deleteById(Integer id) {
		JcAnswer entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	public List<JcAnswer> findList(JcAnswer answer) {
		// TODO Auto-generated method stub
		List<JcAnswer> list=super.findByProperty("questionid", answer.getQuestionid());
		return list;
	}
}