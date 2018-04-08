package com.dqjy.cms.manager.assist;


import java.io.Serializable;
import java.util.List;

import com.dqjy.cms.entity.assist.JcLeaveMessage;
import com.dqjy.common.util.PagingUtile;
/*liuyan **/
public interface JcLeaveMessageservice {
	public Boolean  addMessage(JcLeaveMessage jcLeaveMessage );
	public  List<JcLeaveMessage> getJcLeaveMessage(String hql,String type,int Stauts);
	public List<Object> getJcLeaveMessagePageList(String hql,List<Object> list,PagingUtile page);
	public  List<JcLeaveMessage> getJcLeaveMessagea(String hql);
	public Boolean deleteMessage(JcLeaveMessage jcLeaveMessage);
	
	
	public <JcLeaveMessage> JcLeaveMessage get(Class<JcLeaveMessage> c, int id);
	public Boolean updataMess(String hql,Object ...value);
	
}
