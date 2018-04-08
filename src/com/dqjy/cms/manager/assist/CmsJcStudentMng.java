package com.dqjy.cms.manager.assist;

import java.util.List;

import com.dqjy.cms.entity.assist.JcStudent;
import com.dqjy.common.page.Pagination;

public interface CmsJcStudentMng {
	public Pagination getPage(String queryType,int pageNo, int pageSize);
	
	public List<JcStudent> getList(String queryType);
	
	public List<String> getTypeList();

	public JcStudent findById(Integer id);
	
	public JcStudent findByValue(String type,String value);

	public JcStudent save(JcStudent bean);

	public JcStudent update(JcStudent bean);

	public JcStudent deleteById(Integer id);
	
	public JcStudent[] deleteByIds(Integer[] ids);
	
	public boolean dicDeplicateValue(String value,String type);
}