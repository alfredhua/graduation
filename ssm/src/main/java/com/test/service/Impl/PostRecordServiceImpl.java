package com.test.service.Impl;

import com.test.bean.LeavePostBean;
import com.test.bean.PostRecordBean;
import com.test.dao.LeavePostBeanMapper;
import com.test.dao.PostRecordBeanMapper;
import com.test.service.PostRecordService;
import com.test.service.StaticDefault;
import com.test.service.base.BaseService;
import com.test.util.common.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("postRecordService")
public class PostRecordServiceImpl   extends BaseService implements PostRecordService{

	private PostRecordBeanMapper postRecordBeanMapper;
	
	private LeavePostBeanMapper leavePostBeanMapper;
	
	@Override
	public int insertPostRecord(PostRecordBean postRecordBean) {
		int i = postRecordBeanMapper.insert(postRecordBean);
		return i;
	}

	public PostRecordBeanMapper getPostRecordBeanMapper() {
		return postRecordBeanMapper;
	}
	
	@Autowired
	public void setPostRecordBeanMapper(PostRecordBeanMapper postRecordBeanMapper) {
		this.postRecordBeanMapper = postRecordBeanMapper;
	}

	public LeavePostBeanMapper getLeavePostBeanMapper() {
		return leavePostBeanMapper;
	}
	@Autowired
	public void setLeavePostBeanMapper(LeavePostBeanMapper leavePostBeanMapper) {
		this.leavePostBeanMapper = leavePostBeanMapper;
	}

	@Override
	public PageVo<Map<String, Object>> getPostRecordList(PostRecordBean postRecord) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("userName", postRecord.getUserName());
		map.put("realName", postRecord.getRealName());
		PageVo<Map<String, Object>> pageVo=new PageVo<Map<String, Object>>();
		if(postRecord.getPageSize() == null){
			postRecord.setPageSize(StaticDefault.pageSize);
		}
		if(postRecord.getCurrentPage() == null){
			postRecord.setCurrentPage(StaticDefault.pageCurrent);
		}
		pageVo.setCurrentPage(postRecord.getCurrentPage());
		pageVo.setPageSize(postRecord.getPageSize());
		List<Map<String, Object>> postRecordList = postRecordBeanMapper.getPostRecordList(map,
				(pageVo.getCurrentPage()-1)*pageVo.getPageSize(),pageVo.getCurrentPage()*pageVo.getPageSize());
		int count = postRecordBeanMapper.getPostRecordCount(map);
		pageVo.setVoList(postRecordList);
		pageVo.setTotal(count);
		return pageVo;
	}

	@Override
	public int addLeavePost(LeavePostBean leavePostBean) {
		leavePostBean.setLeavestatus(0);
		leavePostBeanMapper.insert(leavePostBean);
		return 0;
	}

	@Override
	public Map<String, Object> watchLeavePost(int userid) {
		 Map<String, Object> map=leavePostBeanMapper.watchLeavePost(userid);
		return map;
	}
	
	

}
