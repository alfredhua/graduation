package com.test.bean;

import java.io.Serializable;
import java.util.Date;

import com.test.bean.baseBean.BaseBean;

public class PostRecordBean extends BaseBean implements Serializable{
  
	private static final long serialVersionUID = 8543513097080666968L;

	private Integer id;

    private Integer userid;

    private Integer department;

    private Integer post;

    private Integer newpost;

    private String newpostname;

    private Integer newdepartment;

    private Date changetime;
    
    private String userName;
    
    private String realName;
    
    

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Integer getNewpost() {
        return newpost;
    }

    public void setNewpost(Integer newpost) {
        this.newpost = newpost;
    }

    public String getNewpostname() {
        return newpostname;
    }

    public void setNewpostname(String newpostname) {
        this.newpostname = newpostname == null ? null : newpostname.trim();
    }

    public Integer getNewdepartment() {
        return newdepartment;
    }

    public void setNewdepartment(Integer newdepartment) {
        this.newdepartment = newdepartment;
    }

    public Date getChangetime() {
        return changetime;
    }

    public void setChangetime(Date changetime) {
        this.changetime = changetime;
    }
}