package com.test.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.SalaryBean;
import com.test.bean.baseBean.PageVo;
import com.test.service.SalaryService;
import com.test.service.UserService;

@Component
@RequestMapping("/salary")
public class SalaryController {
	Logger logger = LoggerFactory.getLogger(SalaryController.class);
	@Resource
	private SalaryService salaryService;

	@Resource
	private UserService userService;

	@RequestMapping("updateSalarySend.do")
	public String updateSalarySend(String userId, Model model) {
		logger.info("开始获取员工的工资信息:" + userId);
		Map<String, Object> map = salaryService.getUserInfoByUserId(Integer.parseInt(userId));
		model.addAttribute("map", map);
		return "salary/addSalary";
	}

	@RequestMapping("updateSalary.do")
	public String updateSalary(SalaryBean salary, Model model) {
		logger.info("开始更新工资信息:" + salary.getUserid());
		salaryService.updateSalary(salary);
		return "redirect:getSalaryList.do";
	}

	@RequestMapping("getSalaryList.do")
	public String getSalaryList(SalaryBean salaryBean, Model model) {
		PageVo<Map<String, Object>> pageVo = salaryService.getSalaryList(salaryBean);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("salaryBean", salaryBean);// 查询回显
		return "salary/salaryList";
	}
	
	@RequestMapping("sendSalary.do")
	@ResponseBody
	public int sendSalary(String userId, Model model) {
		salaryService.sendSalaryByUserId(userId);
		return 1;
	}

}
