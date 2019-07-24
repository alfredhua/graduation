package com.test.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.test.bean.baseBean.BaseBean;

public class SalaryBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 4785460899185080816L;

	private Integer userid;

    private BigDecimal basic;
    
 

    private Long eat;

    private Long duty;

    private Long scot;

    private Long punishment;

    private Date createtime;

    private BigDecimal totalize;


	public SalaryBean(){
    	
    }
    
    public SalaryBean(Integer userid,BigDecimal basic,Long eat,Long duty,Long scot,Long punishment, Date createtime, BigDecimal totalize){
    	this.userid=userid;
    	this.basic=basic;
    	this.eat=eat;
    	this.duty=duty;
    	this.scot=scot;
    	this.punishment=punishment;
    	this.totalize=totalize;
    	this.createtime=createtime;
    }
    
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

   

    public BigDecimal getBasic() {
		return basic;
	}

	public void setBasic(BigDecimal basic) {
		this.basic = basic;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public BigDecimal getTotalize() {
		return totalize;
	}

	public void setTotalize(BigDecimal totalize) {
		this.totalize = totalize;
	}

   
}