package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.User;

public class UserSqlProvider {

    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("user");
        
        if (record.getUserId() != null) {
            VALUES("userId", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            VALUES("userName", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            VALUES("realName", "#{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            VALUES("sex", "#{sex,jdbcType=INTEGER}");
        }
        
        if (record.getAge() != null) {
            VALUES("age", "#{age,jdbcType=INTEGER}");
        }
        
        if (record.getIdcode() != null) {
            VALUES("idCode", "#{idcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            VALUES("telephone", "#{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkDate() != null) {
            VALUES("workDate", "#{workDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDepartmentId() != null) {
            VALUES("department_id", "#{departmentId,jdbcType=INTEGER}");
        }
        
        if (record.getPostId() != null) {
            VALUES("post_id", "#{postId,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        if (record.getRoles() != null) {
            VALUES("roles", "#{roles,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("user");
        
        if (record.getUserName() != null) {
            SET("userName = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            SET("realName = #{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("sex = #{sex,jdbcType=INTEGER}");
        }
        
        if (record.getAge() != null) {
            SET("age = #{age,jdbcType=INTEGER}");
        }
        
        if (record.getIdcode() != null) {
            SET("idCode = #{idcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            SET("telephone = #{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkDate() != null) {
            SET("workDate = #{workDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDepartmentId() != null) {
            SET("departmentId = #{departmentId,jdbcType=INTEGER}");
        }
        
        if (record.getPostId() != null) {
            SET("postId = #{postId,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }
        
        if (record.getRoles() != null) {
            SET("roles = #{roles,jdbcType=INTEGER}");
        }
        
        WHERE("userId = #{userid,jdbcType=INTEGER}");
        
        return SQL();
    }
    
    public String queryAllUser(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder("");
		sb.append("select * from user where 1=1 and state!=4");
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("parameters");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("userName") != null
					&& !("").equals(parameter.get("userName"))) {
				sb.append(" and userName = '" + parameter.get("userName")+ "' ");
			}
			if (parameter.get("realName") != null
					&& !("").equals(parameter.get("realName"))) {
				sb.append(" and realName = '" + parameter.get("realName") + "'");
			}
			if (parameter.get("workDateStart") != null
					&& !("").equals(parameter.get("workDateStart"))) {
				sb.append(" and workDate > '" + parameter.get("workDateStart") + "'");
			}	
			if (parameter.get("workDateEnd") != null
					&& !("").equals(parameter.get("workDateEnd"))) {
				sb.append(" and workDate < '" + parameter.get("workDateEnd") + "'");
			}	
		}
		sb.append(" ORDER BY user.userId DESC ");
		sb.append(" LIMIT #{offset}, #{pagesize}");
		return sb.toString();
	}
    
    public String queryAllTatol(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder("");
		sb.append("select count(*) from user  where 1=1 and state!=4");
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("parameters");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("userName") != null
					&& !("").equals(parameter.get("userName"))) {
				sb.append(" and userName = '" + parameter.get("userName")+ "' ");
			}
			if (parameter.get("realName") != null
					&& !("").equals(parameter.get("realName"))) {
				sb.append(" and realName = '" + parameter.get("realName") + "'");
			}
			if (parameter.get("workDateStart") != null
					&& !("").equals(parameter.get("workDateStart"))) {
				sb.append(" and workDate > '" + parameter.get("workDateStart") + "'");
			}	
			if (parameter.get("workDateEnd") != null
					&& !("").equals(parameter.get("workDateEnd"))) {
				sb.append(" and workDate < '" + parameter.get("workDateEnd") + "'");
			}	
		}
		sb.append(" ORDER BY user.userId DESC ");
		return sb.toString();
	}
    
}