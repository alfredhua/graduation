package com.test.bean;

import java.io.Serializable;

import com.test.bean.baseBean.BaseBean;

public class DailyBean extends BaseBean implements Serializable{

	private static final long serialVersionUID = 1L;


	private Integer userid;

   
    private String workdate;

    private String dailycontext;

    private Integer worktime;

    private String worksite;

    private Integer overtime;

    private String overworkcontext;
    
    private String workDateStart;//查询时日报的开始与结束时间
    
    private String workDateEnd;
    
    public String getWorkDateStart() {
		return workDateStart;
	}

	public void setWorkDateStart(String workDateStart) {
		this.workDateStart = workDateStart;
	}

	public String getWorkDateEnd() {
		return workDateEnd;
	}

	public void setWorkDateEnd(String workDateEnd) {
		this.workDateEnd = workDateEnd;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

   

    public String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public String getDailycontext() {
        return dailycontext;
    }

    public void setDailycontext(String dailycontext) {
        this.dailycontext = dailycontext == null ? null : dailycontext.trim();
    }

    public Integer getWorktime() {
        return worktime;
    }

    public void setWorktime(Integer worktime) {
        this.worktime = worktime;
    }

    public String getWorksite() {
        return worksite;
    }

    public void setWorksite(String worksite) {
        this.worksite = worksite == null ? null : worksite.trim();
    }

    public Integer getOvertime() {
        return overtime;
    }

    public void setOvertime(Integer overtime) {
        this.overtime = overtime;
    }

    public String getOverworkcontext() {
        return overworkcontext;
    }

    public void setOverworkcontext(String overworkcontext) {
        this.overworkcontext = overworkcontext == null ? null : overworkcontext.trim();
    }
}