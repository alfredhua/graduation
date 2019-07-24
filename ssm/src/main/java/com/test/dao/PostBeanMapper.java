package com.test.dao;

import com.test.bean.PostBean;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface PostBeanMapper {
    @Delete({
        "delete from post",
        "where post_id = #{postId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer postId);

    @Insert({
        "insert into post (post_id, post_Name, ",
        "department_id, description)",
        "values (#{postId,jdbcType=INTEGER}, #{postName,jdbcType=VARCHAR}, ",
        "#{departmentId,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "postId")
    int insert(PostBean record);

    @InsertProvider(type=PostBeanSqlProvider.class, method="insertSelective")
    int insertSelective(PostBean record);

    @Select({
        "select",
        "post_id, post_Name, department_id, description",
        "from post",
        "where post_id = #{postId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="post_Name", property="postName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    PostBean selectByPrimaryKey(Integer postId);
    
    @Select({
        "select",
        "post_id, post_Name, department_id, description",
        "from post",
        "where post_Name = #{postName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="post_Name", property="postName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    PostBean selectByPostName(String postName);

    @UpdateProvider(type=PostBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PostBean record);

    @Update({
        "update post",
        "set post_Name = #{postName,jdbcType=VARCHAR},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where post_id = #{postId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PostBean record);

    @Select({
        "select",
        "post_id, post_Name, department_id, description",
        "from post",
        "where department_id = #{departmentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="post_Name", property="postName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
	List<Map<String, Object>> getPostListbyDepartmentId(Integer departmentId);

    @SelectProvider(type=PostBeanSqlProvider.class,method="getAllPost")
	List<Map<String, Object>> getAllPost(@Param("map")Map<String, Object> map, @Param("offset")int offset, @Param("pageSize")Integer pageSize);
    
    @SelectProvider(type=PostBeanSqlProvider.class,method="getAllPostCount")
	Integer getAllPostCount(@Param("map")Map<String, Object> map);
    
    
    @Select({
        "select",
        "post_id, post_Name, department_id, description",
        "from post",
        "where department_id = #{departmentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="post_Name", property="postName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
	List<PostBean> getPostbyDepartmentId(Integer departmentId);
    
    @Select({
        "select * from post,postSalary where post.post_id=postSalary.postId and post_id=#{postId,jdbcType=INTEGER}"    
    })
    Map<String,Object> queryPostbyId(Integer postId);
    
}