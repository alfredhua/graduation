package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.bean.TrainBean;

public class TrainBeanSqlProvider {

    public String insertSelective(TrainBean record) {
        BEGIN();
        INSERT_INTO("train");
        
        if (record.getTrainid() != null) {
            VALUES("trainId", "#{trainid,jdbcType=INTEGER}");
        }
        
        if (record.getTrainname() != null) {
            VALUES("trainName", "#{trainname,jdbcType=VARCHAR}");
        }
        
        if (record.getPurpose() != null) {
            VALUES("purpose", "#{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getBegintime() != null) {
            VALUES("beginTime", "#{begintime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            VALUES("endTime", "#{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTeacher() != null) {
            VALUES("teacher", "#{teacher,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDatum() != null) {
            VALUES("datum", "#{datum,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentId() != null) {
            VALUES("student_id", "#{studentId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(TrainBean record) {
        BEGIN();
        UPDATE("train");
        
        if (record.getTrainname() != null) {
            SET("trainName = #{trainname,jdbcType=VARCHAR}");
        }
        
        if (record.getPurpose() != null) {
            SET("purpose = #{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getBegintime() != null) {
            SET("beginTime = #{begintime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            SET("endTime = #{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTeacher() != null) {
            SET("teacher = #{teacher,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDatum() != null) {
            SET("datum = #{datum,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentId() != null) {
            SET("student_id = #{studentId,jdbcType=INTEGER}");
        }
        
        WHERE("trainId = #{trainid,jdbcType=INTEGER}");
        
        return SQL();
    }
}