package com.test.service;

import java.util.List;

import com.test.bean.ResourceBean;

public interface ResourceService {
	
	List<ResourceBean> findResourceByPermission(Integer permissionId);

}
