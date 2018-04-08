package com.dqjy.cms.dao.assist;

import java.util.List;

import com.dqjy.cms.entity.assist.JcStudent;
import com.dqjy.common.hibernate3.Updater;
import com.dqjy.common.page.Pagination;

public interface CmsJcStudentDao {
	public Pagination getPage(String queryType,int pageNo, int pageSize);
	
	public List<JcStudent> getList(String type);
	
	public List<String> getTypeList();

	public JcStudent findById(Integer id);
	
	public JcStudent findByValue(String type,String value);

	public JcStudent save(JcStudent bean);

	public JcStudent updateByUpdater(Updater<JcStudent> updater);

	public JcStudent deleteById(Integer id);

	public int countByValue(String value, String type);
}