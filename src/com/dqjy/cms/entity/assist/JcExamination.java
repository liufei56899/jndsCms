package com.dqjy.cms.entity.assist;
// default package

import java.sql.Date;
import java.sql.Timestamp;

import com.dqjy.cms.entity.assist.base.BaseJcExamination;


/**
 * JcExamination entity. @author MyEclipse Persistence Tools
 */
public class JcExamination extends BaseJcExamination implements java.io.Serializable {

    // Constructors

    /**
	 * 
	 */
	private static final long serialVersionUID = -8923185987817234101L;

	/** default constructor */
    public JcExamination() {
    }

	/** minimal constructor */
    public JcExamination(Integer id) {
        super(id);        
    }
    
    /** full constructor */
    public JcExamination(Integer id, String describe, Integer number, Timestamp createdate, String createby, String channelid) {
        super(id, describe, number, createdate, createby, channelid);        
    }
   
}
