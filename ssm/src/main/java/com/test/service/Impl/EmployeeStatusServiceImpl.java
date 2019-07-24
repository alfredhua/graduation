package com.test.service.Impl;

import com.test.bean.EmployeeStatusBean;
import com.test.dao.EmployeeStatusBeanMapper;
import com.test.service.EmployeeStatusService;
import com.test.service.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeStatusService")
public class EmployeeStatusServiceImpl  extends BaseService implements EmployeeStatusService{


	Logger logger = LoggerFactory.getLogger(EmployeeStatusServiceImpl.class);  
	
	private EmployeeStatusBeanMapper employeeStatusBeanMapper;
	@Override
	public List<EmployeeStatusBean> selectAllEmplyeeStatus() {
		logger.info("开始查询状态");
		List<EmployeeStatusBean> allEmployeeStatus = employeeStatusBeanMapper.selectAllEmployStatus();
		return allEmployeeStatus;
	}
	
	
	
	public EmployeeStatusBeanMapper getEmployeeStatusBeanMapper() {
		return employeeStatusBeanMapper;
	}
	@Autowired
	public void setEmployeeStatusBeanMapper(EmployeeStatusBeanMapper employeeStatusBeanMapper) {
		this.employeeStatusBeanMapper = employeeStatusBeanMapper;
	}

	
}
