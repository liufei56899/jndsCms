package com.dqjy.cms.entity.assist;

import java.util.Date;

import com.dqjy.cms.entity.assist.base.BaseJcStudent;

/**
 * JcStudent entity. @author MyEclipse Persistence Tools
 */
public class JcStudent extends BaseJcStudent implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public JcStudent() {
	}

	/** full constructor */
	public JcStudent(String bmcc, String bkzy, String bkname, String sex,
			Date birthday, String politicalstatus, String idcard,
			String education, String schooltag, String certificatenumber,
			String homephone, String phonenumber, String address,
			String zipcode, String remark, String authcode, String nation) {
		super(bmcc, bkzy, bkname, sex, birthday, politicalstatus, idcard,
				education, schooltag, certificatenumber, homephone,
				phonenumber, address, zipcode, remark, authcode, nation);
	}

}
