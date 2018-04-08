package com.dqjy.cms.entity.assist;

import java.sql.Timestamp;
import java.util.Date;
/**
 * JcQuestion entity. @author MyEclipse Persistence Tools
 */

public class JcQuestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private String examinationid;
	private String content;
	private Integer number;
	private String createby;
	private Date createdate;
	private String classtype;
	private JcAnswer[] answers;
	// Constructors
	/** default constructor */
	public JcQuestion() {
	}

	/** full constructor */
	public JcQuestion(String examinationid, String content, Integer number,
			String createby, Date createdate, String classtype) {
		this.examinationid = examinationid;
		this.content = content;
		this.number = number;
		this.createby = createby;
		this.createdate = createdate;
		this.classtype = classtype;
	}

	// Property accessors

	public JcAnswer[] getAnswers() {
		return answers;
	}

	public void setAnswers(JcAnswer[] answers) {
		this.answers = answers;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExaminationid() {
		return this.examinationid;
	}

	public void setExaminationid(String examinationid) {
		this.examinationid = examinationid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCreateby() {
		return this.createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getClasstype() {
		return this.classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

}