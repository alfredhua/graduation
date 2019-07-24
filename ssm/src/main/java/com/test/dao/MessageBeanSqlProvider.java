package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.MessageBean;

public class MessageBeanSqlProvider {

    public String insertSelective(MessageBean record) {
        BEGIN();
        INSERT_INTO("message");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getSendid() != null) {
            VALUES("sendId", "#{sendid,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            VALUES("context", "#{context,jdbcType=VARCHAR}");
        }
        
        if (record.getReviceid() != null) {
            VALUES("reviceId", "#{reviceid,jdbcType=INTEGER}");
        }
        
        if (record.getSenddate() != null) {
            VALUES("sendDate", "#{senddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReadstate() != null) {
            VALUES("readState", "#{readstate,jdbcType=INTEGER}");
        }
        
        if (record.getDelettype() != null) {
            VALUES("deletType", "#{delettype,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MessageBean record) {
        BEGIN();
        UPDATE("message");
        
        if (record.getSendid() != null) {
            SET("sendId = #{sendid,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            SET("context = #{context,jdbcType=VARCHAR}");
        }
        
        if (record.getReviceid() != null) {
            SET("reviceId = #{reviceid,jdbcType=INTEGER}");
        }
        
        if (record.getSenddate() != null) {
            SET("sendDate = #{senddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReadstate() != null) {
            SET("readState = #{readstate,jdbcType=INTEGER}");
        }
        
        if (record.getDelettype() != null) {
            SET("deletType = #{delettype,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
    
    public String getMessageCount(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select count(*) from ");
    	sb.append(" message m,user u,user u2 where m.sendId=u.userId and u2.userId=m.reviceId and m.deletType=1");
    	Map<String, Object> parameter = (Map<String, Object>) map
				.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("reviceid") != null
					&& !("").equals(parameter.get("reviceid"))) {
				sb.append(" and m.reviceId = '" + parameter.get("reviceid")+ "' ");
			}
		}
    	sb.append(" order by m.sendDate desc ");
    	return sb.toString();
    }
    
    public String getMessageList(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select u.userName as sendUserName,m.*, u2.userName as  reviceName from ");
    	sb.append(" message m,user u,user u2 where m.sendId=u.userId and u2.userId=m.reviceId and m.deletType=1 ");
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("reviceid") != null
					&& !("").equals(parameter.get("reviceid"))) {
				sb.append(" and m.reviceId = '" + parameter.get("reviceid")+ "' ");
			}
		}
    	
    	sb.append(" order by m.sendDate desc ");
    	sb.append(" limit #{offset},#{pageSize}");
    	return sb.toString();
    }
}