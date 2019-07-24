package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.SalaryBean;

public class SalaryBeanSqlProvider {

	public String insertSelective(SalaryBean record) {
		BEGIN();
		INSERT_INTO("salary");

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

		if (record.getCreatetime() != null) {
			VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
		}

		if (record.getTotalize() != null) {
			VALUES("totalize", "#{totalize,jdbcType=DECIMAL}");
		}

		return SQL();
	}

	public String updateByPrimaryKeySelective(SalaryBean record) {
		BEGIN();
		UPDATE("salary");

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

		if (record.getCreatetime() != null) {
			SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
		}

		if (record.getTotalize() != null) {
			SET("totalize = #{totalize,jdbcType=DECIMAL}");
		}

		WHERE("userId = #{userid,jdbcType=INTEGER}");

		return SQL();
	}

	public String querySalaryListByPage(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder("");
		sb.append("select * from salary,user where user.userId=salary.userId ");
		Map<String, Object> parameter = (Map<String, Object>) map.get("map");
		if (parameter.size() > 0 && parameter != null) {
			

		}
		sb.append(" order by salary.createTime DESC");
		sb.append(" limit #{offset},#{pageSize} ");
		return sb.toString();
	}
	
	public String querySalaryListCount(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder("");
		sb.append("select count(*) from salary,user where user.userId=salary.userId ");
		Map<String, Object> parameter = (Map<String, Object>) map.get("map");
		if (parameter.size() > 0 && parameter != null) {
			

		}
		sb.append(" order by salary.createTime DESC");
		return sb.toString();
	}

}