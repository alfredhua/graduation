package com.test.dao;

import com.test.bean.PrizeAndpublishBean;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface PrizeAndpublishBeanMapper {
    @Delete({
        "delete from prizeAndpublish",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into prizeAndpublish (id, userId, ",
        "pName, pReason, ",
        "pDescription, createTime, ",
        "pType)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{pname,jdbcType=VARCHAR}, #{preason,jdbcType=VARCHAR}, ",
        "#{pdescription,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{ptype,jdbcType=INTEGER})"
    })
    int insert(PrizeAndpublishBean record);

    @InsertProvider(type=PrizeAndpublishBeanSqlProvider.class, method="insertSelective")
    int insertSelective(PrizeAndpublishBean record);

    @Select({
        "select",
        "id, userId, pName, pReason, pDescription, createTime, pType",
        "from prizeAndpublish",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="pName", property="pname", jdbcType=JdbcType.VARCHAR),
        @Result(column="pReason", property="preason", jdbcType=JdbcType.VARCHAR),
        @Result(column="pDescription", property="pdescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pType", property="ptype", jdbcType=JdbcType.INTEGER)
    })
    PrizeAndpublishBean selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PrizeAndpublishBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PrizeAndpublishBean record);

    @Update({
        "update prizeAndpublish",
        "set userId = #{userid,jdbcType=INTEGER},",
          "pName = #{pname,jdbcType=VARCHAR},",
          "pReason = #{preason,jdbcType=VARCHAR},",
          "pDescription = #{pdescription,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "pType = #{ptype,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PrizeAndpublishBean record);
    
    @SelectProvider(type=PrizeAndpublishBeanSqlProvider.class, method="getRewardList")
	List<Map<String, Object>> getRewardList(@Param("map")Map<String, Object> map, @Param("offset")int offset, @Param("pageSize")Integer pageSize);
   
    @SelectProvider(type=PrizeAndpublishBeanSqlProvider.class, method="getRewardCount")
	Integer getRewardCount(@Param("map")Map<String, Object> map);
}