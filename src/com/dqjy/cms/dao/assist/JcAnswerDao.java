package com.dqjy.cms.dao.assist;

import java.util.List;

import com.dqjy.cms.entity.assist.JcAnswer;
import com.dqjy.cms.entity.assist.JcQuestion;
import com.dqjy.common.hibernate3.Updater;



/**
 * 试卷回答
 * */
public interface JcAnswerDao {
	public JcAnswer findById(Integer id);

	public JcAnswer save(JcAnswer bean);

	public JcAnswer updateByUpdater(Updater<JcAnswer> updater);

	public JcAnswer deleteById(Integer id);
	
	public List<JcAnswer> findList(JcAnswer answer);
}