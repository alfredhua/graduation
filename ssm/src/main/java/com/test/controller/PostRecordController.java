package com.test.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.LeavePostBean;
import com.test.bean.PostRecordBean;
import com.test.service.LeavePostService;
import com.test.service.PostRecordService;
import com.test.util.common.PageVo;

@Component
@RequestMapping("postRecord")
public class PostRecordController {
	@Resource
	private PostRecordService  postRecordService;
	
	@Resource
	private LeavePostService leavePostService;
	
	@RequestMapping("postRecordList.do")
	public String getPostRecordList(PostRecordBean postRecord,Model model){
		PageVo<Map<String, Object>> pageVo=postRecordService.getPostRecordList(postRecord);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("postRecord", postRecord);
		return "postRecord/postRecordList";
	}
	
	@RequestMapping("leavePost.do")
	public String addLeavePostSend(){
		return "postRecord/leavePost";
	}
	
	@RequestMapping("addleavePost.do")
	public String addLeavePost(LeavePostBean leavePostBean){
		postRecordService.addLeavePost(leavePostBean);
		return "redirect:leavePostList.do";
	}

	@RequestMapping("leavePostList.do")
	public String getleavePostListList(LeavePostBean leavePostBean,Model model){
		PageVo<Map<String, Object>> pageVo=leavePostService.getleavePostList(leavePostBean);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("leavePostBean", leavePostBean);
		return "postRecord/leavePostList";
	}
	
	@RequestMapping("passLeavePost.do")
	@ResponseBody
	public int applyleavePost(LeavePostBean leavePostBean,Model model){
		int i=leavePostService.updateLeaveStatus(leavePostBean.getUserid(),leavePostBean.getLeavestatus());
		return i;
	}
	

		
		@RequestMapping("watchLeavePost.do")
	public String watchLeavePost(@Param("userid")int userid,Model model){
		Map<String, Object> map = postRecordService.watchLeavePost(userid);
		model.addAttribute("map", map);
		return "postRecord/watchLeavePost";
	}
	 
}
