package com.dqjy.cms.manager.assist.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqjy.common.hibernate3.Updater;
import com.dqjy.common.page.Pagination;
import com.dqjy.cms.dao.assist.JcAnswerDao;
import com.dqjy.cms.dao.assist.JcExaminationDao;
import com.dqjy.cms.dao.assist.JcQuestionDao;
import com.dqjy.cms.entity.assist.JcAnswer;
import com.dqjy.cms.entity.assist.JcExamination;
import com.dqjy.cms.entity.assist.JcQuestion;
import com.dqjy.cms.entity.assist.JcQuestionArray;
import com.dqjy.cms.entity.main.CmsUser;
import com.dqjy.cms.manager.assist.JcExaminationMng;

@Service
@Transactional
public class JcExaminationMngImpl implements JcExaminationMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public JcExamination findById(Integer id) {
		JcExamination entity = dao.findById(id);
		return entity;
	}

	/**
	 * @param bean
	 * @param questions
	 * @return
	 */
	public JcExamination save(JcExamination bean,CmsUser user,JcQuestionArray questions) {
		
		bean.setCreatedate(new Timestamp(System.currentTimeMillis()));
		bean.setCreateby(user.getId().toString());
		dao.save(bean);
		//保存问题
		if (questions!=null&&questions.getQuestions().length>0) {
			for (JcQuestion question : questions.getQuestions()) {
				if (question.getContent()==null) {
					continue;
				}
				question.setCreateby(user.getId().toString());
				question.setCreatedate(new Timestamp(System.currentTimeMillis()));
				question.setExaminationid(bean.getId().toString());
				questionDao.save(question);
				//保存答案选项
				if (question.getAnswers()!=null&&question.getAnswers().length>0) {
					for (JcAnswer answer : question.getAnswers()) {
						answer.setCreateby(user.getId().toString());
						answer.setCreatedate(new Timestamp(System.currentTimeMillis()));
						answer.setQuestionid(question.getId().toString());
						//
						answerDao.save(answer);
					}
				}
				
			}
			
		}
		return bean;
	}
	public JcExamination save(JcExamination bean) {
		
		bean.setNumber(1);
		bean.setChannelid("dd");
		bean.setCreatedate(new Timestamp(System.currentTimeMillis()));
		bean.setCreateby("dds");
		dao.save(bean);
		return bean;
	}

	public JcExamination update(JcExamination bean,CmsUser user,JcQuestionArray qus) {
		Updater<JcExamination> updater = new Updater<JcExamination>(bean);
		bean = dao.updateByUpdater(updater);
		if (qus.getQuestions()!=null&&qus.getQuestions().length>0) {
			for (JcQuestion question : qus.getQuestions()) {
				if (question.getId()!=null) {
					Updater<JcQuestion> updaterQuestion = new Updater<JcQuestion>(question);
					questionDao.updateByUpdater(updaterQuestion);
					//更新答案选项
					if (question.getAnswers()!=null) {
						for (JcAnswer answer : question.getAnswers()) {
							answer.setIsright(answer.getIsright()==null?"":answer.getIsright());
							Updater<JcAnswer> updaterAnswer = new Updater<JcAnswer>(answer);
							answerDao.updateByUpdater(updaterAnswer);
						}
					}
				} else {
					if (question.getContent()==null) {
						continue;
					}
					question.setCreateby(user.getId().toString());
					question.setCreatedate(new Timestamp(System.currentTimeMillis()));
					question.setExaminationid(bean.getId().toString());
					questionDao.save(question);
					//保存答案选项
					if (question.getAnswers()!=null&&question.getAnswers().length>0) {
						for (JcAnswer answer : question.getAnswers()) {
							answer.setCreateby(user.getId().toString());
							answer.setCreatedate(new Timestamp(System.currentTimeMillis()));
							answer.setQuestionid(question.getId().toString());
							//
							answerDao.save(answer);
						}
					}
				}
			}
		}
		return bean;
	}
	public JcExamination update(JcExamination bean) {
		Updater<JcExamination> updater = new Updater<JcExamination>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public JcExamination deleteById(Integer id) {
		JcExamination bean = dao.deleteById(id);
		return bean;
	}
	
	public JcExamination[] deleteByIds(Integer[] ids) {
		JcExamination[] beans = new JcExamination[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private JcExaminationDao dao;
	
	@Autowired
	private JcQuestionDao questionDao;
	@Autowired
	private JcAnswerDao answerDao;
	@Autowired
	public void setDao(JcExaminationDao dao) {
		this.dao = dao;
	}

	public List<JcExamination> findByChannelId(String channelId) {
		// TODO Auto-generated method stub
		return dao.findByChannelId(channelId);
	
	}

	public List<JcQuestion> findQuestionsByExamin(JcQuestion question) {
		// TODO Auto-generated method stub
		List<JcQuestion> questionList=questionDao.findList(question);
		for (JcQuestion jcQuestion : questionList) {
			JcAnswer answer=new JcAnswer();
			answer.setQuestionid(jcQuestion.getId().toString());
			jcQuestion.setAnswers(answerDao.findList(answer).toArray(new JcAnswer[]{}));
		}
		return questionList;
	}

	public List<JcAnswer> findAnswerByQuestion(JcAnswer answer) {
		// TODO Auto-generated method stub
		return answerDao.findList(answer);
	}

	public String delQuestion(String id) {
		// TODO Auto-generated method stub
		
		questionDao.deleteById(Integer.parseInt(id));
		return "success";
	}
}