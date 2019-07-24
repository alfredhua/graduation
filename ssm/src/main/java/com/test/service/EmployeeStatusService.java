package com.test.service;

import java.util.List;

import com.test.bean.EmployeeStatusBean;
import com.test.service.base.BaseService;

public interface EmployeeStatusService{
	
	List<EmployeeStatusBean> selectAllEmplyeeStatus();
}
