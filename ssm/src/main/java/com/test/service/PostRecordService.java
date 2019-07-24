package com.test.service;

import java.util.Map;

import com.test.bean.LeavePostBean;
import com.test.bean.PostRecordBean;
import com.test.util.common.PageVo;

public interface PostRecordService {
	
	public int insertPostRecord(PostRecordBean postRecordBean);

	public PageVo<Map<String, Object>> getPostRecordList(PostRecordBean postRecord);

	public int addLeavePost(LeavePostBean leavePostBean);

	public Map<String, Object> watchLeavePost(int userid);
}
