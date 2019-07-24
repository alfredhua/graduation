package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.test.bean.RolesBean;
@Mapper
public interface RolesBeanMapper {
    @Insert({
        "insert into user_Roles ( rolename, ",
        "remark)",
        "values (#{rolename,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(RolesBean record);

    @InsertProvider(type=RolesBeanSqlProvider.class, method="insertSelective")
    int insertSelective(RolesBean record);
    
    @Select({
        "select *",
        "from user_Roles",
        "where  rolename= #{rolename,jdbcType=VARCHAR}"
    })
    RolesBean selectByPrimaryKey(@Param("rolename")String  rolename);
    
    @Select({
        "select *",
        "from user_Roles",
        "where  id= #{id,jdbcType=VARCHAR}"
    })
    RolesBean selectByRoleId(@Param("id")String  id);
    
    @Select("select * from user_Roles")
    List<RolesBean> findAllRoles();
    
    @Delete({"delete from user_Roles where id=#{id,jdbcType=INTEGER}"})
    Integer delRole(Integer id);

    @Update({ "update user_Roles",
        "set rolename = #{rolename,jdbcType=VARCHAR},",
        "remark = #{remark,jdbcType=VARCHAR} ",
      " where id = #{id,jdbcType=INTEGER}"})
	Integer updateRole(RolesBean role);
    
}