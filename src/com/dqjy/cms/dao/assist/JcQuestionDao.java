package com.dqjy.cms.dao.assist;

import java.util.List;

import com.dqjy.cms.entity.assist.JcExamination;
import com.dqjy.cms.entity.assist.JcQuestion;
import com.dqjy.common.hibernate3.Updater;



/**
 * 试卷问题Dao
 * 2015年11月27日 16:35:03
 * */

public interface JcQuestionDao {
	public JcQuestion findById(Integer id);

	public JcQuestion save(JcQuestion bean);

	public JcQuestion updateByUpdater(Updater<JcQuestion> updater);

	public JcQuestion deleteById(Integer id);
	
	public List<JcQuestion> findList(JcQuestion question);		
}