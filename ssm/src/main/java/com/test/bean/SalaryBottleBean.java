package com.test.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.test.bean.baseBean.BaseBean;

public class SalaryBottleBean extends BaseBean implements Serializable{

	private static final long serialVersionUID = 7740804146181589658L;

	private Integer id;

    private Integer userid;

    private BigDecimal basic;

    private Long eat;

    private Long duty;

    private Long scot;

    private Long punishment;

    private Date granttime;

    private BigDecimal totalize;

    private Integer status;

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

    public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}

	public void setTotalize(BigDecimal totalize) {
		this.totalize = totalize;
	}



    public Long getEat() {
        return eat;
    }

    public void setEat(Long eat) {
        this.eat = eat;
    }

    public Long getDuty() {
        return duty;
    }

    public void setDuty(Long duty) {
        this.duty = duty;
    }

    public Long getScot() {
        return scot;
    }

    public void setScot(Long scot) {
        this.scot = scot;
    }

    public Long getPunishment() {
        return punishment;
    }

    public void setPunishment(Long punishment) {
        this.punishment = punishment;
    }

    public Date getGranttime() {
        return granttime;
    }

    public void setGranttime(Date granttime) {
        this.granttime = granttime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public BigDecimal getBasic() {
		return basic;
	}

	public BigDecimal getTotalize() {
		return totalize;
	}
    
    
}