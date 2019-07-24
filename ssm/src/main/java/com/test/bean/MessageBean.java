package com.test.bean;

import java.io.Serializable;
import java.util.Date;

import com.test.bean.baseBean.BaseBean;

public class MessageBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -5882299812539002438L;

	private Integer id;

    private Integer sendid;

    private String context;
    private String userName;
    private String realName;
    private Integer reviceid;

    private Date senddate;

    private Integer readstate;

    private Integer delettype;
    
    

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getReviceid() {
        return reviceid;
    }

    public void setReviceid(Integer reviceid) {
        this.reviceid = reviceid;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public Integer getReadstate() {
        return readstate;
    }

    public void setReadstate(Integer readstate) {
        this.readstate = readstate;
    }

    public Integer getDelettype() {
        return delettype;
    }

    public void setDelettype(Integer delettype) {
        this.delettype = delettype;
    }
}