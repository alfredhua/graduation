package com.test.bean;

import java.io.Serializable;
import java.util.Date;

import com.test.bean.baseBean.BaseBean;

public class PrizeAndpublishBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -268303858917631157L;

	private Integer id;

    private Integer userid;

    private String pname;

    private String preason;

    private String pdescription;

    private Date createtime;

    private Integer ptype;
    
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPreason() {
        return preason;
    }

    public void setPreason(String preason) {
        this.preason = preason == null ? null : preason.trim();
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription == null ? null : pdescription.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }
}