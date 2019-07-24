package com.test.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.bean.PersonInfoBean;
import com.test.bean.User;
import com.test.service.PersonInfoService;
import com.test.service.UploadFileService;
import com.test.service.UserService;

@Controller
@RequestMapping("/person")
public class PersonInfoController extends BaseController {
	
	@Resource
	private PersonInfoService personInfoService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private UploadFileService uplaodFileService;
	
	@RequestMapping("/updatePersonInfo.do")
	@ResponseBody
	public int updatePersonInfo(PersonInfoBean person,Model model){
		return personInfoService.updatepersonInfo(person);		
	}
	
	@RequestMapping("/updatePersonInfoSend.do")
	public String updatePersonInfoSend(Model model){
		User user = getUser();
		PersonInfoBean personInfo = personInfoService.getPersonInfobyUserId(user.getUserId());
		model.addAttribute("personInfo", personInfo);
		return "user/personInfo";
	}
	
	@RequestMapping("/uploadImgtests.do")

	public String uploadImag(PersonInfoBean personInfo, Model model,HttpServletRequest request){
		MultipartFile file = personInfo.getFile();
		String fileName=file.getOriginalFilename();//获取文件名
		User user = getUser();
		String root=request.getSession().getServletContext().getRealPath("");
		String savePath=root+File.separator+"static"+File.separator+"upload"+File.separator+"Img";
		personInfo.setUserid(user.getUserId());
		 uplaodFileService.uploadImagFile(personInfo, fileName, savePath);
		 personInfoService.updateNoHead(personInfo);
		 return "redirect:updatePersonInfoSend.do";
	}
	
	

}
