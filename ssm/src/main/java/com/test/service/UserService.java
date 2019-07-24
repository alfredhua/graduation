package com.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.bean.User;
import com.test.bean.User2;
import com.test.util.common.PageVo;


public interface UserService {
	//通过id获取User
	User getUserByid(Integer id);
	//添加
	boolean addUser(User user);
	//根据用户名查询
	
	User  getUserByUserName(String userName);
	
	//根据用户的身份证号
	boolean  getIdCode(String idcode);
	//请求id的正确性
	public String requestIdCode(String httpUrl, String httpArg);
	
	PageVo<Map<String, Object>>  queryAllUser(User2 user);
	
	boolean updateUserByUserId(User user);
	
	boolean deleteUser(String idArray);
	
	List<Map<String, Object>> queryByRoleId(String id);
	
	boolean checkOldPassword(Integer userId, String oldPassword);
	
	boolean updatePassword(Integer userId, String newPassword);
	
	HashMap<String, Object> getUserWork();
	
	HashMap<String, Object> getUserSex();
	
	int updateUserPost(User2 user);
	
	int updateStatus(Integer userid, int i);
}
