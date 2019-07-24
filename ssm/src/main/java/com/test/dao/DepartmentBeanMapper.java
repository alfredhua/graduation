package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.DepartmentBean;

@Mapper
public interface DepartmentBeanMapper {
    @Delete({
        "delete from department",
        "where department_id = #{departmentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer departmentId);

    @Insert({
        "insert into department (department_id, department_Name, ",
        "department_Type, description, ",
        "parent_id)",
        "values (#{departmentId,jdbcType=INTEGER}, #{departmentName,jdbcType=VARCHAR}, ",
        "#{departmentType,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER})"
    })
    int insert(DepartmentBean record);

    @InsertProvider(type=DepartmentBeanSqlProvider.class, method="insertSelective")
    int insertSelective(DepartmentBean record);

    @Select({
        "select",
        "id,department_id, department_Name, department_Type, description, parent_id",
        "from department",
        "where id = #{departmentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="department_Name", property="departmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_Type", property="departmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER)
    })
    DepartmentBean selectByPrimaryKey(Integer departmentId);
    
    @Select({
        "select",
        "department_id, department_Name, department_Type, description, parent_id",
        "from department",
        "where parent_id = #{parentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="department_Name", property="departmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_Type", property="departmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER)
    })
    List<DepartmentBean> selectByparentId(Integer parentId);
    

    @UpdateProvider(type=DepartmentBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DepartmentBean record);

    @Update({
        "update department",
        "set department_Name = #{departmentName,jdbcType=VARCHAR},",
          "department_Type = #{departmentType,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER}",
        "where department_id = #{departmentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DepartmentBean record);
    
    @Select({"select * from department where department_Name= #{departmentName,jdbcType=VARCHAR} "})
    DepartmentBean selectByName(@Param("departmentName") String departmentName);
    
    @Select({
        "select",
        "id,department_id, department_Name, department_Type, description, parent_id",
        "from department",
        "limit #{pageIndex},#{pageSize}"
    })
    @Results({
    	 	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER ),
        @Result(column="department_Name", property="departmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_Type", property="departmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER)
    })
    List<DepartmentBean> selectAll(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
    
    @Select({
        "select ",
        "id,department_id, department_Name, department_Type, description, parent_id",
        "from department"
    })
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="department_Name", property="departmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_Type", property="departmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER)
    })
    List<DepartmentBean> selectAllList();
    
    @Select({"select count(*) from department"})
    Integer selectCount();
    
    @Select({
        "select",
        "id,department_id, department_Name, department_Type, description, parent_id",
        "from department",
        "where department_id = #{departmentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="department_Name", property="departmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_Type", property="departmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER)
    })
    DepartmentBean selectBydepartmentId(Integer departmentId);
    
    
}