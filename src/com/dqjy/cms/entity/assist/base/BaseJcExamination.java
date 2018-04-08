package com.dqjy.cms.entity.assist.base;
// default package

import java.sql.Date;
import java.sql.Timestamp;


/**
 * AbstractJcExamination entity provides the base persistence definition of the JcExamination entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseJcExamination  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String describe;
     private Integer number;
     private Timestamp createdate;
     private String createby;
     private String channelid;


    // Constructors

    /** default constructor */
    public BaseJcExamination() {
    }

	/** minimal constructor */
    public BaseJcExamination(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public BaseJcExamination(Integer id, String describe, Integer number, Timestamp createdate, String createby, String channelid) {
        this.id = id;
        this.describe = describe;
        this.number = number;
        this.createdate = createdate;
        this.createby = createby;
        this.channelid = channelid;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescribe() {
        return this.describe;
    }
    
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }

    public Timestamp getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public String getCreateby() {
        return this.createby;
    }
    
    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getChannelid() {
        return this.channelid;
    }
    
    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }
   








}