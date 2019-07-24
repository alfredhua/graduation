package com.test.dao;

import com.test.bean.MessageBean;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface MessageBeanMapper {
    @Delete({
        "delete from message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into message (id, sendId, ",
        "context, reviceId, ",
        "sendDate, readState, ",
        "deletType)",
        "values (#{id,jdbcType=INTEGER}, #{sendid,jdbcType=INTEGER}, ",
        "#{context,jdbcType=VARCHAR}, #{reviceid,jdbcType=INTEGER}, ",
        "#{senddate,jdbcType=TIMESTAMP}, #{readstate,jdbcType=INTEGER}, ",
        "#{delettype,jdbcType=INTEGER})"
    })
    int insert(MessageBean record);

    @InsertProvider(type=MessageBeanSqlProvider.class, method="insertSelective")
    int insertSelective(MessageBean record);

    @Select({
        "select",
        "id, sendId, context, reviceId, sendDate, readState, deletType,realName",
        "from message,user",
        "where user.userId=message.sendId and id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sendId", property="sendid", jdbcType=JdbcType.INTEGER),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="reviceId", property="reviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="sendDate", property="senddate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="readState", property="readstate", jdbcType=JdbcType.INTEGER),
        @Result(column="deletType", property="delettype", jdbcType=JdbcType.INTEGER),
        @Result(column="realName", property="realName", jdbcType=JdbcType.INTEGER),
        @Result(column="userName", property="userName", jdbcType=JdbcType.INTEGER)
    })
    MessageBean selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MessageBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MessageBean record);

    @Update({
        "update message",
        "set sendId = #{sendid,jdbcType=INTEGER},",
          "context = #{context,jdbcType=VARCHAR},",
          "reviceId = #{reviceid,jdbcType=INTEGER},",
          "sendDate = #{senddate,jdbcType=TIMESTAMP},",
          "readState = #{readstate,jdbcType=INTEGER},",
          "deletType = #{delettype,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MessageBean record);
    
    @SelectProvider(type=MessageBeanSqlProvider.class, method="getMessageCount")
	int getMessageCount(@Param("map")Map<String,Object> map);
    
	 @SelectProvider(type=MessageBeanSqlProvider.class, method="getMessageList")
	List<Map<String, Object>> getMessageList(@Param("map")Map<String,Object> map,@Param("offset")int offset,@Param("pageSize") int pageSize);
	    @Update({
	        "update message",
	        "set readState = 2 ",	     
	        "where id = #{id,jdbcType=INTEGER}"
	    })
	int updateStatusById(Integer id);
	    @Select({
	        "select * from message where reviceId=#{reviceid,jdbcType=INTEGER} and readState=1"
	    })
	List<Map<String, Object>> getMessagByuserId(Integer reviceid);
	    @Select({
	        "select count(*) from message where reviceId=#{reviceid,jdbcType=INTEGER}  and readState=1"
	    })
	int getMessageCountByuserId(Integer userId);
}