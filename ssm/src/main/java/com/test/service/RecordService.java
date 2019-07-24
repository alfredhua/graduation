package com.test.service;

import java.util.Map;

import com.test.bean.RecordBean;
import com.test.bean.baseBean.PageVo;

public interface RecordService {
	
	public int addRecord(RecordBean record);

	public PageVo<Map<String, Object>> getRecordList(RecordBean recordBean);

	public Map<String, Object> getRecordById(Integer id);

	public int updateStatus(String idArray,String status);

}
