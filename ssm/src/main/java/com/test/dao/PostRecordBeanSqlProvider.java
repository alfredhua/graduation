package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.PostRecordBean;

public class PostRecordBeanSqlProvider {

    public String insertSelective(PostRecordBean record) {
        BEGIN();
        INSERT_INTO("postRecord");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getDepartment() != null) {
            VALUES("department", "#{department,jdbcType=INTEGER}");
        }
        
        if (record.getPost() != null) {
            VALUES("post", "#{post,jdbcType=INTEGER}");
        }
        
        if (record.getNewpost() != null) {
            VALUES("newPost", "#{newpost,jdbcType=INTEGER}");
        }
        
        if (record.getNewpostname() != null) {
            VALUES("newPostName", "#{newpostname,jdbcType=VARCHAR}");
        }
        
        if (record.getNewdepartment() != null) {
            VALUES("newDepartment", "#{newdepartment,jdbcType=INTEGER}");
        }
        
        if (record.getChangetime() != null) {
            VALUES("changeTime", "#{changetime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PostRecordBean record) {
        BEGIN();
        UPDATE("postRecord");
        
        if (record.getUserid() != null) {
            SET("userId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getDepartment() != null) {
            SET("department = #{department,jdbcType=INTEGER}");
        }
        
        if (record.getPost() != null) {
            SET("post = #{post,jdbcType=INTEGER}");
        }
        
        if (record.getNewpost() != null) {
            SET("newPost = #{newpost,jdbcType=INTEGER}");
        }
        
        if (record.getNewpostname() != null) {
            SET("newPostName = #{newpostname,jdbcType=VARCHAR}");
        }
        
        if (record.getNewdepartment() != null) {
            SET("newDepartment = #{newdepartment,jdbcType=INTEGER}");
        }
        
        if (record.getChangetime() != null) {
            SET("changeTime = #{changetime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
    
    public String getPostRecordList(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select pr.*,p.post_Name oldPost,d.department_Name oldDepartment,d2.department_Name newDepartmentName,u.* "); 
    	sb.append(" from postRecord pr,post p,department d,department d2,user u");
    	sb.append(" where p.post_id=pr.post and d.department_id=pr.department and pr.newDepartment=d2.department_id and u.userId=pr.userId");
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
		}
		sb.append(" ORDER BY pr.changeTime DESC ");
		sb.append(" LIMIT #{offset}, #{pageSize}");
    	return sb.toString();
    }
    
    public String getPostRecordCount(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select count(*) "); 
    	sb.append(" from postRecord pr,post p,department d,department d2,user u");
    	sb.append(" where p.post_id=pr.post and d.department_id=pr.department and pr.newDepartment=d2.department_id and u.userId=pr.userId");
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
	
		}
		sb.append(" ORDER BY pr.changeTime DESC ");
    	return sb.toString();   
    }
}