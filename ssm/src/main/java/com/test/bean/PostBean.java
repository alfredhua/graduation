package com.test.bean;

import java.io.Serializable;

import com.test.bean.baseBean.BaseBean;

public class PostBean extends BaseBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6809345622291775649L;

	private Integer postId;

    private String postName;

    private Integer departmentId;

    private String description;
    
    private String basic;
    
    public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}