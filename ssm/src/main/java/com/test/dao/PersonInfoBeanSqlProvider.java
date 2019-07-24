package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.bean.PersonInfoBean;

public class PersonInfoBeanSqlProvider {

    public String insertSelective(PersonInfoBean record) {
        BEGIN();
        INSERT_INTO("personInfo");
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getTechnology() != null) {
            VALUES("technology", "#{technology,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecialty() != null) {
            VALUES("specialty", "#{specialty,jdbcType=VARCHAR}");
        }
        
        if (record.getSchool() != null) {
            VALUES("school", "#{school,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPersoninformation() != null) {
            VALUES("personInformation", "#{personinformation,jdbcType=VARCHAR}");
        }
        
        if (record.getFavourites() != null) {
            VALUES("favourites", "#{favourites,jdbcType=VARCHAR}");
        }
        
        if (record.getHead() != null) {
            VALUES("head", "#{head,jdbcType=VARCHAR}");
        }
        
        if (record.getWeibo() != null) {
            VALUES("weibo", "#{weibo,jdbcType=VARCHAR}");
        }
        
        if (record.getWeixin() != null) {
            VALUES("weixin", "#{weixin,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PersonInfoBean record) {
        BEGIN();
        UPDATE("personInfo");
        
        if (record.getTechnology() != null) {
            SET("technology = #{technology,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecialty() != null) {
            SET("specialty = #{specialty,jdbcType=VARCHAR}");
        }
        
        if (record.getSchool() != null) {
            SET("school = #{school,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPersoninformation() != null) {
            SET("personInformation = #{personinformation,jdbcType=VARCHAR}");
        }
        
        if (record.getFavourites() != null) {
            SET("favourites = #{favourites,jdbcType=VARCHAR}");
        }
        
        if (record.getHead() != null) {
            SET("head = #{head,jdbcType=VARCHAR}");
        }
        
        if (record.getWeibo() != null) {
            SET("weibo = #{weibo,jdbcType=VARCHAR}");
        }
        
        if (record.getWeixin() != null) {
            SET("weixin = #{weixin,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        WHERE("userId = #{userid,jdbcType=INTEGER}");
        
        return SQL();
    }
}