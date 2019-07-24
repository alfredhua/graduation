package com.test.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PostSalaryBean {
    private Integer postid;

    private BigDecimal basic;

    private BigDecimal totalize;

    private Date createtime;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }


    public BigDecimal getBasic() {
		return basic;
	}

	public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}

	public BigDecimal getTotalize() {
		return totalize;
	}

	public void setTotalize(BigDecimal totalize) {
		this.totalize = totalize;
	}

	public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}