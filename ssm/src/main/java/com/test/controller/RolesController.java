package com.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.MenuBean;
import com.test.bean.ResourceBean;
import com.test.bean.RolesBean;
import com.test.service.MenuService;
import com.test.service.ResourceService;
import com.test.service.RolesService;

@Controller
@RequestMapping("/role")
public class RolesController {

	@Resource
	private RolesService rolesService;
	@Resource
	private ResourceService  resourceService;
	
	@Resource
	private MenuService menuService;

	@RequestMapping(value="/rolesList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getAllRoles(Model model) {
		List<RolesBean> roleList = rolesService.findAllRoles();
		model.addAttribute("roleList", roleList);
		return "roles/rolesList";
	}

	/**
	 * 跳转到角色添加的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addRoleSend.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String addRoleSend(Model model) {
		List<MenuBean> menus = rolesService.findMenu();
		model.addAttribute("menus", menus);
		return "roles/addRoles";
	}

	/**
	 *角色添加
	 * @return
	 */
	@RequestMapping(value = "/saveRole.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String addRole(Model model, RolesBean role, @RequestParam("adIds") String adIds) {
		if(role.getId()!=null){
			//执行修改的方法
			int result=rolesService.updateRoles(role, adIds);
			model.addAttribute("result", result);
		}else{
			//执行加入的方法
		  int result = rolesService.addRoles(role, adIds);
			model.addAttribute("result", result);
		}
		return "roles/rolesList";
	}
	

	/**
	 *角色删除
	 * @return
	 */
	@RequestMapping(value = "/delRole.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public int delRole(Model model,@RequestParam("id") String id) {
		Integer delRole = rolesService.delRole(id);		
		return delRole;
	}
	/**
	 *角色更新
	 * @return
	 */
	@RequestMapping(value = "/updateRoleSend.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateRoleSend(Model model,@RequestParam("id") String id) {
		List<MenuBean> menus = rolesService.findALLMenu(id);
		RolesBean role = rolesService.queryRoleByid(id);
		List<ResourceBean> resource = resourceService.findResourceByPermission(Integer.parseInt(id));
		model.addAttribute("menus", menus);
		model.addAttribute("role", role);
		model.addAttribute("resource", resource);
		return "roles/updateRole";
	}
	
//	/**
//	 *角色更新
//	 * @return
//	 */
//	@RequestMapping(value = "/updateRole.do", method = { RequestMethod.GET, RequestMethod.POST })
//	public String updateRole(Model model,@RequestParam("id") String id) {
//		List<MenuBean> menus = rolesService.findALLMenu(id);
//		List<ResourceBean> resource = resourceService.findResourceByPermission(Integer.parseInt(id));
//		model.addAttribute("menus", menus);
//		model.addAttribute("resource", resource);
//		return "roles/updateRole";
//	}
//	

	public RolesService getRolesService() {
		return rolesService;
	}
	@Resource
	public void setRolesService(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	
	public MenuService getMenuService() {
		return menuService;
	}
	@Resource
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	
	public ResourceService getResourceService() {
		return resourceService;
	}
	@Resource
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	
	

}
