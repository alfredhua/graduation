package com.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import com.test.bean.User;

@Controller
public class BaseController {

	public User getUser(){
		 Subject subject = SecurityUtils.getSubject();
		 Session session = subject.getSession();
		 User user = (User) session.getAttribute("user");
		return user;
	}
}
