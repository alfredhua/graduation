package com.test.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.MessageBean;
import com.test.bean.User;
import com.test.bean.User2;
import com.test.service.MessageService;
import com.test.service.UserService;
import com.test.util.common.PageVo;

@Component
@RequestMapping("message")
public class MessageController extends BaseController{

	@Resource
	private UserService userService;
	
	@Resource
	private MessageService messageService;

	@RequestMapping(value = ("/sendMessage.do"), method = { RequestMethod.GET, RequestMethod.POST })
	public String getAllUsers(User2 user2, Model model) {
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo = userService.queryAllUser(user2);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("us", user2);
		return "message/message";
	}

	@RequestMapping(value = ("/sendMessageTo.do"), method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public int sendMessageTo(@Param("idArray") String idArray,@Param("context") String context, Model model) {
		User user = getUser();
		return messageService.sendMessageTo(idArray,context,user.getUserId());
	}
	
	@RequestMapping(value = ("/messageList.do"), method = { RequestMethod.GET, RequestMethod.POST })
	public String messageList(MessageBean messageBean,Model model) {
		User user = getUser();
		messageBean.setReviceid(user.getUserId());
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo=messageService.getMessageList(messageBean);
		model.addAttribute("pageVo", pageVo);
		return "message/messageList";
	}
	
	@RequestMapping(value = ("/watchMessage.do"), method = { RequestMethod.GET, RequestMethod.POST })
	public String getOneMessage(MessageBean message, Model model) {
		messageService.updateStatusById(message.getId());
		MessageBean message2=messageService.getMessagebyId(message.getId());
		model.addAttribute("message", message2);
		return "message/messageDetail";
	}

}
