package com.test.service.Impl;

import com.test.bean.DailyBean;
import com.test.dao.DailyBeanMapper;
import com.test.service.DailyService;
import com.test.service.ExportDailyService;
import com.test.service.StaticDefault;
import com.test.service.base.BaseService;
import com.test.util.common.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dailyService")
public class DailyServiceImpl extends BaseService implements DailyService {

	private DailyBeanMapper dailyMapp;
	@Resource 
	private ExportDailyService exportDailyService;
	
	@Override
	public int addDaily(DailyBean entity) {
		int i = dailyMapp.insertSelective(entity);
		if (i > 0) {
			return i;
		} else {
			return 0;
		}
	}

	@Override
	public Integer existDateDaily(DailyBean entity) {
		List<DailyBean> list = dailyMapp.queryByUserIdandDate(entity);
		if (!list.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public PageVo<Map<String, Object>> getDailyListByUserId(DailyBean daily) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", daily.getUserid());
		map.put("workDateStart", daily.getWorkDateStart());
		map.put("workDateEnd", daily.getWorkDateEnd());
		if(daily.getCurrentPage()==null){
			daily.setCurrentPage(StaticDefault.pageCurrent);//设置当前页为1
		}
		if(daily.getPageSize()==null){
			daily.setPageSize(StaticDefault.pageSize);//设置页面的大小
		}
		List<Map<String, Object>> dailyList = dailyMapp.queryDailyListByUserId(map,
				(daily.getCurrentPage() - 1) * daily.getPageSize(), daily.getPageSize());
		int total=dailyMapp.queryDailyListCountByUserId(map);
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo.setVoList(dailyList);
		pageVo.setTotal(total);
		pageVo.setPageSize(daily.getPageSize());
		pageVo.setCurrentPage(daily.getCurrentPage());
		return pageVo;
	}

	public DailyBeanMapper getDailyMapp() {
		return dailyMapp;
	}

	@Resource
	public void setDailyMapp(DailyBeanMapper dailyMapp) {
		this.dailyMapp = dailyMapp;
	}

	@Override
	public void exportDaily(DailyBean daily) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", daily.getUserid());
		map.put("workDateStart", daily.getWorkDateStart());
		map.put("workDateEnd", daily.getWorkDateEnd());
		List<Map<String, Object>> dailyList = dailyMapp.queryDailyListByUserIdNoPage(map);
		exportDailyService.downExcel(dailyList, "/Users/hua/Downloads/daily.xls");
	}

}
