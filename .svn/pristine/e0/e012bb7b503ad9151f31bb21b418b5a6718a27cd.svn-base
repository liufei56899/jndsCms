package com.dqjy.cms.dao.assist.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dqjy.cms.dao.assist.CmsJcStudentDao;
import com.dqjy.cms.entity.assist.JcStudent;
import com.dqjy.common.hibernate3.Finder;
import com.dqjy.common.hibernate3.HibernateBaseDao;
import com.dqjy.common.page.Pagination;

@Repository
public class CmsJcStudentDaoImpl extends HibernateBaseDao<JcStudent, Integer> implements CmsJcStudentDao {
	public Pagination getPage(String queryType,int pageNo, int pageSize) {
//		Criteria crit = createCriteria();
//		if(StringUtils.isNotBlank(queryType)){
//			Criterion cron = Restrictions.like("type",queryType);
//			crit.add(cron);
//		}
//		Pagination page = findByCriteria(crit, pageNo, pageSize);
		
		Finder f = Finder.create("from JcStudent jc where 1=1 ");
		
		f.append(" order by createTime desc ");
		f.setCacheable(true);
		Pagination page = find(f, pageNo, pageSize);
		return page;
	}
	
	@SuppressWarnings("unchecked")
	public List<JcStudent> getList(String type){
		Criterion cron = Restrictions.like("type",type); 
		return findByCriteria(cron);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getTypeList(){
		Finder f=Finder.create("select  type from JcStudent dic group by type ");
		return find(f);
	}

	public JcStudent findById(Integer id) {
		JcStudent entity = get(id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public JcStudent findByValue(String type,String value){
		Criterion cron_type=null,cron_value=null;
		if(StringUtils.isNotBlank(type)){
			cron_type = Restrictions.like("type",type);
		}
		if(StringUtils.isNotBlank(value)){
			cron_value = Restrictions.like("value",value);
		}
		List<JcStudent>li=findByCriteria(cron_type,cron_value);
		if(li!=null&&li.size()>0){
			return li.get(0);
		}else{
			return null;
		}
	}

	public JcStudent save(JcStudent bean) {
		getSession().save(bean);
		return bean;
	}

	public JcStudent deleteById(Integer id) {
		JcStudent entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	public int countByValue(String value, String type) {
		String hql = "select count(*) from JcStudent bean where bean.value=:value and bean.type=:type";
		Query query = getSession().createQuery(hql);
		query.setParameter("value", value);
		query.setParameter("type", type);
		return ((Number) query.iterate().next()).intValue();
	}
	
	@Override
	protected Class<JcStudent> getEntityClass() {
		return JcStudent.class;
	}
}