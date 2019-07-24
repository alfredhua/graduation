package com.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.SalaryBean;
@Mapper
public interface SalaryBeanMapper {
    @Delete({
        "delete from salary",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userid);

    @Insert({
        "insert into salary (userId, basic, ",
        "eat, duty, scot, ",
        "punishment, createTime, ",
        "totalize)",
        "values (#{userid,jdbcType=INTEGER}, #{basic,jdbcType=DECIMAL}, ",
        "#{eat,jdbcType=DECIMAL}, #{duty,jdbcType=DECIMAL}, #{scot,jdbcType=DECIMAL}, ",
        "#{punishment,jdbcType=DECIMAL}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{totalize,jdbcType=DECIMAL})"
    })
    int insert(SalaryBean record);

    @InsertProvider(type=SalaryBeanSqlProvider.class, method="insertSelective")
    int insertSelective(SalaryBean record);

    @Select({
        "select",
        "userId, basic, eat, duty, scot, punishment, createTime, totalize",
        "from salary",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="basic", property="basic", jdbcType=JdbcType.DECIMAL),
        @Result(column="eat", property="eat", jdbcType=JdbcType.DECIMAL),
        @Result(column="duty", property="duty", jdbcType=JdbcType.DECIMAL),
        @Result(column="scot", property="scot", jdbcType=JdbcType.DECIMAL),
        @Result(column="punishment", property="punishment", jdbcType=JdbcType.DECIMAL),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="totalize", property="totalize", jdbcType=JdbcType.DECIMAL)
    })
    SalaryBean selectByPrimaryKey(Integer userid);
    
    @Select({"select * from user u,salary s,department d,post p where u.userId=s.userId",
    " and u.departmentId=d.department_id and u.postid =p.post_id and u.userId=#{userid,jdbcType=INTEGER}"})
    Map<String,Object> getUserInfoByUserId(Integer userid);

    @UpdateProvider(type=SalaryBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SalaryBean record);

    @Update({
        "update salary",
        "set basic = #{basic,jdbcType=DECIMAL},",
          "eat = #{eat,jdbcType=DECIMAL},",
          "duty = #{duty,jdbcType=DECIMAL},",
          "scot = #{scot,jdbcType=DECIMAL},",
          "punishment = #{punishment,jdbcType=DECIMAL},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "totalize = #{totalize,jdbcType=DECIMAL}",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int updateByUserId(SalaryBean salary);

    @SelectProvider(type=SalaryBeanSqlProvider.class,method="querySalaryListByPage")
	List<Map<String,Object>> querySalaryListByPage(@Param("map")Map<String, Object> map,@Param("offset") int offset, @Param("pageSize")int pageSize);
    
    @SelectProvider(type=SalaryBeanSqlProvider.class,method="querySalaryListCount")
	int querySalaryListCount(@Param("map")Map<String, Object> map);
}