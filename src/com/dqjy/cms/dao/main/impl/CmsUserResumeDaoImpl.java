package com.dqjy.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.dqjy.cms.dao.main.CmsUserResumeDao;
import com.dqjy.cms.entity.main.CmsUserResume;
import com.dqjy.common.hibernate3.HibernateBaseDao;

@Repository
public class CmsUserResumeDaoImpl extends HibernateBaseDao<CmsUserResume, Integer> implements CmsUserResumeDao {
	public CmsUserResume findById(Integer id) {
		CmsUserResume entity = get(id);
		return entity;
	}

	public CmsUserResume save(CmsUserResume bean) {
		getSession().save(bean);
		return bean;
	}
	
	@Override
	protected Class<CmsUserResume> getEntityClass() {
		return CmsUserResume.class;
	}
}