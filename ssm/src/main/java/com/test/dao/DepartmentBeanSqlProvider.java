package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.bean.DepartmentBean;

public class DepartmentBeanSqlProvider {

    public String insertSelective(DepartmentBean record) {
        BEGIN();
        INSERT_INTO("department");
        
        if (record.getDepartmentId() != null) {
            VALUES("department_id", "#{departmentId,jdbcType=INTEGER}");
        }
        
        if (record.getDepartmentName() != null) {
            VALUES("department_Name", "#{departmentName,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartmentType() != null) {
            VALUES("department_Type", "#{departmentType,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(DepartmentBean record) {
        BEGIN();
        UPDATE("department");
        
        if (record.getDepartmentName() != null) {
            SET("department_Name = #{departmentName,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartmentType() != null) {
            SET("department_Type = #{departmentType,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        if (record.getDepartmentId() != null) {
            SET("department_id = #{departmentId,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}