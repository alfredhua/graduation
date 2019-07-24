package com.test.dao;

import com.test.bean.LeavePostBean;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper

public interface LeavePostBeanMapper {
    @Delete({
        "delete from leavePost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into leavePost (id, userId, ",
        "reason, leaveStatus, ",
        "leavetime)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{reason,jdbcType=VARCHAR}, #{leavestatus,jdbcType=INTEGER}, ",
        "#{leavetime,jdbcType=TIMESTAMP})"
    })
    int insert(LeavePostBean record);

    @InsertProvider(type=LeavePostBeanSqlProvider.class, method="insertSelective")
    int insertSelective(LeavePostBean record);

    @Select({
        "select",
        "id, userId, reason, leaveStatus, leavetime",
        "from leavePost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="leaveStatus", property="leavestatus", jdbcType=JdbcType.INTEGER),
        @Result(column="leavetime", property="leavetime", jdbcType=JdbcType.TIMESTAMP)
    })
    LeavePostBean selectByPrimaryKey(Integer id);

    @UpdateProvider(type=LeavePostBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LeavePostBean record);

    @Update({
        "update leavePost",
        "set userId = #{userid,jdbcType=INTEGER},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "leaveStatus = #{leavestatus,jdbcType=INTEGER},",
          "leavetime = #{leavetime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LeavePostBean record);
    @SelectProvider(type=LeavePostBeanSqlProvider.class, method="getleavePostList")
	List<Map<String, Object>> getleavePostList(@Param("map")Map<String, Object> map, @Param("offset")int offset,@Param("pageSize") int pageSize);
    
    @SelectProvider(type=LeavePostBeanSqlProvider.class, method="getleavePostCount")
	int getleavePostCount(@Param("map")Map<String, Object> map);
    @Update({
         "update leavePost",
         "set leaveStatus = #{leavestatus,jdbcType=INTEGER} ",   
         "where userId = #{userid,jdbcType=INTEGER}"
    })
	int updateLeaveStatus(@Param("userid")Integer userid, @Param("leavestatus")Integer leavestatus);
    @Select({
        "select * from leavePost l,user u where l.userId=u.userId and l.userId = #{userid,jdbcType=INTEGER}"

    })
	Map<String, Object> watchLeavePost(@Param("userid")int userid);
}