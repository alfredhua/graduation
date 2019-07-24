package com.test.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.SalaryBottleBean;
import com.test.bean.baseBean.PageVo;
import com.test.dao.SalaryBottleBeanMapper;
import com.test.service.SalaryBottleService;
import com.test.service.StaticDefault;

import javax.annotation.Resource;

@Service("salaryBottlerService")
public class SalaryBottleServiceImpl  extends BaseService implements SalaryBottleService{

	Logger logger = LoggerFactory.getLogger(SalaryBottleServiceImpl.class);
	
	private SalaryBottleBeanMapper salaryBottleBeanMapper;
	@Override
	public PageVo<Map<String, Object>> getSalaryBottleByUserId(SalaryBottleBean salaryBottle) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId", salaryBottle.getUserid());
		if(salaryBottle.getCurrentPage()==null){
			salaryBottle.setCurrentPage(StaticDefault.pageCurrent);
		}
		if(salaryBottle.getPageSize()==null){
			salaryBottle.setPageSize(StaticDefault.pageSize);
		}
		PageVo<Map<String, Object>> pageVo=new PageVo<Map<String, Object>>();
		pageVo.setCurrentPage(salaryBottle.getCurrentPage());
		pageVo.setPageSize(salaryBottle.getPageSize());
		List<Map<String,Object>> salaryBottkleList=salaryBottleBeanMapper.getSalaryBottleByUserId(map,
				(pageVo.getCurrentPage()-1)*pageVo.getPageSize(),pageVo.getCurrentPage()*pageVo.getPageSize());
		int count =salaryBottleBeanMapper.getSalaryBottleCount(map);
		pageVo.setVoList(salaryBottkleList);
		pageVo.setTotal(count);
		return pageVo;
	}
	public SalaryBottleBeanMapper getSalaryBottleBeanMapper() {
		return salaryBottleBeanMapper;
	}
	@Autowired
	public void setSalaryBottleBeanMapper(SalaryBottleBeanMapper salaryBottleBeanMapper) {
		this.salaryBottleBeanMapper = salaryBottleBeanMapper;
	}
	
	

}
