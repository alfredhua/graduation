package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.DepartmentBean;
import com.test.service.DepartmentService;

@Controller
@RequestMapping("/department") 
public class DepartmentController {
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	@Resource 
	private DepartmentService departmentService;
	 
	
	 /**
	  * 删除指定的部门，可以多个一起删除
	  * @param department
	  * @param model
	  * @return
	  */
	@RequestMapping(value="/deleteDepartment.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int deleteDepartment(@RequestParam("IdArray") String IdArray){	
		int deleteDepartment = departmentService.deleteDepartment(IdArray);
		return deleteDepartment;
	}
	
	 /**
	  * 获取部门列表
	  * @param department
	  * @param model
	  * @return
	  */
	@RequestMapping(value="/departmentList.do",method={RequestMethod.GET,RequestMethod.POST})
	public String departmentList(@ModelAttribute DepartmentBean department,Model model){	
		DepartmentBean selectdepartment = departmentService.queryAllDepartment(department);
		logger.info("查询结果:"+selectdepartment.getPageVo().getVoList().size());
		model.addAttribute("departmentTwo", selectdepartment);
		return "department/departmentList";
	}
	
	/**
	 * 异步交互，获取部门列表，下拉菜单
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getdepartmentList.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<DepartmentBean> getdepartmentList(Model model){	
		model.addAttribute("department", departmentService.queryDepartment());
		return departmentService.queryDepartment();
	}
	
	/**
	 * 添加部门
	 * @param department
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addDepartment.do",method=RequestMethod.POST)
	@ResponseBody
	public int addDepartment(@ModelAttribute DepartmentBean department,Model model){	
		 int result = departmentService.insertDepartment(department);
		 return result;
	}
	
	/**
	 * 更新部门
	 * @param department
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updateDepartment.do",method=RequestMethod.POST)
	@ResponseBody
	public int updateDepartment(@ModelAttribute DepartmentBean department,Model model){	
		 int result = departmentService.updateDepartment(department);
		 return result;
	}
	
	/**
	 * 更新列表中，获取其中一个部门的信息
	 * @param department
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getDepartmentById.do",method=RequestMethod.POST)
	@ResponseBody
	public List<DepartmentBean> getDepartmentById(@RequestParam("departmentId") Integer departmentId){	
		 DepartmentBean departmentOne = 
				 departmentService.getDepartmentById(departmentId);
		 List<DepartmentBean> list=new ArrayList<DepartmentBean>();
		 list.add(departmentOne);
		 return list;
	}
	
	/**
	 * 添加部门时，检查是否存在部门名称和编号
	 * @param department
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/existAddDepartment.do",method=RequestMethod.POST )
	 @ResponseBody 
	public int existAddDepartment(@ModelAttribute DepartmentBean department,Model model){	
		int existAddDepartment = departmentService.existAddDepartment(
				department.getDepartmentId(),department.getDepartmentName());
		model.addAttribute("existAddDepartment", existAddDepartment);
		return existAddDepartment;
	}
}
