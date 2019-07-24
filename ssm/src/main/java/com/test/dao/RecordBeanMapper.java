package com.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.RecordBean;
@Mapper
public interface RecordBeanMapper {
    @Delete({
        "delete from record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into record (id, userId, ",
        "openTime, endTime, ",
        "absenceType, reason, ",
        "state)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{opentime,jdbcType=TIMESTAMP}, #{endtime,jdbcType=TIMESTAMP}, ",
        "#{absencetype,jdbcType=VARCHAR}, #{reason,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=INTEGER})"
    })
    int insert(RecordBean record);

    @InsertProvider(type=RecordBeanSqlProvider.class, method="insertSelective")
    int insertSelective(RecordBean record);

    @Select({
        "select",
        "id, userId, openTime, endTime, absenceType, reason, state",
        "from record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="openTime", property="opentime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="absenceType", property="absencetype", jdbcType=JdbcType.VARCHAR),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    RecordBean selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RecordBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RecordBean record);


    @SelectProvider(type=RecordBeanSqlProvider.class, method="getRecordPage")
	List<Map<String,Object>> getRecordPage(@Param("parameters")Map<String, Object> map, @Param("offset")int offset, @Param("pageSize")int pageSize);
  
    @SelectProvider(type=RecordBeanSqlProvider.class, method="getRecordCount")
   	int getRecordCount(@Param("parameters") Map<String, Object> map);
    
    @Update({
        "update record",
        "set userId = #{userid,jdbcType=INTEGER},",
          "openTime = #{opentime,jdbcType=TIMESTAMP},",
          "endTime = #{endtime,jdbcType=TIMESTAMP},",
          "absenceType = #{absencetype,jdbcType=VARCHAR},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RecordBean record);
    
    
    
    @Select({
        "select",
        "*",
        "from record,user",
        "where  user.userId=record.userId and record.id = #{id,jdbcType=INTEGER}"
    })

    Map<String, Object> selectById(Integer id);
    @Update({
        "update record",
        "set state = #{state,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
	int updateStatusByid(@Param("id")int id,@Param("state")int state);

}