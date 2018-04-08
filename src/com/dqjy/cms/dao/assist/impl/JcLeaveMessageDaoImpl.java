package com.dqjy.cms.dao.assist.impl;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dqjy.cms.dao.assist.JcLeaveMessageDao;
import com.dqjy.cms.entity.assist.JcLeaveMessage;
import com.dqjy.common.hibernate3.HibernateBaseDao;
import com.dqjy.common.util.PagingUtile;

@Repository
public class JcLeaveMessageDaoImpl extends HibernateBaseDao<JcLeaveMessage, Integer> implements
		JcLeaveMessageDao {

	public Boolean addJcLeaveMessageDao(JcLeaveMessage jcLeaveMessage) {
		// TODO Auto-generated method stub
		Boolean bl =false;
		Serializable id;
		if(jcLeaveMessage!=null){
			id =getSession().save(jcLeaveMessage);
			if((Integer)id!=0&&id.toString().length()!=0&&!id.toString().equals("0")){
				bl=true;
			}
		}
		return bl;
	}
	@Override
	protected Class<JcLeaveMessage> getEntityClass() {
		// TODO Auto-generated method stub
		return JcLeaveMessage.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<JcLeaveMessage> getJcLeaveMessage(String hql, Object... value) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		if(value.length!=0){
			for(int i=0;i<value.length;i++){
				query.setParameter(i,value[i]);
			}
		}
		
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Object> getJcLeaveMessagePageList(String hql, List<Object> list,PagingUtile page) {
		// TODO Auto-generated method stub
		Query query =getSession().createQuery(hql);
		if(list.size()!=0&&list!=null){
			for(int i=0;i<list.size();i++){
				query.setParameter(i, list.get(i));
			}
		}
		query.setFirstResult((Integer.parseInt((page.getPageStr()))-1)*Integer.parseInt((page.getPageSize())));
		query.setMaxResults(Integer.parseInt(page.getPageSize()));
		return query.list();

	}
	public Boolean deleteMessage(Object obj) {
		// TODO Auto-generated method stub
		try{
			getSession().delete(obj);
			return true;
		}catch(Exception ex){
			return false;
		}
	
	}
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		return (T)getSession().get(c, id);
	}
	public Boolean updataMess(String hql, Object... values) {
		// TODO Auto-generated method stub
		Query q = getSession().createQuery(hql);
		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				q.setParameter(i, values[i]);
			}
		}
		return q.executeUpdate()!=0 ? true: false;
	}
	
}


