package com.test.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bean.PersonInfoBean;
import com.test.bean.User;
import com.test.service.PersonInfoService;
import com.test.service.UserService;

@Controller
@RequestMapping("/admin")
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private UserService userService;
	@Resource
	private PersonInfoService personInfoService;
	@RequestMapping("/login")
	public String login(User user, Model model) {
		if (user.getUserName() == null&&user.getPassword()==null) {
			return "login";
		} else {
			    Subject subject = SecurityUtils.getSubject();
				UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
				try {
					subject.login(token);
					Session session = subject.getSession();
					 User user2 = userService.getUserByUserName(user.getUserName());
					session.setAttribute("user",user2);
					PersonInfoBean personInfo = personInfoService.getPersonInfobyUserId(user2.getUserId());
					session.setAttribute("personInfo", personInfo);
					return "redirect:/user/index.do";
				} catch (Exception e) {			
					model.addAttribute("errorMsg", "用户名或密码错误");
					return "login";
				}
		
		}
	}
	@RequestMapping("/logout.do")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

}
