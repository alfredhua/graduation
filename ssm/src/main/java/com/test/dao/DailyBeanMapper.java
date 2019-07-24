package com.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.DailyBean;
@Mapper
public interface DailyBeanMapper  {
	@Delete({ "delete from daily", "where userId = #{userid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer userid);

	@Insert({ "insert into daily (userId, workDate, ", "dailyContext, workTime, ", "workSite, overTime, ",
			"overWorkContext)", "values (#{userid,jdbcType=INTEGER}, #{workdate,jdbcType=TIMESTAMP}, ",
			"#{dailycontext,jdbcType=VARCHAR}, #{worktime,jdbcType=INTEGER}, ",
			"#{worksite,jdbcType=VARCHAR}, #{overtime,jdbcType=INTEGER}, ", "#{overworkcontext,jdbcType=VARCHAR})" })
	int insert(DailyBean record);

	@InsertProvider(type = DailyBeanSqlProvider.class, method = "insertSelective")
	int insertSelective(DailyBean record);

	@Select({ "select", "userId, workDate, dailyContext, workTime, workSite, overTime, overWorkContext", "from daily",
			"where userId = #{userid,jdbcType=INTEGER}" })
	@Results({ @Result(column = "userId", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "workDate", property = "workdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "dailyContext", property = "dailycontext", jdbcType = JdbcType.VARCHAR),
			@Result(column = "workTime", property = "worktime", jdbcType = JdbcType.INTEGER),
			@Result(column = "workSite", property = "worksite", jdbcType = JdbcType.VARCHAR),
			@Result(column = "overTime", property = "overtime", jdbcType = JdbcType.INTEGER),
			@Result(column = "overWorkContext", property = "overworkcontext", jdbcType = JdbcType.VARCHAR) })
	DailyBean selectByPrimaryKey(Integer userid);

	@UpdateProvider(type = DailyBeanSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(DailyBean record);

	@Update({ "update daily", "set workDate = #{workdate,jdbcType=TIMESTAMP},",
			"dailyContext = #{dailycontext,jdbcType=VARCHAR},", "workTime = #{worktime,jdbcType=INTEGER},",
			"workSite = #{worksite,jdbcType=VARCHAR},", "overTime = #{overtime,jdbcType=INTEGER},",
			"overWorkContext = #{overworkcontext,jdbcType=VARCHAR}", "where userId = #{userid,jdbcType=INTEGER}" })
	int updateByPrimaryKey(DailyBean record);

	@Select({ "select", "userId, workDate, dailyContext, workTime, workSite, overTime, overWorkContext", "from daily",
			"where userId = #{userid,jdbcType=INTEGER} and workDate=#{workdate,jdbcType=TIMESTAMP}" })
	@Results({ @Result(column = "userId", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "workDate", property = "workdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "dailyContext", property = "dailycontext", jdbcType = JdbcType.VARCHAR),
			@Result(column = "workTime", property = "worktime", jdbcType = JdbcType.INTEGER),
			@Result(column = "workSite", property = "worksite", jdbcType = JdbcType.VARCHAR),
			@Result(column = "overTime", property = "overtime", jdbcType = JdbcType.INTEGER),
			@Result(column = "overWorkContext", property = "overworkcontext", jdbcType = JdbcType.VARCHAR) })
	List<DailyBean> queryByUserIdandDate(DailyBean entity);

	@SelectProvider(type = DailyBeanSqlProvider.class, method = "queryDailyListByUserId")
	List<Map<String, Object>> queryDailyListByUserId(@Param("map") Map<String, Object> map,
			@Param("offset") Integer offset, @Param("pagesize") Integer pagesize);

	@SelectProvider(type = DailyBeanSqlProvider.class, method = "queryDailyListCountByUserId")
	int queryDailyListCountByUserId(@Param("map") Map<String, Object> map);
	
	@SelectProvider(type = DailyBeanSqlProvider.class, method = "queryDailyListByUserIdNoPage")
	List<Map<String, Object>> queryDailyListByUserIdNoPage(Map<String, Object> map);
}