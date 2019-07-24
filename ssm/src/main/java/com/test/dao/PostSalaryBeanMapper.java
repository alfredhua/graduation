package com.test.dao;

import com.test.bean.PostSalaryBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface PostSalaryBeanMapper {
    @Delete({
        "delete from postSalary",
        "where postId = #{postid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer postid);

    @Insert({
        "insert into postSalary (postId, basic, ",
        "totalize, createTime)",
        "values (#{postid,jdbcType=INTEGER}, #{basic,jdbcType=DECIMAL}, ",
        "#{totalize,jdbcType=DECIMAL}, #{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(PostSalaryBean record);

    @InsertProvider(type=PostSalaryBeanSqlProvider.class, method="insertSelective")
    int insertSelective(PostSalaryBean record);

    @Select({
        "select",
        "postId, basic, totalize, createTime",
        "from postSalary",
        "where postId = #{postid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="postId", property="postid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="basic", property="basic", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalize", property="totalize", jdbcType=JdbcType.DECIMAL),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    PostSalaryBean selectByPrimaryKey(Integer postid);

    @UpdateProvider(type=PostSalaryBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PostSalaryBean record);

    @Update({
        "update postSalary",
        "set basic = #{basic,jdbcType=DECIMAL},",
          "totalize = #{totalize,jdbcType=DECIMAL},",
          "createTime = #{createtime,jdbcType=TIMESTAMP}",
        "where postId = #{postid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PostSalaryBean record);
}