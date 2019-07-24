package com.test.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.bean.SalaryBean;
import com.test.bean.SalaryBottleBean;
import com.test.bean.baseBean.PageVo;
import com.test.dao.SalaryBeanMapper;
import com.test.dao.SalaryBottleBeanMapper;
import com.test.service.SalaryService;
import com.test.service.StaticDefault;

import javax.annotation.Resource;

@Service("salaryService")
public class SalaryServiceImpl   extends BaseService implements SalaryService {

	private SalaryBeanMapper salaryMapper;
	
	private SalaryBottleBeanMapper sbMapper;

	@Override
	public PageVo<Map<String, Object>> getSalaryList(SalaryBean salaryBean) {
		Map<String,Object> map=new HashMap<String,Object>();
		if(salaryBean.getCurrentPage()==null){
			salaryBean.setCurrentPage(StaticDefault.pageCurrent);
		}
		if(salaryBean.getPageSize()==null){
			salaryBean.setPageSize(StaticDefault.pageSize);
		}
		PageVo<Map<String, Object>> pageVo=new PageVo<Map<String,Object>>();
		pageVo.setCurrentPage(salaryBean.getCurrentPage());
		pageVo.setPageSize(salaryBean.getPageSize());
		List<Map<String, Object>> salaryList = salaryMapper.querySalaryListByPage(map,(salaryBean.getCurrentPage()-1)*salaryBean.getPageSize(),
				salaryBean.getCurrentPage()*salaryBean.getPageSize());
		int count = salaryMapper.querySalaryListCount(map);
		pageVo.setVoList(salaryList);
		pageVo.setPageCount(count);
		return pageVo;
	}
	

	@Override
	public int sendSalaryByUserId(String userId) {
		SalaryBean salaryBean = salaryMapper.selectByPrimaryKey(Integer.parseInt(userId));
		SalaryBottleBean salaryBottle=new SalaryBottleBean();
		salaryBottle.setUserid(Integer.parseInt(userId));
		salaryBottle.setBasic(salaryBean.getBasic());
		salaryBottle.setEat(salaryBean.getEat());
		salaryBottle.setDuty(salaryBean.getDuty());
		salaryBottle.setTotalize(salaryBean.getTotalize());
		salaryBottle.setGranttime(new Date());
		salaryBottle.setScot(salaryBean.getScot());
		salaryBottle.setPunishment(salaryBean.getPunishment());
		salaryBottle.setStatus(1);
		int i = sbMapper.insert(salaryBottle);
		if(i>0){
			return i;
		}
		return 0;
	}

	
	@Override
	public Map<String,Object> getUserInfoByUserId(int userId) {		
		return salaryMapper.getUserInfoByUserId(userId);
	}
	
	public int updateSalary(SalaryBean salary){
		salary.setCreatetime(new Date());
		int i = salaryMapper.updateByUserId(salary);
		if(i>0){
			return i;
		}
		return 0;		
	}

	public SalaryBeanMapper getSalaryMapper() {
		return salaryMapper;
	}

	@Autowired
	public void setSalaryMapper(SalaryBeanMapper salaryMapper) {
		this.salaryMapper = salaryMapper;
	}


	public SalaryBottleBeanMapper getSbMapper() {
		return sbMapper;
	}

	@Autowired
	public void setSbMapper(SalaryBottleBeanMapper sbMapper) {
		this.sbMapper = sbMapper;
	}
	
	

}
