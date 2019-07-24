package com.test.service;

import java.util.Map;

import com.test.bean.LeavePostBean;
import com.test.util.common.PageVo;

public interface LeavePostService {

	PageVo<Map<String, Object>> getleavePostList(LeavePostBean leavePostBean);

	int updateLeaveStatus(Integer userid, Integer leavestatus);

}
