package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.test.bean.MenuBean;
@Mapper
public interface MenuBeanMapper {
    @Delete({
        "delete from Menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into Menu (id, name, ",
        "url, parentId, disOrder,remark)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{parentid,jdbcType=INTEGER}, #{disorder,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR})"
    })
    int insert(MenuBean record);

    @InsertProvider(type=MenuBeanSqlProvider.class, method="insertSelective")
    int insertSelective(MenuBean record);

    @Select({
        "select",
        "id, name, url, parentId, disOrder,remark ",
        "from Menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="disOrder", property="disorder", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    MenuBean selectByPrimaryKey(Integer id);
    
    
    @Select({
        "select",
        "id, name, url, parentId, disOrder,remark",
        "from Menu",
        "where parentId = #{parentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="disOrder", property="disorder", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<MenuBean> findMenuByParentId(Integer parentId);

    @UpdateProvider(type=MenuBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MenuBean record);

    @Update({
        "update Menu",
        "set name = #{name,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "parentId = #{parentid,jdbcType=INTEGER},",
          "disOrder = #{disorder,jdbcType=VARCHAR}",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MenuBean record);
    
    
    @Select({
        "select",
        "id, name, url, parentId, disOrder,remark ",
        "from Menu where parentId=0"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="disOrder", property="disorder", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<MenuBean> selectAllMenu();
    
    
    @Select({
        "select",
        "id, name, url, parentId, disOrder,remark ",
        "from Menu where parentId=#{parentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="disOrder", property="disorder", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<MenuBean> selectChild(Integer parentId);
}