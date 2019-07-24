package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.EmployeeStatusBean;
@Mapper

public interface EmployeeStatusBeanMapper {
    @Delete({
        "delete from employeeStatus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employeeStatus (id, name, ",
        "remark)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(EmployeeStatusBean record);

    @InsertProvider(type=EmployeeStatusBeanSqlProvider.class, method="insertSelective")
    int insertSelective(EmployeeStatusBean record);

    @Select({
        "select",
        "id, name, remark",
        "from employeeStatus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    EmployeeStatusBean selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmployeeStatusBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EmployeeStatusBean record);

    @Update({
        "update employeeStatus",
        "set name = #{name,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(EmployeeStatusBean record);
    
    @Select("select * from employeeStatus")
    List<EmployeeStatusBean> selectAllEmployStatus();
    
    
}