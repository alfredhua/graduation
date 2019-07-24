package com.test.bean;

import java.io.Serializable;

import com.test.bean.baseBean.BaseBean;

public class RecordBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = -4807528871056231106L;

	private Integer id;

    private Integer userid;

    private String opentime;

    private String endtime;

    private String absencetype;

    private String reason;

    private Integer state;
    
    private String openTimeStart;
    
    private String openTimeEnd;
    
    private String realName;
    
    public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getOpenTimeStart() {
		return openTimeStart;
	}

	public void setOpenTimeStart(String openTimeStart) {
		this.openTimeStart = openTimeStart;
	}

	public String getOpenTimeEnd() {
		return openTimeEnd;
	}

	public void setOpenTimeEnd(String openTimeEnd) {
		this.openTimeEnd = openTimeEnd;
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

    public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getAbsencetype() {
        return absencetype;
    }

    public void setAbsencetype(String absencetype) {
        this.absencetype = absencetype == null ? null : absencetype.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}