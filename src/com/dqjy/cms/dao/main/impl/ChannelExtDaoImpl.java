package com.dqjy.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.dqjy.cms.dao.main.ChannelExtDao;
import com.dqjy.cms.entity.main.ChannelExt;
import com.dqjy.common.hibernate3.HibernateBaseDao;

@Repository
public class ChannelExtDaoImpl extends HibernateBaseDao<ChannelExt, Integer>
		implements ChannelExtDao {
	public ChannelExt save(ChannelExt bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<ChannelExt> getEntityClass() {
		return ChannelExt.class;
	}
}