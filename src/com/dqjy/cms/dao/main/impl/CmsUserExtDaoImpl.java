package com.dqjy.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.dqjy.cms.dao.main.CmsUserExtDao;
import com.dqjy.cms.entity.main.CmsUserExt;
import com.dqjy.common.hibernate3.HibernateBaseDao;

@Repository
public class CmsUserExtDaoImpl extends HibernateBaseDao<CmsUserExt, Integer> implements CmsUserExtDao {
	public CmsUserExt findById(Integer id) {
		CmsUserExt entity = get(id);
		return entity;
	}

	public CmsUserExt save(CmsUserExt bean) {
		getSession().save(bean);
		return bean;
	}
	
	@Override
	protected Class<CmsUserExt> getEntityClass() {
		return CmsUserExt.class;
	}

	public CmsUserExt deleteById(Integer id) {
		CmsUserExt entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}