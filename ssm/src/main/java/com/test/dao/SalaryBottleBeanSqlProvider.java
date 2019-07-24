package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.SalaryBottleBean;

public class SalaryBottleBeanSqlProvider {

    public String insertSelective(SalaryBottleBean record) {
        BEGIN();
        INSERT_INTO("salarybottle");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getBasic() != null) {
            VALUES("basic", "#{basic,jdbcType=DECIMAL}");
        }
        
        if (record.getEat() != null) {
            VALUES("eat", "#{eat,jdbcType=DECIMAL}");
        }
        
        if (record.getDuty() != null) {
            VALUES("duty", "#{duty,jdbcType=DECIMAL}");
        }
        
        if (record.getScot() != null) {
            VALUES("scot", "#{scot,jdbcType=DECIMAL}");
        }
        
        if (record.getPunishment() != null) {
            VALUES("punishment", "#{punishment,jdbcType=DECIMAL}");
        }
        
        if (record.getGranttime() != null) {
            VALUES("grantTime", "#{granttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotalize() != null) {
            VALUES("totalize", "#{totalize,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SalaryBottleBean record) {
        BEGIN();
        UPDATE("salarybottle");
        
        if (record.getUserid() != null) {
            SET("userId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getBasic() != null) {
            SET("basic = #{basic,jdbcType=DECIMAL}");
        }
        
        if (record.getEat() != null) {
            SET("eat = #{eat,jdbcType=DECIMAL}");
        }
        
        if (record.getDuty() != null) {
            SET("duty = #{duty,jdbcType=DECIMAL}");
        }
        
        if (record.getScot() != null) {
            SET("scot = #{scot,jdbcType=DECIMAL}");
        }
        
        if (record.getPunishment() != null) {
            SET("punishment = #{punishment,jdbcType=DECIMAL}");
        }
        
        if (record.getGranttime() != null) {
            SET("grantTime = #{granttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotalize() != null) {
            SET("totalize = #{totalize,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
    
    public String getSalaryBottleByUserId(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select * from salarybottle s,user u where s.userId=u.userId ");
    	Map<String,Object> parm=(Map<String, Object>) map.get("map");
    	if(parm.size()>0&&parm!=null){
   		if(parm.get("userId")!=null&& !("").equals(parm.get("userId"))){
    			sb.append(" and s.userId="+parm.get("userId"));
   		}
    	}
    	sb.append(" order by  s.grantTime desc ");
    	sb.append(" limit #{offset},#{pageSize}");
    	return sb.toString();
    }
    
    public String getSalaryBottleCount(Map<String, Object> map){
    	StringBuilder sb=new StringBuilder("");
    	sb.append("select count(*) from salarybottle s,user u where s.userId=u.userId ");
    	Map<String,Object> parm=(Map<String, Object>) map.get("map");
    	if(parm.size()>0&&parm!=null){
    		if(parm.get("userId")!=null&& !("").equals(parm.get("userId"))){
    			sb.append(" and s.userId="+parm.get("userId"));
    		}
    	}
    	sb.append(" order by s.grantTime desc ");
    	return sb.toString();
    }
}