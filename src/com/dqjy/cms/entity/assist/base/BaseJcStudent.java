package com.dqjy.cms.entity.assist.base;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractJcStudent entity provides the base persistence definition of the
 * JcStudent entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseJcStudent implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bmcc;
	private String bkzy;
	private String bkname;
	private String sex;
	private Date birthday;
	private String politicalstatus;
	private String idcard;
	private String education;
	private String schooltag;
	private String certificatenumber;
	private String homephone;
	private String phonenumber;
	private String address;
	private String zipcode;
	private String remark;
	private String authcode;
	private String nation;
	private Timestamp createTime;
	private Date byTime;
	private String zkScore;

	// Constructors

	public Date getByTime() {
		return byTime;
	}

	public void setByTime(Date byTime) {
		this.byTime = byTime;
	}

	public String getZkScore() {
		return zkScore;
	}

	public void setZkScore(String zkScore) {
		this.zkScore = zkScore;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/** default constructor */
	public BaseJcStudent() {
	}

	/** full constructor */
	public BaseJcStudent(String bmcc, String bkzy, String bkname,
			String sex, Date birthday, String politicalstatus, String idcard,
			String education, String schooltag, String certificatenumber,
			String homephone, String phonenumber, String address,
			String zipcode, String remark, String authcode, String nation) {
		this.bmcc = bmcc;
		this.bkzy = bkzy;
		this.bkname = bkname;
		this.sex = sex;
		this.birthday = birthday;
		this.politicalstatus = politicalstatus;
		this.idcard = idcard;
		this.education = education;
		this.schooltag = schooltag;
		this.certificatenumber = certificatenumber;
		this.homephone = homephone;
		this.phonenumber = phonenumber;
		this.address = address;
		this.zipcode = zipcode;
		this.remark = remark;
		this.authcode = authcode;
		this.nation = nation;
	}

	// Property accessors


	public String getBmcc() {
		return this.bmcc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBmcc(String bmcc) {
		this.bmcc = bmcc;
	}

	public String getBkzy() {
		return this.bkzy;
	}

	public void setBkzy(String bkzy) {
		this.bkzy = bkzy;
	}

	public String getBkname() {
		return this.bkname;
	}

	public void setBkname(String bkname) {
		this.bkname = bkname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPoliticalstatus() {
		return this.politicalstatus;
	}

	public void setPoliticalstatus(String politicalstatus) {
		this.politicalstatus = politicalstatus;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchooltag() {
		return this.schooltag;
	}

	public void setSchooltag(String schooltag) {
		this.schooltag = schooltag;
	}

	public String getCertificatenumber() {
		return this.certificatenumber;
	}

	public void setCertificatenumber(String certificatenumber) {
		this.certificatenumber = certificatenumber;
	}

	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuthcode() {
		return this.authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

}