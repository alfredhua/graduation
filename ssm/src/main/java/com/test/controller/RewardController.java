package com.test.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.RespectBinding;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.PrizeAndpublishBean;
import com.test.bean.User2;
import com.test.service.RewardService;
import com.test.service.UserService;
import com.test.util.common.PageVo;

@Component
@RequestMapping("money")
public class RewardController {
	
	@Resource
	private RewardService  rewardService;
	
	@Resource
	private UserService userService;
	@RequestMapping("sendMoney.do")
	public String getUserList(User2 user2,Model model){
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo = userService.queryAllUser(user2);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("us", user2);
		return "reward/rewardUser";
	}
	
	
	@RequestMapping("sendWelfare.do")
	@ResponseBody
	public int sendWelfare(PrizeAndpublishBean prizeAndpublishBean,@Param("idArray")String idArray,Model model){
	int a=rewardService.sendWelfare(prizeAndpublishBean,idArray);
		return a;
	}
	@RequestMapping(value = ("getRewardList.do"), method = { RequestMethod.GET, RequestMethod.POST })
	public String getRewardList(PrizeAndpublishBean prizeAndpublishBean,Model model){
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		prizeAndpublishBean.setPtype(1);
		pageVo = rewardService.getRewardList(prizeAndpublishBean);
		model.addAttribute("pageVo",pageVo);
		model.addAttribute("prizeAndpublishBean",prizeAndpublishBean);
		return "reward/rewardList";
	}
	
	@RequestMapping("getPublish.do")
	public String getPublish(PrizeAndpublishBean prizeAndpublishBean,Model model){
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		prizeAndpublishBean.setPtype(0);
		pageVo = rewardService.getRewardList(prizeAndpublishBean);
		model.addAttribute("pageVo",pageVo);
		model.addAttribute("prizeAndpublishBean",prizeAndpublishBean);
		return "reward/publishList";
	}
}
