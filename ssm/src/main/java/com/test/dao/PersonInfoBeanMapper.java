package com.test.dao;

import com.test.bean.PersonInfoBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface PersonInfoBeanMapper {
    @Delete({
        "delete from personInfo",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userid);

    @Insert({
        "insert into personInfo (userId, technology, ",
        "specialty, school, ",
        "createTime, personInformation, ",
        "favourites, head, ",
        "weibo, weixin, phone)",
        "values (#{userid,jdbcType=INTEGER}, #{technology,jdbcType=VARCHAR}, ",
        "#{specialty,jdbcType=VARCHAR}, #{school,jdbcType=VARCHAR}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{personinformation,jdbcType=VARCHAR}, ",
        "#{favourites,jdbcType=VARCHAR}, #{head,jdbcType=VARCHAR}, ",
        "#{weibo,jdbcType=VARCHAR}, #{weixin,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR})"
    })
    int insert(PersonInfoBean record);

    @InsertProvider(type=PersonInfoBeanSqlProvider.class, method="insertSelective")
    int insertSelective(PersonInfoBean record);

    @Select({
        "select",
        "userId, technology, specialty, school, createTime, personInformation, favourites, ",
        "head, weibo, weixin, phone",
        "from personInfo",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="technology", property="technology", jdbcType=JdbcType.VARCHAR),
        @Result(column="specialty", property="specialty", jdbcType=JdbcType.VARCHAR),
        @Result(column="school", property="school", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="personInformation", property="personinformation", jdbcType=JdbcType.VARCHAR),
        @Result(column="favourites", property="favourites", jdbcType=JdbcType.VARCHAR),
        @Result(column="head", property="head", jdbcType=JdbcType.VARCHAR),
        @Result(column="weibo", property="weibo", jdbcType=JdbcType.VARCHAR),
        @Result(column="weixin", property="weixin", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    PersonInfoBean selectByPrimaryKey(Integer userid);

    @UpdateProvider(type=PersonInfoBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PersonInfoBean record);

    @Update({
        "update personInfo",
        "set technology = #{technology,jdbcType=VARCHAR},",
          "specialty = #{specialty,jdbcType=VARCHAR},",
          "school = #{school,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "personInformation = #{personinformation,jdbcType=VARCHAR},",
          "favourites = #{favourites,jdbcType=VARCHAR},",
          "head = #{head,jdbcType=VARCHAR},",
          "weibo = #{weibo,jdbcType=VARCHAR},",
          "weixin = #{weixin,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR}",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PersonInfoBean record);
    
    @Update({
        "update personInfo",
        " set head = #{head,jdbcType=VARCHAR}", 
        " where userId = #{userid,jdbcType=INTEGER}"
    })
    int updateHeadByPrimaryKey(PersonInfoBean record);
    
    @Update({
        "update personInfo",
        "set technology = #{technology,jdbcType=VARCHAR},",
          "specialty = #{specialty,jdbcType=VARCHAR},",
          "school = #{school,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "personInformation = #{personinformation,jdbcType=VARCHAR},",
          "favourites = #{favourites,jdbcType=VARCHAR},",        
          "weibo = #{weibo,jdbcType=VARCHAR},",
          "weixin = #{weixin,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR}",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int updateNoHead(PersonInfoBean record);
}