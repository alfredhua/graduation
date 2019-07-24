package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.ResourceBean;
@Mapper
public interface ResourceBeanMapper {
    @Delete({
        "delete from resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into resource (id, sourceName, ",
        "url, createTime, ",
        "updateTime, permission, ",
        "remark)",
        "values (#{id,jdbcType=INTEGER}, #{sourcename,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{permission,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(ResourceBean record);

    @InsertProvider(type=ResourceBeanSqlProvider.class, method="insertSelective")
    int insertSelective(ResourceBean record);

    @Select({
        "select",
        "id, sourceName, url, createTime, updateTime, permission, remark",
        "from resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sourceName", property="sourcename", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    ResourceBean selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ResourceBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResourceBean record);

    @Update({
        "update resource",
        "set sourceName = #{sourcename,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "updateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "permission = #{permission,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ResourceBean record);
    
    
	@Select("select * from  resource where permission=#{permission}")
	public List<ResourceBean> selectbypermission(
			@Param("permission") Integer permission);

	  @Delete({
	        "delete from resource",
	        "where permission = #{permission,jdbcType=INTEGER}"
	    })
	  int deleteByPerssion(@Param("permission") int permission);
}