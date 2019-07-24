package com.test.service;

import java.util.List;

import com.test.bean.MenuBean;
import com.test.bean.RolesBean;

public interface RolesService {
	
	List<MenuBean> findAllMenu();
	
	List<MenuBean> findMenu();
	
	int addRoles(RolesBean role,String adIds);
	
	List<RolesBean> findAllRoles();

	Integer delRole(String id);

	List<MenuBean> findALLMenu(String id);

	int updateRoles(RolesBean role, String adIds);

	RolesBean queryRoleByid(String id);
	
	
}
