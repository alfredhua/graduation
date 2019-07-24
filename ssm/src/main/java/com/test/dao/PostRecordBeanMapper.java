package com.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.PostRecordBean;
@Mapper
public interface PostRecordBeanMapper {
    @Delete({
        "delete from postRecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into postRecord (id, userId, ",
        "department, post, ",
        "newPost, newPostName, ",
        "newDepartment, changeTime)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{department,jdbcType=INTEGER}, #{post,jdbcType=INTEGER}, ",
        "#{newpost,jdbcType=INTEGER}, #{newpostname,jdbcType=VARCHAR}, ",
        "#{newdepartment,jdbcType=INTEGER}, #{changetime,jdbcType=TIMESTAMP})"
    })
    int insert(PostRecordBean record);

    @InsertProvider(type=PostRecordBeanSqlProvider.class, method="insertSelective")
    int insertSelective(PostRecordBean record);

    @Select({
        "select",
        "id, userId, department, post, newPost, newPostName, newDepartment, changeTime",
        "from postRecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="department", property="department", jdbcType=JdbcType.INTEGER),
        @Result(column="post", property="post", jdbcType=JdbcType.INTEGER),
        @Result(column="newPost", property="newpost", jdbcType=JdbcType.INTEGER),
        @Result(column="newPostName", property="newpostname", jdbcType=JdbcType.VARCHAR),
        @Result(column="newDepartment", property="newdepartment", jdbcType=JdbcType.INTEGER),
        @Result(column="changeTime", property="changetime", jdbcType=JdbcType.TIMESTAMP)
    })
    PostRecordBean selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PostRecordBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PostRecordBean record);

    @Update({
        "update postRecord",
        "set userId = #{userid,jdbcType=INTEGER},",
          "department = #{department,jdbcType=INTEGER},",
          "post = #{post,jdbcType=INTEGER},",
          "newPost = #{newpost,jdbcType=INTEGER},",
          "newPostName = #{newpostname,jdbcType=VARCHAR},",
          "newDepartment = #{newdepartment,jdbcType=INTEGER},",
          "changeTime = #{changetime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PostRecordBean record);
    
    @SelectProvider(type=PostRecordBeanSqlProvider.class, method="getPostRecordList")
	List<Map<String,Object>> getPostRecordList(@Param("map")Map<String, Object> map, @Param("offset")int offset,  @Param("pageSize")int pageSize);
    
    @SelectProvider(type=PostRecordBeanSqlProvider.class, method="getPostRecordCount")
	int getPostRecordCount(@Param("map")Map<String, Object> map);
}