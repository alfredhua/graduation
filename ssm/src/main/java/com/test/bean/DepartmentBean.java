package com.test.bean;

import java.io.Serializable;

import org.omg.PortableInterceptor.INACTIVE;

import com.test.bean.baseBean.BaseBean;
import com.test.bean.baseBean.PageVo;

public class DepartmentBean  implements Serializable{

	private static final long serialVersionUID = 405143248909897361L;
	
	private Integer id;
	
	private Integer departmentId;

    private String departmentName;

    private String departmentType;

    private String description;

    private Integer parentId;
    
    private String parentDepartmentName;
	private PageVo<DepartmentBean> pageVo;
	
	
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParentDepartmentName() {
		return parentDepartmentName;
	}

	public void setParentDepartmentName(String parentDepartmentName) {
		this.parentDepartmentName = parentDepartmentName;
	}

	public PageVo<DepartmentBean> getPageVo() {
		return pageVo;
	}

	public void setPageVo(PageVo<DepartmentBean> pageVo) {
		this.pageVo = pageVo;
	}

	public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType == null ? null : departmentType.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}