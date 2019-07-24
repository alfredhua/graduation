package com.test.service.Impl;

import java.util.List;

import com.test.service.base.BaseService;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.ResourceBean;
import com.test.dao.ResourceBeanMapper;
import com.test.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl  extends BaseService implements ResourceService{

	private ResourceBeanMapper resourceBeanMapper;
	
	@Override
	public List<ResourceBean> findResourceByPermission(Integer permissionId) {
		List<ResourceBean> resource = resourceBeanMapper.selectbypermission(permissionId);
		return resource;
	}

	public ResourceBeanMapper getResourceBeanMapper() {
		return resourceBeanMapper;
	}
	@Autowired
	public void setResourceBeanMapper(ResourceBeanMapper resourceBeanMapper) {
		this.resourceBeanMapper = resourceBeanMapper;
	}
	
	

}
