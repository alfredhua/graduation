package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.bean.MessageBean;
import com.test.util.common.PageVo;

public interface MessageService {

	int sendMessageTo(String idArray, String context, Integer sendId);

	PageVo<Map<String, Object>> getMessageList(MessageBean messageBean);

	MessageBean getMessagebyId(Integer id);

	int updateStatusById(Integer id);

	List<Map<String, Object>> getMessagByuserId(Integer userId);

	int getMessageCountByuserId(Integer userId);
	
	

}
