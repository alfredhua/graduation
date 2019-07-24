package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.LeavePostBean;

public class LeavePostBeanSqlProvider {

    public String insertSelective(LeavePostBean record) {
        BEGIN();
        INSERT_INTO("leavePost");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getReason() != null) {
            VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getLeavestatus() != null) {
            VALUES("leaveStatus", "#{leavestatus,jdbcType=INTEGER}");
        }
        
        if (record.getLeavetime() != null) {
            VALUES("leavetime", "#{leavetime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(LeavePostBean record) {
        BEGIN();
        UPDATE("leavePost");
        
        if (record.getUserid() != null) {
            SET("userId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getReason() != null) {
            SET("reason = #{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getLeavestatus() != null) {
            SET("leaveStatus = #{leavestatus,jdbcType=INTEGER}");
        }
        
        if (record.getLeavetime() != null) {
            SET("leavetime = #{leavetime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
    
    public String getleavePostList(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select l.*,u.*,d.department_Name departmentName ,p.post_Name postName ");
    	sb.append("from leavePost l,user u,department d,post p ");
    	sb.append(" where u.userId=l.userId and u.departmentId=d.department_id");
    	sb.append(" and u.postId=p.post_id ");
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("userName") != null
					&& !("").equals(parameter.get("userName"))) {
				sb.append(" and u.userName = '" + parameter.get("userName")+ "' ");
			}
			if (parameter.get("realName") != null
					&& !("").equals(parameter.get("realName"))) {
				sb.append(" and u.realName = '" + parameter.get("realName") + "'");
			}
			if (parameter.get("leaveTimeSart") != null
					&& !("").equals(parameter.get("leaveTimeSart"))) {
				sb.append(" and l.leavetime > '" + parameter.get("leaveTimeSart") + "'");
			}	
			if (parameter.get("leaveTimeEnd") != null
					&& !("").equals(parameter.get("leaveTimeEnd"))) {
				sb.append(" and l.leavetime < '" + parameter.get("leaveTimeEnd") + "'");
			}	
		}
		sb.append(" ORDER BY l.leavetime DESC ");
		sb.append(" LIMIT #{offset}, #{pageSize}");
    	return sb.toString();
    }
    
    public String getleavePostCount(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select count(*) ");
    	sb.append("from leavePost l,user u,department d,post p ");
    	sb.append(" where u.userId=l.userId and u.departmentId=d.department_id");
    	sb.append(" and u.postId=p.post_id ");
    		Map<String, Object> parameter = (Map<String, Object>) map
    				.get("map");
    		if (parameter != null && parameter.size() > 0) {
    			if (parameter.get("userName") != null
    					&& !("").equals(parameter.get("userName"))) {
    				sb.append(" and u.userName = '" + parameter.get("userName")+ "' ");
    			}
    			if (parameter.get("realName") != null
    					&& !("").equals(parameter.get("realName"))) {
    				sb.append(" and u.realName = '" + parameter.get("realName") + "'");
    			}
    			if (parameter.get("leaveTimeSart") != null
    					&& !("").equals(parameter.get("leaveTimeSart"))) {
    				sb.append(" and l.leavetime > '" + parameter.get("leaveTimeSart") + "'");
    			}	
    			if (parameter.get("leaveTimeEnd") != null
    					&& !("").equals(parameter.get("leaveTimeEnd"))) {
    				sb.append(" and l.leavetime < '" + parameter.get("leaveTimeEnd") + "'");
    			}	
    		}
    		sb.append(" ORDER BY l.leavetime DESC ");
    	return sb.toString();
    }
}