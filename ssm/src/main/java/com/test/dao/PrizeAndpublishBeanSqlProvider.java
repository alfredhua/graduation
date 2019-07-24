package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.PrizeAndpublishBean;

public class PrizeAndpublishBeanSqlProvider {

    public String insertSelective(PrizeAndpublishBean record) {
        BEGIN();
        INSERT_INTO("prizeAndpublish");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getPname() != null) {
            VALUES("pName", "#{pname,jdbcType=VARCHAR}");
        }
        
        if (record.getPreason() != null) {
            VALUES("pReason", "#{preason,jdbcType=VARCHAR}");
        }
        
        if (record.getPdescription() != null) {
            VALUES("pDescription", "#{pdescription,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPtype() != null) {
            VALUES("pType", "#{ptype,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PrizeAndpublishBean record) {
        BEGIN();
        UPDATE("prizeAndpublish");
        
        if (record.getUserid() != null) {
            SET("userId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getPname() != null) {
            SET("pName = #{pname,jdbcType=VARCHAR}");
        }
        
        if (record.getPreason() != null) {
            SET("pReason = #{preason,jdbcType=VARCHAR}");
        }
        
        if (record.getPdescription() != null) {
            SET("pDescription = #{pdescription,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPtype() != null) {
            SET("pType = #{ptype,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
    
    public String getRewardList(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select * from prizeAndpublish p,user u where u.userId=p.userId ");
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("userId") != null
					&& !("").equals(parameter.get("userId"))) {
				sb.append(" and p.userId = '" + parameter.get("userId")+ "' ");
			}
			
			if (parameter.get("userName") != null
					&& !("").equals(parameter.get("userName"))) {
				sb.append(" and u.userName = '" + parameter.get("userName")+ "' ");
			}
			if (parameter.get("realName") != null
					&& !("").equals(parameter.get("realName"))) {
				sb.append(" and u.realName = '" + parameter.get("realName") + "'");
			}	
			if (parameter.get("ptype") != null
					&& !("").equals(parameter.get("ptype"))) {
				sb.append(" and p.pType = " + parameter.get("ptype"));
			}	
		}
		sb.append(" ORDER BY p.createTime DESC ");
		sb.append(" LIMIT #{offset}, #{pageSize}");
    	
    	return sb.toString();
    }
    
    public String getRewardCount(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select count(*) from prizeAndpublish p,user u where u.userId=p.userId ");
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("userId") != null
					&& !("").equals(parameter.get("userId"))) {
				sb.append(" and u.userId = '" + parameter.get("userId")+ "' ");
			}
			
			if (parameter.get("userName") != null
					&& !("").equals(parameter.get("userName"))) {
				sb.append(" and u.userName = '" + parameter.get("userName")+ "' ");
			}
			if (parameter.get("realName") != null
					&& !("").equals(parameter.get("realName"))) {
				sb.append(" and u.realName = '" + parameter.get("realName") + "'");
			}	
			if (parameter.get("ptype") != null
					&& !("").equals(parameter.get("ptype"))) {
				sb.append(" and p.pType = " + parameter.get("ptype"));
			}	
		}
		sb.append(" ORDER BY p.createTime DESC ");
    	return sb.toString();
    }
}