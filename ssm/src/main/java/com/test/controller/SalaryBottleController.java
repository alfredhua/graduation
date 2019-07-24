package com.test.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bean.SalaryBottleBean;
import com.test.bean.baseBean.PageVo;
import com.test.service.SalaryBottleService;

@Component
@RequestMapping("salary")
public class SalaryBottleController {
	
	@Resource
	private SalaryBottleService SalaryBottleService;
	
	@RequestMapping("getSalaryBottle.do")
	public String getSalaryBottleByUserId(SalaryBottleBean salaryBottle,Model model){
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		 pageVo=SalaryBottleService.getSalaryBottleByUserId(salaryBottle);
		model.addAttribute("pageVo", pageVo);
		return "salary/salaryBottle";
	}

}
