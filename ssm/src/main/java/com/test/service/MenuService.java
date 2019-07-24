package com.test.service;

import java.util.List;

import com.test.bean.MenuBean;


public interface MenuService {
	
	public  List<MenuBean> selectMenu(Integer userId);
	
	public  List<MenuBean> findMenu(Integer parentId);
}
