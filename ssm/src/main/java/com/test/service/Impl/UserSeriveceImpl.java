package com.test.service.Impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

import com.test.bean.PersonInfoBean;
import com.test.bean.PostBean;
import com.test.bean.PostRecordBean;
import com.test.bean.PostSalaryBean;
import com.test.bean.SalaryBean;
import com.test.bean.User;
import com.test.bean.User2;
import com.test.dao.PostSalaryBeanMapper;
import com.test.dao.SalaryBeanMapper;
import com.test.dao.UserMapper;
import com.test.service.PersonInfoService;
import com.test.service.PostRecordService;
import com.test.service.PostService;
import com.test.service.StaticDefault;
import com.test.service.UserService;
import com.test.util.common.PageVo;

@Service("userService")
public class UserSeriveceImpl  extends BaseService implements UserService {

	private UserMapper userMapper;
	
	private PostSalaryBeanMapper postSalaryBeanMapper;
	
	private SalaryBeanMapper salaryBeanMapper;

	@Resource
	private PersonInfoService personInfoService;
	
	@Resource
	private PostRecordService postRecordService;
	
	@Resource
	private PostService postService;

	Logger logger = LoggerFactory.getLogger(UserSeriveceImpl.class);

	@Override
	public boolean addUser(User user) {
		int i = userMapper.insert(user);
		if (i > 0) {
			PersonInfoBean personInfo = new PersonInfoBean();//添加一个用户的时候初始化用户个人信息
			personInfo.setUserid(user.getUserId());
			personInfoService.addPersonInfo(personInfo);
			//这里需要初始化员工的薪资
			PostSalaryBean postSalaryBean = postSalaryBeanMapper.selectByPrimaryKey(user.getPostId());
			SalaryBean salary=new SalaryBean(user.getUserId(), postSalaryBean.getBasic(), 0L, 0L, 0L, 0L,new Date(),
					postSalaryBean.getBasic());
			salaryBeanMapper.insert(salary);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getUserByUserName(String userName) {
		User user = userMapper.selectUserByUserName(userName);
		return user;
	}

	@Override
	public boolean getIdCode(String ideCode) {
		User user = userMapper.selectUserByIdCode(ideCode);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public PageVo<Map<String, Object>> queryAllUser(User2 user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", user.getUserName());
		map.put("realName", user.getRealName());
		map.put("workDateStart", user.getWorkDateStart());
		map.put("workDateEnd", user.getWorkDateEnd());
		if (user.getCurrentPage() == null) {
			user.setCurrentPage(StaticDefault.pageCurrent);// 设置当前页为1
		}
		if (user.getPageSize() == null) {
			user.setPageSize(StaticDefault.pageSize);// 设置页面的大小
		}
		List<Map<String, Object>> allUser = userMapper.queryAllUser(map,
				(user.getCurrentPage() - 1) * user.getPageSize(), user.getPageSize());
		Integer total = userMapper.queryAllTatol(map);
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo.setVoList(allUser);
		pageVo.setTotal(total);
		pageVo.setPageSize(user.getPageSize());
		pageVo.setCurrentPage(user.getCurrentPage());
		return pageVo;
	}

	/**
	 * @param
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	@Override
	public String requestIdCode(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			// 填入apikey到HTTP header
			connection.setRequestProperty("apikey", "cfe28821a0a6b7495217b5419faf3f9b");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(result);
		return result;
	}

	@Override
	public boolean updateUserByUserId(User user) {
		int i = userMapper.updateByPrimaryKey(user);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteUser(String idArray) {
		String substring = idArray.substring(0, idArray.length() - 1);
		String[] userId = substring.split(",");
		for (int i = 0; i < userId.length; i++) {
			userMapper.deleteByPrimaryKey(Integer.parseInt(userId[i]));
		}
		return true;
	}

	@Override
	public List<Map<String, Object>> queryByRoleId(String id) {
		List<Map<String, Object>> list = userMapper.queryByRoleId(id);
		return list;
	}

	@Override
	public boolean checkOldPassword(Integer userId, String oldPassword) {
		User user = userMapper.checkOldPassword(userId, oldPassword);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePassword(Integer userId, String newPassword) {
		int password = userMapper.updatePassword(userId, newPassword);
		if (password > 0) {
			return true;
		} else {
			return false;
		}
	}
	

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	

	public PostSalaryBeanMapper getPostSalaryBeanMapper() {
		return postSalaryBeanMapper;
	}
	@Autowired
	public void setPostSalaryBeanMapper(PostSalaryBeanMapper postSalaryBeanMapper) {
		this.postSalaryBeanMapper = postSalaryBeanMapper;
	}

	public SalaryBeanMapper getSalaryBeanMapper() {
		return salaryBeanMapper;
	}
	@Autowired
	public void setSalaryBeanMapper(SalaryBeanMapper salaryBeanMapper) {
		this.salaryBeanMapper = salaryBeanMapper;
	}

	@Override
	public User getUserByid(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public HashMap<String, Object> getUserWork() {
		List<Map<String, Object>> list=userMapper.getUserWork();
		HashMap<String, Object> map=new HashMap<String, Object>();
		String[] amount=new String[7];
		String[] date=new String[7];	
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,   -1);
		String first = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
		date[6]=first;
		cal.add(Calendar.DATE,   -1);
		String second = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		date[5]=second;
		cal.add(Calendar.DATE,   -1);
		String thirty = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		date[4]=thirty;
		cal.add(Calendar.DATE,   -1);
		String four = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		date[3]=four;
		cal.add(Calendar.DATE,   -1);
		String five = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		date[2]=five;
		cal.add(Calendar.DATE,   -1);
		String six = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		date[1]=six;
		cal.add(Calendar.DATE,   -1);
		String seven = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		date[0]=seven;
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < list.size(); i++) {			
				if(date[j].trim().equals(list.get(i).get("workdate").toString().trim())){
					amount[j]=list.get(i).get("count").toString();
					break;
				}else{
					amount[j]="0";
				}	
			}
			
		}
		map.put("amount", amount);
		map.put("date", date);
		return map;
	}

	@Override
	public HashMap<String, Object> getUserSex() {
		HashMap<String, Object> map1=new HashMap<String, Object>();
		List<Map<String, Object>> list=userMapper.getUserSex();
		List<Map<String, Object>> pvDatas = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			if(list.get(i).get("sex").toString().equals("1")){
				map.put("value",list.get(i).get("count").toString());
				map.put("name", "男");
			}else{
				map.put("value",list.get(i).get("count").toString());
				map.put("name", "女");
			}
			pvDatas.add(map);
		}
		map1.put("pvDatas", pvDatas);
		return map1;
	}

	@Override
	public int updateUserPost(User2 user) {
		User olduser = userMapper.selectByPrimaryKey(user.getUserId());
		int i = userMapper.updateUserPost(user);
		if(i>0){
			PostRecordBean postRecordBean=new PostRecordBean();
			postRecordBean.setUserid(olduser.getUserId());
			postRecordBean.setPost(olduser.getPostId());
			postRecordBean.setChangetime(new Date());
			postRecordBean.setDepartment(olduser.getDepartmentId());
			postRecordBean.setNewpost(user.getPostId());
			PostBean postBean = postService.getPostByPostId(user.getPostId());
			postRecordBean.setNewpostname(postBean.getPostName());
			postRecordBean.setNewdepartment(user.getDepartmentId());
			//增加一个职位调动流水
			postRecordService.insertPostRecord(postRecordBean);
			return i;
		}
		return 0;
	}

	@Override
	public int updateStatus(Integer userid, int i) {
		
		return userMapper.updateStatus(userid, i);
	}
}
