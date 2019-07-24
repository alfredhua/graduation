package com.test.service;

import java.util.List;

import com.test.bean.DepartmentBean;

public interface DepartmentService {
	int insertDepartment(DepartmentBean department);
	
	int existAddDepartment(int id,String departmentName);
	
	DepartmentBean queryAllDepartment(DepartmentBean department);
	
	DepartmentBean getDepartmentById(Integer departmentId);
	
	List<DepartmentBean> queryDepartment();
	
	 int deleteDepartment(String departmentId);
	 
	 int updateDepartment(DepartmentBean department);
	 
	 DepartmentBean getDepartmentByDepartmentId(Integer departmentId);
}
