package com.test.bean;

import java.util.List;

public class MenuBean {
    private Integer id;

    private String name;

    private String url;

    private Integer parentid;

    private String disorder;
    
    private List<MenuBean> childrenMenu;
    
    private String remark;
    
    private String check;
    

    public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

    
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<MenuBean> getChildrenMenu() {
		return childrenMenu;
	}

	public void setChildrenMenu(List<MenuBean> childrenMenu) {
		this.childrenMenu = childrenMenu;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getDisorder() {
        return disorder;
    }

    public void setDisorder(String disorder) {
        this.disorder = disorder == null ? null : disorder.trim();
    }

//	@Override
//	public String toString() {
//		return "MenuBean [id=" + id + ", name=" + name + ", url=" + url + ", parentid=" + parentid + ", disorder="
//				+ disorder + ", childrenMenu=" + childrenMenu + ", remark=" + remark + ", check=" + check + "]";
//	}
    
    
}