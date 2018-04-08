package com.dqjy.cms.manager.assist.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqjy.cms.dao.assist.CmsJcStudentDao;
import com.dqjy.cms.entity.assist.JcStudent;
import com.dqjy.cms.manager.assist.CmsJcStudentMng;
import com.dqjy.common.hibernate3.Updater;
import com.dqjy.common.page.Pagination;

@Service
@Transactional
public class CmsJcStudentMngImpl implements CmsJcStudentMng {
	
	public void init(){
	}
	@Transactional(readOnly = true)
	public Pagination getPage(String queryType,int pageNo, int pageSize) {
		Pagination page = dao.getPage(queryType,pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<JcStudent> getList(String queryType){
		return dao.getList(queryType);
	}
	
	@Transactional(readOnly = true)
	public List<String> getTypeList(){
		return dao.getTypeList();
	}

	@Transactional(readOnly = true)
	public JcStudent findById(Integer id) {
		JcStudent entity = dao.findById(id);
		return entity;
	}
	
	@Transactional(readOnly = true)
	public JcStudent findByValue(String type,String value){
		JcStudent entity = dao.findByValue(type,value);
		return entity;
	}

	public JcStudent save(JcStudent bean) {
		dao.save(bean);
		return bean;
	}

	public JcStudent update(JcStudent bean) {
		Updater<JcStudent> updater = new Updater<JcStudent>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public JcStudent deleteById(Integer id) {
		JcStudent bean = dao.deleteById(id);
		return bean;
	}
	
	public JcStudent[] deleteByIds(Integer[] ids) {
		JcStudent[] beans = new JcStudent[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}
	
	public boolean dicDeplicateValue(String value, String type) {
		return dao.countByValue(value,type) > 0;
	}

	private CmsJcStudentDao dao;

	@Autowired
	public void setDao(CmsJcStudentDao dao) {
		this.dao = dao;
	}
}