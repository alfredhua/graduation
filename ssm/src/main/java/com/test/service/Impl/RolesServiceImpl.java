package com.test.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.MenuBean;
import com.test.bean.ResourceBean;
import com.test.bean.RolesBean;
import com.test.dao.MenuBeanMapper;
import com.test.dao.ResourceBeanMapper;
import com.test.dao.RolesBeanMapper;
import com.test.service.MenuService;
import com.test.service.RolesService;
import com.test.service.UserService;

@Service("rolesService")
public class RolesServiceImpl  extends BaseService implements RolesService{


	Logger logger = LoggerFactory.getLogger(RolesServiceImpl.class);
	 @Resource  
	 private MenuService menuService;
	 

	 @Resource
	 private UserService userSerice;
	 
	 private  RolesBeanMapper rolesBeanMapper;
	 private  ResourceBeanMapper resourceBeanMapper;
	 private  MenuBeanMapper menuBeanMapper;
	public List<MenuBean> findAllMenu(){
		List<MenuBean> menu = menuService.selectMenu(1);
		return menu;
		
	}

	@Override
	public List<RolesBean> findAllRoles() {
		List<RolesBean> roleList = rolesBeanMapper.findAllRoles();
		return roleList;
	}

	@Override
	public List<MenuBean> findMenu() {
		List<MenuBean> menus = menuService.findMenu(0); //查询出所有的一级标签		
		for (MenuBean menuBean : menus) {
			Integer id = menuBean.getId();
			menuBean.setChildrenMenu(menuService.findMenu(id));
		}
		return menus;
	}
	@Override
	public List<MenuBean> findALLMenu(String id) {
		List<MenuBean> menus = menuService.findMenu(0); //查询出所有的一级标签	
		
		return menus;
	}

	@Override
	public int addRoles(RolesBean role,String adIds) {				
		if (adIds != null) {
			String[] split = adIds.split(",");
			rolesBeanMapper.insert(role);
			for (String sourceId : split) {
				if(sourceId!=null||(!"".equals(sourceId))){
					MenuBean menuBean = menuBeanMapper.selectByPrimaryKey(Integer.parseInt(sourceId));
					//根据资源id查询出所有要添加的菜单，复制一份，只是资源的权限不同
					ResourceBean resource=new ResourceBean();				
					resource.setSourcename(menuBean.getName());
					resource.setUrl(menuBean.getUrl());
					resource.setRemark(menuBean.getRemark());
					resource.setCreatetime(new Date());
					resource.setPermission(role.getId().toString());
					resourceBeanMapper.insert(resource);
				}
			}
		}
		return 0;
	}

	@Override
	public int updateRoles(RolesBean role, String adIds) {
		//删除资源
		resourceBeanMapper.deleteByPerssion(role.getId());
		if (adIds != null) {
			String[] split = adIds.split(",");
			rolesBeanMapper.updateRole(role);
			for (String sourceId : split) {
				if(sourceId!=null||(!"".equals(sourceId))){
					MenuBean menuBean = menuBeanMapper.selectByPrimaryKey(Integer.parseInt(sourceId));
					//根据资源id查询出所有要添加的菜单，复制一份，只是资源的权限不同
					ResourceBean resource=new ResourceBean();				
					resource.setSourcename(menuBean.getName());
					resource.setUrl(menuBean.getUrl());
					resource.setRemark(menuBean.getRemark());
					resource.setCreatetime(new Date());
					resource.setPermission(role.getId().toString());
					resourceBeanMapper.insert(resource);
				}
			}
		}
		return 0;
	}
	
	@Override
	public Integer delRole(String id) {
		//先查询该角色下是否存在用户，不存在可以删除，存在返回0;
		List<Map<String,Object>> list = userSerice.queryByRoleId(id);
		if(list.isEmpty()){
			//删除角色
			Integer result = rolesBeanMapper.delRole(Integer.parseInt(id));
			//删除资源
			resourceBeanMapper.deleteByPerssion(Integer.parseInt(id));
			return result;
		}
		return 0;
	}


	public RolesBeanMapper getRolesBeanMapper() {
		return rolesBeanMapper;
	}
	@Autowired
	public void setRolesBeanMapper(RolesBeanMapper rolesBeanMapper) {
		this.rolesBeanMapper = rolesBeanMapper;
	}

	public ResourceBeanMapper getResourceBeanMapper() {
		return resourceBeanMapper;
	}
	@Autowired
	public void setResourceBeanMapper(ResourceBeanMapper resourceBeanMapper) {
		this.resourceBeanMapper = resourceBeanMapper;
	}

	public MenuBeanMapper getMenuBeanMapper() {
		return menuBeanMapper;
	}
	@Autowired
	public void setMenuBeanMapper(MenuBeanMapper menuBeanMapper) {
		this.menuBeanMapper = menuBeanMapper;
	}

	@Override
	public RolesBean queryRoleByid(String id) {
		RolesBean rolesBean = rolesBeanMapper.selectByRoleId(id);
		return rolesBean;
	}





	
}
