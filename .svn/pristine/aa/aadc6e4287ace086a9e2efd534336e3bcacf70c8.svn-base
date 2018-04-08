package com.dqjy.cms.manager.assist;

import java.util.List;

import com.dqjy.common.page.Pagination;
import com.dqjy.cms.entity.assist.JcAnswer;
import com.dqjy.cms.entity.assist.JcExamination;
import com.dqjy.cms.entity.assist.JcQuestion;
import com.dqjy.cms.entity.assist.JcQuestionArray;
import com.dqjy.cms.entity.main.CmsUser;

public interface JcExaminationMng {
	public Pagination getPage(int pageNo, int pageSize);

	public JcExamination findById(Integer id);

	public JcExamination save(JcExamination bean);

	public JcExamination update(JcExamination bean);

	public JcExamination deleteById(Integer id);
	
	public JcExamination[] deleteByIds(Integer[] ids);
	
	public List<JcQuestion> findQuestionsByExamin(JcQuestion question);
	
	public List<JcAnswer> findAnswerByQuestion(JcAnswer answer);
	
	//通过栏目ID查询试卷
	public List<JcExamination> findByChannelId(String channelId);

	public JcExamination save(JcExamination bean, CmsUser user,
			JcQuestionArray qus);

	public JcExamination update(JcExamination bean, CmsUser user,
			JcQuestionArray qus);
	public String delQuestion(String id);
}