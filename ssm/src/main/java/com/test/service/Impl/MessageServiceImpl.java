package com.test.service.Impl;

import com.test.bean.MessageBean;
import com.test.dao.MessageBeanMapper;
import com.test.service.MessageService;
import com.test.service.StaticDefault;
import com.test.service.base.BaseService;
import com.test.util.common.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("messageService")
public class MessageServiceImpl   extends BaseService implements MessageService{

	private MessageBeanMapper messageBeanMapper;

	public MessageBeanMapper getMessageBeanMapper() {
		return messageBeanMapper;
	}
	@Resource
	public void setMessageBeanMapper(MessageBeanMapper messageBeanMapper) {
		this.messageBeanMapper = messageBeanMapper;
	}
	@Override
	public int sendMessageTo(String idArray, String context, Integer sendId) {
		String subidArray = idArray.substring(0,idArray.length()-1);
		String[] userId = subidArray.split(",");
		int j=0;
		for (int i = 0; i < userId.length; i++) {
			MessageBean message=new MessageBean();
			message.setDelettype(1);//表示未删除
			message.setSenddate(new Date());
			message.setReviceid(Integer.parseInt(userId[i]));
			message.setReadstate(1);//表示未读
			message.setSendid(sendId);//发送者id
			message.setContext(context);
			messageBeanMapper.insert(message);
			j++;			
		}
		return j;
	}
	@Override
	public PageVo<Map<String, Object>> getMessageList(MessageBean messageBean) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("reviceid", messageBean.getReviceid());
		if(messageBean.getCurrentPage()==null){
			messageBean.setCurrentPage(StaticDefault.pageCurrent);
		}
		if(messageBean.getPageSize()==null){
			messageBean.setPageSize(StaticDefault.pageSize);
		}
		PageVo<Map<String, Object>> pageVo=new PageVo<Map<String, Object>>();
		pageVo.setCurrentPage(messageBean.getCurrentPage());
		pageVo.setPageSize(messageBean.getPageSize());
		
		List<Map<String,Object>> list=messageBeanMapper.getMessageList(
					map,(pageVo.getCurrentPage()-1)*pageVo.getPageSize(),pageVo.getCurrentPage()*pageVo.getPageSize());
		int count=messageBeanMapper.getMessageCount(map);
		pageVo.setVoList(list);
		pageVo.setTotal(count);
		return pageVo;
	}
	@Override
	public MessageBean getMessagebyId(Integer id) {	
		return 	messageBeanMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateStatusById(Integer id) {		
		return messageBeanMapper.updateStatusById(id);
	}
	@Override
	public List<Map<String, Object>> getMessagByuserId(Integer userId) {
		List<Map<String, Object>>  map=messageBeanMapper.getMessagByuserId(userId);
		return map;
	}
	@Override
	public int getMessageCountByuserId(Integer userId) {		
		return messageBeanMapper.getMessageCountByuserId(userId);
	}

}








