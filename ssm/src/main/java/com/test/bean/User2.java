package com.test.bean;

import java.io.Serializable;
import java.util.Date;

import com.test.bean.baseBean.BaseBean;
import com.test.util.common.PageVo;

public class User2 extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = -3452282860702789376L;

	private Integer userId;

    private String userName;

    private String password;

    private String realName;

    private Integer sex;

    private Integer age;

    private String idcode;

    private String telephone;

    private String email;

    private String address;

    private String workDate;

    private Integer departmentId;

    private Integer postId;

    private Integer state;

    private Integer roles;

    private String workDateStart;
    
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName==null?null:userName.trim();
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode == null ? null : idcode.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }
}