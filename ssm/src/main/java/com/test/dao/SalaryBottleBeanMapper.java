package com.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.SalaryBottleBean;

import aj.org.objectweb.asm.Type;
@Mapper
public interface SalaryBottleBeanMapper {
    @Delete({
        "delete from salarybottle",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into salarybottle (id, userId, ",
        "basic, eat, duty, ",
        "scot, punishment, ",
        "grantTime, totalize, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{basic,jdbcType=DECIMAL}, #{eat,jdbcType=DECIMAL}, #{duty,jdbcType=DECIMAL}, ",
        "#{scot,jdbcType=DECIMAL}, #{punishment,jdbcType=DECIMAL}, ",
        "#{granttime,jdbcType=TIMESTAMP}, #{totalize,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(SalaryBottleBean record);

    @InsertProvider(type=SalaryBottleBeanSqlProvider.class, method="insertSelective")
    int insertSelective(SalaryBottleBean record);

    @Select({
        "select",
        "id, userId, basic, eat, duty, scot, punishment, grantTime, totalize, status",
        "from salarybottle",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="basic", property="basic", jdbcType=JdbcType.DECIMAL),
        @Result(column="eat", property="eat", jdbcType=JdbcType.DECIMAL),
        @Result(column="duty", property="duty", jdbcType=JdbcType.DECIMAL),
        @Result(column="scot", property="scot", jdbcType=JdbcType.DECIMAL),
        @Result(column="punishment", property="punishment", jdbcType=JdbcType.DECIMAL),
        @Result(column="grantTime", property="granttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="totalize", property="totalize", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    SalaryBottleBean selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SalaryBottleBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SalaryBottleBean record);

    @Update({
        "update salarybottle",
        "set userId = #{userid,jdbcType=INTEGER},",
          "basic = #{basic,jdbcType=DECIMAL},",
          "eat = #{eat,jdbcType=DECIMAL},",
          "duty = #{duty,jdbcType=DECIMAL},",
          "scot = #{scot,jdbcType=DECIMAL},",
          "punishment = #{punishment,jdbcType=DECIMAL},",
          "grantTime = #{granttime,jdbcType=TIMESTAMP},",
          "totalize = #{totalize,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SalaryBottleBean record);

    @SelectProvider(type=SalaryBottleBeanSqlProvider.class,method="getSalaryBottleByUserId")
	List<Map<String, Object>> getSalaryBottleByUserId(@Param("map")Map<String, Object> map,
			@Param("offset") int offset, @Param("pageSize")int pageSize);
    
    @SelectProvider(type=SalaryBottleBeanSqlProvider.class,method="getSalaryBottleCount")
	int getSalaryBottleCount(@Param("map")Map<String, Object> map);
}