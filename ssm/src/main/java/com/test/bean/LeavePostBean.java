package com.test.bean;

import java.io.Serializable;

import com.test.bean.baseBean.BaseBean;

public class LeavePostBean extends BaseBean implements Serializable{
 
	private static final long serialVersionUID = -5051836222337096128L;

	private Integer id;

    private Integer userid;

    private String reason;

    private Integer leavestatus;

    private String leavetime;
    
    private String userName;
    
    private String realName;
    
    private String leaveTimeStart;
    
    private String leaveTimeEnd;
    
    

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

	public String getLeaveTimeStart() {
		return leaveTimeStart;
	}

	public void setLeaveTimeStart(String leaveTimeStart) {
		this.leaveTimeStart = leaveTimeStart;
	}

	public String getLeaveTimeEnd() {
		return leaveTimeEnd;
	}

	public void setLeaveTimeEnd(String leaveTimeEnd) {
		this.leaveTimeEnd = leaveTimeEnd;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getLeavestatus() {
        return leavestatus;
    }

    public void setLeavestatus(Integer leavestatus) {
        this.leavestatus = leavestatus;
    }

	public String getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}

   
}