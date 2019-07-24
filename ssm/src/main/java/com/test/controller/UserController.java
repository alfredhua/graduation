package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.DailyBean;
import com.test.bean.DepartmentBean;
import com.test.bean.EmployeeStatusBean;
import com.test.bean.MessageBean;
import com.test.bean.PostBean;
import com.test.bean.RolesBean;
import com.test.bean.SalaryBottleBean;
import com.test.bean.User;
import com.test.bean.User2;
import com.test.service.DailyService;
import com.test.service.DepartmentService;
import com.test.service.EmployeeStatusService;
import com.test.service.MessageService;
import com.test.service.PostService;
import com.test.service.RolesService;
import com.test.service.SalaryBottleService;
import com.test.service.UserService;
import com.test.util.common.PageVo;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;

	@Resource
	private EmployeeStatusService employeeStatusService;
	@Resource
	private RolesService rolesService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private MessageService messageService;
	
	@Resource
	private PostService postService;
	@Resource
	private SalaryBottleService SalaryBottleService;
	
	@Resource 
	private DailyService dailyService;
	
	@RequestMapping("/index.do")
	public String index(SalaryBottleBean salaryBottle, Model model) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession() ;
		User user = getUser();
		List<Map<String,Object>> map=messageService.getMessagByuserId(user.getUserId());
		int count=messageService.getMessageCountByuserId(user.getUserId());			
		salaryBottle.setUserid(user.getUserId());
		salaryBottle.setPageSize(5);
		session.setAttribute("mess", map);
		session.setAttribute("count", count);
		com.test.bean.baseBean.PageVo<Map<String, Object>> pageVo = SalaryBottleService.getSalaryBottleByUserId(salaryBottle);
		model.addAttribute("page",pageVo );
		DailyBean daily=new DailyBean();
		daily.setUserid(user.getUserId());
		daily.setPageSize(5);
		model.addAttribute("pageDaily", dailyService.getDailyListByUserId(daily));
		return "index";
	}

	// @RequestMapping(value=("/getWeather.do"),method={RequestMethod.GET,RequestMethod.POST})
	// @ResponseBody
	// public Object getWeather(){
	// String weather = WeatherUtil.request("beijing");
	// return weather;
	// }

	@RequestMapping(value = ("/userList.do"), method = { RequestMethod.GET, RequestMethod.POST })
	public String getAllUsers(User2 user2, Model model) {
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo = userService.queryAllUser(user2);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("us", user2);
		return "user/userList";
	}

	@RequestMapping(value = ("/deleteUser.do"), method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public boolean deleteUser(@Param("IdArray") String IdArray) {
		return userService.deleteUser(IdArray);

	}

	@RequestMapping(value = ("/addUserSend.do"))
	public String adddUserSend(Model model) {
		List<EmployeeStatusBean> emplyeeStatus = employeeStatusService.selectAllEmplyeeStatus();
		List<RolesBean> roleList = rolesService.findAllRoles();
		List<DepartmentBean> departmentList = departmentService.queryDepartment();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("emplyeeStatus", emplyeeStatus);
		model.addAttribute("roleList", roleList);
		return "user/addUser";
	}

	@RequestMapping(value = ("/updateUserSend.do"))
	public String updateUserSend(User2 user, Model model) {
		List<EmployeeStatusBean> emplyeeStatus = employeeStatusService.selectAllEmplyeeStatus();
		List<RolesBean> roleList = rolesService.findAllRoles();
		List<DepartmentBean> departmentList = departmentService.queryDepartment();
		User userUp = null;
		if (user.getUserId() != null) {
			userUp = userService.getUserByid(user.getUserId());
			String substring = userUp.getWorkDate().substring(0, 10);
			userUp.setWorkDate(substring);
		}

		model.addAttribute("userUp", userUp);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("emplyeeStatus", emplyeeStatus);
		model.addAttribute("roleList", roleList);
		return "user/updateUser";
	}

	@RequestMapping(value = ("/updateUser.do"), method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public boolean updateUser(User user, Model model) {
		boolean flag = userService.updateUserByUserId(user);
		return flag;
	}

	@RequestMapping(value = ("/addUser.do"), method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public boolean adddUsers(User user, Model model) {
		boolean flag = userService.addUser(user);
		return flag;
	}

	@RequestMapping("/existUserName.do")
	@ResponseBody
	public boolean existUserName(@Param("userName") String userName, Model model) {
		User user = userService.getUserByUserName(userName);
		if (user != null) {
			return false;
		} else {
			return true;
		}
	}

	@RequestMapping("/existIdCode.do")
	@ResponseBody
	public boolean existIdCode(@Param("idCode") String idCode, Model model) {
		boolean flag = userService.getIdCode(idCode);
		return flag;
	}

	@RequestMapping("/checkIdCode.do")
	@ResponseBody
	public Object checkIdCode(@Param("idCode") String idCode, Model model) {
		String httpUrl = "http://apis.baidu.com/apistore/idservice/id";
		logger.info(idCode);
		String idcode2 = "id=" + idCode;
		String jsonResult = userService.requestIdCode(httpUrl, idcode2);
		return jsonResult;
	}

	@RequestMapping("/updatePasswordSend.do")
	public String updatePassword(Model model) {
		return "user/updatePassword";
	}

	@RequestMapping("/checkOldPassword.do")
	@ResponseBody
	public boolean checkOldPassword(String oldPassword, Model model) {
		User user = getUser();
		return userService.checkOldPassword(user.getUserId(), oldPassword);
	}

	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public boolean updatePassword(String newPassword, Model model) {
		User user = getUser();
		boolean flag = userService.updatePassword(user.getUserId(), newPassword);
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return flag;
	}
	@RequestMapping("/getUserWorkTime.do")
	@ResponseBody
	public HashMap<String, Object> getUserWork(Model model){
		HashMap<String, Object> map=userService.getUserWork();
		return map;
	}
	
	@RequestMapping("/getUserSex.do")
	@ResponseBody
	public HashMap<String, Object> getUserSex(Model model){
		HashMap<String, Object> map=userService.getUserSex();
		return map;
	}
	
	@RequestMapping("/updateUserPost.do")
	public String updateUserPost(User2 user,Model model) {
		User user2 = userService.getUserByid(user.getUserId());
		DepartmentBean olddepartment = departmentService.getDepartmentByDepartmentId(user2.getDepartmentId());
		 PostBean post = postService.getPostByPostId(user2.getPostId());
		List<DepartmentBean> departmentList = departmentService.queryDepartment();	
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("olddepartment", olddepartment);
		model.addAttribute("post", post);
		model.addAttribute("userId", user.getUserId());
		return "user/updateUserPost";
	}
	
	@RequestMapping("/transferUser.do")
	@ResponseBody
	public boolean transferUser(User2 user,Model model){
		int i = userService.updateUserPost(user);
		if(i>0){
			return true;
		}
		return false;
	}
	

}
