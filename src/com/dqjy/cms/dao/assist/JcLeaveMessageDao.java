package com.dqjy.cms.dao.assist;

import java.io.Serializable;
import java.util.List;

import com.dqjy.cms.entity.assist.JcLeaveMessage;
import com.dqjy.common.util.PagingUtile;

public interface JcLeaveMessageDao {
	public Boolean addJcLeaveMessageDao(JcLeaveMessage jcLeaveMessage);
	public List<JcLeaveMessage> getJcLeaveMessage(String hql,Object ... value);
	public List<Object> getJcLeaveMessagePageList(String hql,List<Object> list,PagingUtile page);
	public Boolean deleteMessage(Object obj);
	public <T> T get(Class<T> c, Serializable id);
	public Boolean updataMess(String hql,Object ...value);
}
