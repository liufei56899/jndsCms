package com.dqjy.cms.dao.assist.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.dqjy.common.hibernate3.HibernateBaseDao;
import com.dqjy.common.page.Pagination;
import com.dqjy.cms.dao.assist.JcExaminationDao;
import com.dqjy.cms.entity.assist.JcExamination;

@Repository
public class JcExaminationDaoImpl extends HibernateBaseDao<JcExamination, Integer> implements JcExaminationDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		crit.addOrder(Order.asc("createdate"));
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}
		
	public JcExamination findById(Integer id) {
		JcExamination entity = get(id);
		return entity;
	}

	public JcExamination save(JcExamination bean) {
		getSession().save(bean);
		return bean;
	}

	public JcExamination deleteById(Integer id) {
		JcExamination entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<JcExamination> getEntityClass() {
		return JcExamination.class;
	}

	@SuppressWarnings("unchecked")
	public List<JcExamination> findByChannelId(String channelId) {
		// TODO Auto-generated method stub
		Query query =	getSession().createQuery("from JcExamination bean  where  bean.channelid ='"+channelId+"'" +"ORDER BY createdate  ASC");
			 
		return query.list();
	}
}