package com.test.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.omg.CORBA.INTERNAL;

import com.test.bean.User;
import com.test.bean.User2;
@Mapper
public interface UserMapper {
	@Delete({ "delete from user", "where userId = #{userId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer userId);

	@Insert({ "insert into user (userId, userName, ", "password, realName, ", "sex, age, idCode, ",
			"telephone, email, ", "address, workDate, ", "departmentId, postId, ", "state, roles)",
			"values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
			"#{password,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
			"#{sex,jdbcType=INTEGER}, #{age,jdbcType=INTEGER}, #{idcode,jdbcType=VARCHAR}, ",
			"#{telephone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
			"#{address,jdbcType=VARCHAR}, #{workDate,jdbcType=TIMESTAMP}, ",
			"#{departmentId,jdbcType=INTEGER}, #{postId,jdbcType=INTEGER}, ",
			"#{state,jdbcType=INTEGER}, #{roles,jdbcType=INTEGER})" })
	@Options(useGeneratedKeys = true, keyProperty = "userId")
	int insert(User record);

	@InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
	int insertSelective(User record);

	@Select({ "select", "userId, userName, password, realName, sex, age, idCode, telephone, email, address, ",
			"workDate, departmentId, postId, state, roles", "from user", "where userId = #{userId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "userId", property = "userId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userName", property = "userName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "realName", property = "realName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.INTEGER),
			@Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
			@Result(column = "idCode", property = "idcode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telephone", property = "telephone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
			@Result(column = "workDate", property = "workDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "departmentId", property = "departmentId", jdbcType = JdbcType.INTEGER),
			@Result(column = "postId", property = "postId", jdbcType = JdbcType.INTEGER),
			@Result(column = "state", property = "state", jdbcType = JdbcType.INTEGER),
			@Result(column = "roles", property = "roles", jdbcType = JdbcType.INTEGER) })
	User selectByPrimaryKey(Integer userId);

	@UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(User record);

	@Update({ "update user", "set userName = #{userName,jdbcType=VARCHAR},", "password = #{password,jdbcType=VARCHAR},",
			"realName = #{realName,jdbcType=VARCHAR},", "sex = #{sex,jdbcType=INTEGER},",
			"age = #{age,jdbcType=INTEGER},", "idCode = #{idcode,jdbcType=VARCHAR},",
			"telephone = #{telephone,jdbcType=VARCHAR},", "email = #{email,jdbcType=VARCHAR},",
			"address = #{address,jdbcType=VARCHAR},", "workDate = #{workDate,jdbcType=TIMESTAMP},",
			"departmentId = #{departmentId,jdbcType=INTEGER},", "postId = #{postId,jdbcType=INTEGER},",
			"state = #{state,jdbcType=INTEGER},", "roles = #{roles,jdbcType=INTEGER}",
			"where userId = #{userId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(User record);

	@Select({ "select *", "from user", "where userName = #{userName,jdbcType=VARCHAR}" })
	User selectUserByUserName(String userName);

	@Select({ "select *", "from user", "where idCode = #{idCode,jdbcType=VARCHAR}" })
	User selectUserByIdCode(String idCode);

	@SelectProvider(type = UserSqlProvider.class, method = "queryAllUser")
	List<Map<String, Object>> queryAllUser(@Param("parameters") Map<String, Object> map, @Param("offset") int offset,
			@Param("pagesize") int pageSize);

	@SelectProvider(type = UserSqlProvider.class, method = "queryAllTatol")
	Integer queryAllTatol(@Param("parameters") Map<String, Object> map);

	@Select({ "select * from user where roles=#{roleId,jdbcType=INTEGER}" })
	List<Map<String, Object>> queryByRoleId(@Param("roleId") String roleId);

	@Select({ "select", "userId, userName, password, realName, sex, age, idCode, telephone, email, address, ",
			"workDate, departmentId, postId, state, roles", "from user",
			"where userId = #{userId,jdbcType=INTEGER} and password=#{password,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "userId", property = "userId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userName", property = "userName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "realName", property = "realName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.INTEGER),
			@Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
			@Result(column = "idCode", property = "idcode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telephone", property = "telephone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
			@Result(column = "workDate", property = "workDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "departmentId", property = "departmentId", jdbcType = JdbcType.INTEGER),
			@Result(column = "postId", property = "postId", jdbcType = JdbcType.INTEGER),
			@Result(column = "state", property = "state", jdbcType = JdbcType.INTEGER),
			@Result(column = "roles", property = "roles", jdbcType = JdbcType.INTEGER) })
	User checkOldPassword(@Param("userId") Integer userId, @Param("password") String oldPassword);

	@Update({ "update user ", " set password = #{newPassword,jdbcType=VARCHAR}",
			" where userId = #{userId,jdbcType=INTEGER}" })
	int updatePassword(@Param("userId") Integer userId, @Param("newPassword") String newPassword);

	@Select({ "select ifnull(COUNT(*),0) as count,date_format(workDate,'%Y-%m-%d') as workdate from user where ",
			" workDate BETWEEN DATE_ADD(DATE_FORMAT(NOW(), '%Y-%m-%d'),INTERVAL - 7 DAY)",
			" AND DATE_ADD(DATE_FORMAT(NOW(), '%Y-%m-%d'),INTERVAL - 1 DAY) GROUP BY workDate" })
	List<Map<String, Object>> getUserWork();

	@Select({ " select COUNT(*) as count,sex from user GROUP BY sex" })
	List<Map<String, Object>> getUserSex();
	
	@Update({ "update user ", " set departmentId = #{departmentId,jdbcType=INTEGER},",
	"postId = #{postId,jdbcType=INTEGER} where userId = #{userId,jdbcType=INTEGER}" })
	int updateUserPost(User2 user);
	
	@Update({ "update user  set ",
	"state = #{status,jdbcType=INTEGER} where userId = #{userId,jdbcType=INTEGER}" })
	int updateStatus(@Param("userId")Integer userId,@Param("status") int status);

}