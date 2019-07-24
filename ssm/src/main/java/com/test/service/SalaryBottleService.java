package com.test.service;

import java.util.Map;

import com.test.bean.SalaryBottleBean;
import com.test.bean.baseBean.PageVo;

public interface SalaryBottleService {

	PageVo<Map<String, Object>> getSalaryBottleByUserId(SalaryBottleBean salaryBottle);

}
