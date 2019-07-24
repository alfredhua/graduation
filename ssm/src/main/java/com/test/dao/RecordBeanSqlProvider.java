package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.RecordBean;

public class RecordBeanSqlProvider {

    public String insertSelective(RecordBean record) {
        BEGIN();
        INSERT_INTO("record");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getOpentime() != null) {
            VALUES("openTime", "#{opentime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            VALUES("endTime", "#{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAbsencetype() != null) {
            VALUES("absenceType", "#{absencetype,jdbcType=VARCHAR}");
        }
        
        if (record.getReason() != null) {
            VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(RecordBean record) {
        BEGIN();
        UPDATE("record");
        
        if (record.getUserid() != null) {
            SET("userId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getOpentime() != null) {
            SET("openTime = #{opentime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            SET("endTime = #{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAbsencetype() != null) {
            SET("absenceType = #{absencetype,jdbcType=VARCHAR}");
        }
        
        if (record.getReason() != null) {
            SET("reason = #{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
    
    public  String getRecordPage(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select * from record,user where record.userId=user.userId ");	
    	Map<String, Object> parameter = (Map<String, Object>) map.get("parameters");
		if (parameter != null && parameter.size() > 0) {
			if(parameter.get("userId")!=null&&(!"".equals(parameter.get("userId")))){
				sb.append(" and record.userId='"+parameter.get("userId")+"'");
			}
			if(parameter.get("openTimeStart")!=null&&(!"".equals(parameter.get("openTimeStart")))){
				sb.append(" and record.openTime>='"+parameter.get("openTimeStart")+" 00:00:00'");
			}
			if(parameter.get("openTimeEnd")!=null&&(!"".equals(parameter.get("openTimeEnd")))){
				sb.append(" and record.openTime<='"+parameter.get("openTimeEnd")+" 23:59:59'");
			}
			if(parameter.get("absenceType")!=null&&(!"".equals(parameter.get("absenceType")))){
				sb.append(" and record.absenceType='"+parameter.get("absenceType")+"'");
			}
			if(parameter.get("state")!=null&&(!"".equals(parameter.get("state")))){
				sb.append(" and record.state='"+parameter.get("state")+"'");
			}
		}
		sb.append("order by record.opentime  desc ");
		sb.append("limit #{offset},#{pageSize}");
    	return sb.toString();
    }
    
    public String getRecordCount(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select count(*) from record,user where record.userId=user.userId ");	
    	Map<String, Object> parameter = (Map<String, Object>) map
				.get("parameters");
    	if (parameter != null && parameter.size() > 0) {
			if(parameter.get("userId")!=null&&(!"".equals(parameter.get("userId")))){
				sb.append(" and record.userId='"+parameter.get("userId")+"'");
			}
			if(parameter.get("openTimeStart")!=null&&(!"".equals(parameter.get("openTimeStart")))){
				sb.append(" and record.openTime>='"+parameter.get("openTimeStart")+" 00:00:00'");
			}
			if(parameter.get("openTimeEnd")!=null&&(!"".equals(parameter.get("openTimeEnd")))){
				sb.append(" and record.openTime<='"+parameter.get("openTimeEnd")+" 23:59:59'");
			}
			if(parameter.get("absenceType")!=null&&(!"".equals(parameter.get("absenceType")))){
				sb.append(" and record.absenceType='"+parameter.get("absenceType")+"'");
			}
			if(parameter.get("state")!=null&&(!"".equals(parameter.get("state")))){
				sb.append(" and record.state='"+parameter.get("state")+"'");
			}
		}
		sb.append("order by record.opentime  desc ");

    	return sb.toString();
    }
    
    
}