package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.test.bean.DailyBean;

public class DailyBeanSqlProvider {

    public String insertSelective(DailyBean record) {
        BEGIN();
        INSERT_INTO("daily");
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkdate() != null) {
            VALUES("workDate", "#{workdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDailycontext() != null) {
            VALUES("dailyContext", "#{dailycontext,jdbcType=VARCHAR}");
        }
        
        if (record.getWorktime() != null) {
            VALUES("workTime", "#{worktime,jdbcType=INTEGER}");
        }
        
        if (record.getWorksite() != null) {
            VALUES("workSite", "#{worksite,jdbcType=VARCHAR}");
        }
        
        if (record.getOvertime() != null) {
            VALUES("overTime", "#{overtime,jdbcType=INTEGER}");
        }
        
        if (record.getOverworkcontext() != null) {
            VALUES("overWorkContext", "#{overworkcontext,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(DailyBean record) {
        BEGIN();
        UPDATE("daily");
        
        if (record.getWorkdate() != null) {
            SET("workDate = #{workdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDailycontext() != null) {
            SET("dailyContext = #{dailycontext,jdbcType=VARCHAR}");
        }
        
        if (record.getWorktime() != null) {
            SET("workTime = #{worktime,jdbcType=INTEGER}");
        }
        
        if (record.getWorksite() != null) {
            SET("workSite = #{worksite,jdbcType=VARCHAR}");
        }
        
        if (record.getOvertime() != null) {
            SET("overTime = #{overtime,jdbcType=INTEGER}");
        }
        
        if (record.getOverworkcontext() != null) {
            SET("overWorkContext = #{overworkcontext,jdbcType=VARCHAR}");
        }
        
        WHERE("userId = #{userid,jdbcType=INTEGER}");
        
        return SQL();
    }
    
    public String queryDailyListByUserId(Map<String, Object> map){
    	StringBuilder sb = new StringBuilder("");
		sb.append("select * from daily where 1=1");	
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("userId") != null
					&& !("").equals(parameter.get("userId"))) {
				sb.append(" and userId = '" + parameter.get("userId")+ "' ");
			}
			if (parameter.get("workDateStart") != null
					&& !("").equals(parameter.get("workDateStart"))) {
				sb.append(" and workDate >= '" + parameter.get("workDateStart")+ "00:00:00' ");
			}
			if (parameter.get("workDateEnd") != null
					&& !("").equals(parameter.get("workDateEnd"))) {
				sb.append(" and workDate < '" + parameter.get("workDateEnd")+ "23:59:59' ");
			}
		}
		sb.append(" ORDER BY workDate DESC ");
		sb.append(" LIMIT #{offset}, #{pagesize}");
		return sb.toString();
    }
    
    public String queryDailyListCountByUserId(Map<String, Object> map){
    	StringBuilder sb = new StringBuilder("");
		sb.append("select count(*) from daily where 1=1");	
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("userId") != null
					&& !("").equals(parameter.get("userId"))) {
				sb.append(" and userId = '" + parameter.get("userId")+ "' ");
			}	
			if (parameter.get("workDateStart") != null
					&& !("").equals(parameter.get("workDateStart"))) {
				sb.append(" and workDate >= '" + parameter.get("workDateStart")+ "00:00:00' ");
			}
			if (parameter.get("workDateEnd") != null
					&& !("").equals(parameter.get("workDateEnd"))) {
				sb.append(" and workDate < '" + parameter.get("workDateEnd")+ "23:59:59' ");
			}
		}
		sb.append(" ORDER BY workDate DESC ");
		return sb.toString();
    }
    
    public String queryDailyListByUserIdNoPage(Map<String, Object> map){
    	StringBuilder sb = new StringBuilder("");
		sb.append("select * from daily where 1=1");	
		Map<String, Object> parameter = (Map<String, Object>) map
				.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("userId") != null
					&& !("").equals(parameter.get("userId"))) {
				sb.append(" and userId = '" + parameter.get("userId")+ "' ");
			}
			if (parameter.get("workDateStart") != null
					&& !("").equals(parameter.get("workDateStart"))) {
				sb.append(" and workDate >= '" + parameter.get("workDateStart")+ "00:00:00' ");
			}
			if (parameter.get("workDateEnd") != null
					&& !("").equals(parameter.get("workDateEnd"))) {
				sb.append(" and workDate < '" + parameter.get("workDateEnd")+ "23:59:59' ");
			}
		}
		sb.append(" ORDER BY workDate DESC ");
		return sb.toString();
    }
}