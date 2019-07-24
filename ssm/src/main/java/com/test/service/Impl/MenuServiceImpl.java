package com.test.service.Impl;

import com.test.bean.MenuBean;
import com.test.bean.ResourceBean;
import com.test.bean.User;
import com.test.dao.MenuBeanMapper;
import com.test.dao.ResourceBeanMapper;
import com.test.dao.UserMapper;
import com.test.service.MenuService;
import com.test.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl   extends BaseService implements MenuService{



	
	private ResourceBeanMapper resourceBeanMapper;
	private UserMapper userMapper;
	private MenuBeanMapper menuBeanMapper;
	@Override
	public List<MenuBean> selectMenu(Integer userId) {
		//查询出所有的父类菜单
		List<MenuBean> AllMenu = menuBeanMapper.selectAllMenu();
		//根据用户的id查出权限
		User user = userMapper.selectByPrimaryKey(userId);
		//然后根据权限查出当前用户的已有的而资源
		List<ResourceBean> allResoruce = resourceBeanMapper.selectbypermission(user.getRoles());
	
		List<MenuBean> MenuChildList=null;
		
		for (MenuBean menuBean : AllMenu) {
			List<MenuBean> menuchilelistnew = new ArrayList<MenuBean>();
			//查询出当前菜单下的每一个孩子
			 MenuChildList = menuBeanMapper.selectChild(menuBean.getId());
			 for (MenuBean menuBean1 : MenuChildList) {
			 for (ResourceBean resource:allResoruce) {
				 if(menuBean1.getUrl().equals(resource.getUrl())){
						//与当前用户中的资源进行比较，如果相等，说明已经存在该菜单，则将该菜单存放在一个新的list中
						menuchilelistnew.add(menuBean1);
						break;
					}
			   }
			 }	
			 menuBean.setChildrenMenu(menuchilelistnew);
		}
		List<MenuBean> menusList = new ArrayList<MenuBean>();
		for (MenuBean menuBean : AllMenu) {
			//此时的所有菜单是包含了它的孩子的菜单的，
			for (ResourceBean resource : allResoruce) {
				 if (!menuBean.getChildrenMenu().isEmpty()) {
					menusList.add(menuBean);
					break;
				 } 
				 if(menuBean.getUrl().equals(resource.getUrl())){
					 menusList.add(menuBean);
						break;
				 }
				}
		}
//		System.out.println(menusList.toString());
		return menusList;
	}
	
	
	
	
	public MenuBeanMapper getMenuBeanMapper() {
		return menuBeanMapper;
	}
	@Autowired
	public void setMenuBeanMapper(MenuBeanMapper menuBeanMapper) {
		this.menuBeanMapper = menuBeanMapper;
	}

	public ResourceBeanMapper getResourceBeanMapper() {
		return resourceBeanMapper;
	}
	@Autowired
	public void setResourceBeanMapper(ResourceBeanMapper resourceBeanMapper) {
		this.resourceBeanMapper = resourceBeanMapper;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}




	@Override
	public List<MenuBean> findMenu(Integer parentId) {
//		MenuBeanMapper mapper = readonlySQLSession.getMapper(MenuBeanMapper.class);
		List<MenuBean> MenuList = menuBeanMapper.findMenuByParentId(parentId);
		return MenuList;
	}
	
	
}
