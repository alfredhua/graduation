package com.test.service;

import java.util.Map;

import com.test.bean.SalaryBean;
import com.test.bean.baseBean.PageVo;

public interface SalaryService {

	PageVo<Map<String, Object>> getSalaryList(SalaryBean salaryBean);

	Map<String,Object> getUserInfoByUserId(int userId);
	
	public int updateSalary(SalaryBean salary);

	int sendSalaryByUserId(String userId);
}
