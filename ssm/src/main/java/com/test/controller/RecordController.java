package com.test.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.RecordBean;
import com.test.bean.User;
import com.test.bean.baseBean.PageVo;
import com.test.service.RecordService;

@Controller
@RequestMapping("/record")
public class RecordController extends BaseController{
	
	@Resource
	private RecordService recordService;

	@RequestMapping("addRecord.do")
	public String addRecord(){	
		return "record/addRecord";
	}
	
	@RequestMapping("saveRecord.do")
	public String saveRecord(RecordBean record,Model model){
		recordService.addRecord(record);		
		return "redirect:selectRrcordUserId.do";
	}
	
	@RequestMapping("selectRrcord.do")
	public String getRecordList(RecordBean record,Model model){
		PageVo<Map<String, Object>> pageVo=new PageVo<Map<String, Object>>();
		pageVo=recordService.getRecordList(record);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("record", record);
		return "record/recordList";
	}
	
	@RequestMapping("selectRrcordUserId.do")
	public String getRecordByUserId(RecordBean record,Model model){
		PageVo<Map<String, Object>> pageVo=new PageVo<Map<String, Object>>();
		User user = getUser();
		record.setUserid(user.getUserId());
		pageVo=recordService.getRecordList(record);
		model.addAttribute("pageVo", pageVo);
		return "record/ownRecord";
	}
	@RequestMapping("getRecordById.do")
	public String getRecordById(RecordBean record,Model model){
		 Map<String, Object> map = recordService.getRecordById(record.getId());
		model.addAttribute("map", map);
		return "record/recordDetail";
	}
	
	@RequestMapping("updateStatus.do")
	@ResponseBody
	public int updateStatus(String idArray,String status,Model model){
		int i = recordService.updateStatus(idArray,status);
		return i;
	}
	
}
