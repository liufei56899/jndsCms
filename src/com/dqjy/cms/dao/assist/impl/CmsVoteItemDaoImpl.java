package com.dqjy.cms.dao.assist.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.dqjy.cms.dao.assist.CmsVoteItemDao;
import com.dqjy.cms.entity.assist.CmsVoteItem;
import com.dqjy.common.hibernate3.HibernateBaseDao;
import com.dqjy.common.page.Pagination;

@Repository
public class CmsVoteItemDaoImpl extends HibernateBaseDao<CmsVoteItem, Integer>
		implements CmsVoteItemDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public CmsVoteItem findById(Integer id) {
		CmsVoteItem entity = get(id);
		return entity;
	}

	public CmsVoteItem save(CmsVoteItem bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsVoteItem deleteById(Integer id) {
		CmsVoteItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsVoteItem> getEntityClass() {
		return CmsVoteItem.class;
	}
}