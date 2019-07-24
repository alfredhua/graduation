package com.test.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.test.bean.LeavePostBean;
import com.test.dao.LeavePostBeanMapper;
import com.test.service.LeavePostService;
import com.test.service.StaticDefault;
import com.test.service.UserService;
import com.test.util.common.PageVo;

@Service("leavePostService")
public class LeavePostServiceImpl  extends BaseService implements LeavePostService {

	private LeavePostBeanMapper leavePostBeanMapper;	
	public LeavePostBeanMapper getLeavePostBeanMapper() {
		return leavePostBeanMapper;
	}
	@Resource
	public void setLeavePostBeanMapper(LeavePostBeanMapper leavePostBeanMapper) {
		this.leavePostBeanMapper = leavePostBeanMapper;
	}
	
	@Resource
	private UserService userService;



	@Override
	public PageVo<Map<String, Object>> getleavePostList(LeavePostBean leavePostBean) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName", leavePostBean.getUserName());
		map.put("realName", leavePostBean.getRealName());
		map.put("leaveTimeSart", leavePostBean.getLeaveTimeStart());
		map.put("leaveTimeEnd", leavePostBean.getLeaveTimeEnd());
		if(leavePostBean.getCurrentPage()==null){
			leavePostBean.setCurrentPage(StaticDefault.pageCurrent);
		}
		if(leavePostBean.getPageSize()==null){
			leavePostBean.setPageSize(StaticDefault.pageSize);
		}
		PageVo<Map<String,Object>> pageVo=new PageVo<Map<String,Object>>();
		pageVo.setCurrentPage(leavePostBean.getCurrentPage());
		pageVo.setPageSize(leavePostBean.getPageSize());
		List<Map<String,Object>> list=leavePostBeanMapper.getleavePostList(map,
				(pageVo.getCurrentPage()-1)*pageVo.getPageSize(),pageVo.getCurrentPage()*pageVo.getPageSize());
		int count=leavePostBeanMapper.getleavePostCount(map);
		pageVo.setVoList(list);
		pageVo.setTotal(count);	
		return pageVo;
	}
	@Override
	public int updateLeaveStatus(Integer userid, Integer leavestatus) {	
		userService.updateStatus(userid, leavestatus);
		return leavePostBeanMapper.updateLeaveStatus(userid,leavestatus);
	}

}
