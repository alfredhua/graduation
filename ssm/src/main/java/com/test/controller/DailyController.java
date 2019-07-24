package com.test.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.DailyBean;
import com.test.bean.User;
import com.test.service.DailyService;
import com.test.util.common.PageVo;

@Controller
@RequestMapping("/daily")
public class DailyController {
	Logger logger = LoggerFactory.getLogger(DailyController.class);
	
	@Resource 
	private DailyService dailyService;
	
	@RequestMapping(value=("/selectDaily.do"),method={RequestMethod.GET,RequestMethod.POST})
	public String getdailyList(DailyBean daily,Model model){
		 PageVo<Map<String, Object>> pageVo=new  PageVo<Map<String,Object>>();
		 Subject subject = SecurityUtils.getSubject();
		 Session session = subject.getSession();
		 User user = (User) session.getAttribute("user");
		 daily.setUserid(user.getUserId());
		 pageVo=dailyService.getDailyListByUserId(daily);
		 model.addAttribute("pageVo", pageVo);
		 model.addAttribute("daily", daily);
		return "daily/dailyList";
	}
	
	@RequestMapping(value=("/addDaily.do"),method={RequestMethod.GET,RequestMethod.POST})
	public String addDailySend(){
		return "daily/addDaily";
	}
	@RequestMapping(value=("/addDailyForm.do"),method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer addDaily(DailyBean entity,Model model){
		return dailyService.addDaily(entity);
	}
	
	@RequestMapping(value=("/existDate.do"),method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer existDateDaily(DailyBean entity,Model model){
	  return dailyService.existDateDaily(entity);
	}
	
	@RequestMapping(value=("/exportDaily.do"),method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public void exportDaily(DailyBean entity,Model model){
	   dailyService.exportDaily(entity);
	}

}
