package com.dqjy.cms.dao.assist;

import java.util.List;

import com.dqjy.common.hibernate3.Updater;
import com.dqjy.common.page.Pagination;
import com.dqjy.cms.entity.assist.JcExamination;

public interface JcExaminationDao {
	public Pagination getPage(int pageNo, int pageSize);

	public JcExamination findById(Integer id);

	public JcExamination save(JcExamination bean);

	public JcExamination updateByUpdater(Updater<JcExamination> updater);

	public JcExamination deleteById(Integer id);
	
	
	//通过栏目ID查询试卷
	public List<JcExamination> findByChannelId(String channelId);
}