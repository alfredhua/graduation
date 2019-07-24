package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import com.test.bean.PostBean;

public class PostBeanSqlProvider {

	public String insertSelective(PostBean record) {
		BEGIN();
		INSERT_INTO("post");

		if (record.getPostId() != null) {
			VALUES("post_id", "#{postId,jdbcType=INTEGER}");
		}

		if (record.getPostName() != null) {
			VALUES("post_Name", "#{postName,jdbcType=VARCHAR}");
		}

		if (record.getDepartmentId() != null) {
			VALUES("department_id", "#{departmentId,jdbcType=INTEGER}");
		}

		if (record.getDescription() != null) {
			VALUES("description", "#{description,jdbcType=VARCHAR}");
		}

		return SQL();
	}

	public String updateByPrimaryKeySelective(PostBean record) {
		BEGIN();
		UPDATE("post");

		if (record.getPostName() != null) {
			SET("post_Name = #{postName,jdbcType=VARCHAR}");
		}

		if (record.getDepartmentId() != null) {
			SET("department_id = #{departmentId,jdbcType=INTEGER}");
		}

		if (record.getDescription() != null) {
			SET("description = #{description,jdbcType=VARCHAR}");
		}

		WHERE("post_id = #{postId,jdbcType=INTEGER}");

		return SQL();
	}

	public String getAllPost(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"select post.*,department.department_id as departmentID,department.department_Name as departmentName");
		sb.append(" from post,department where post.department_id=department.id ");
		Map<String, Object> parameter = (Map<String, Object>) map.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("postId") != null && (!"".equals(parameter.get("postId")))) {
				sb.append(" and post_id ='" + parameter.get("postId") + "'");
			}
			if (parameter.get("postName") != null && (!"".equals(parameter.get("postName")))) {
				sb.append(" and post_Name ='" + parameter.get("postName") + "'");
			}
		}
		sb.append(" ORDER BY post_id DESC ");
		sb.append(" limit #{offset},#{pageSize}");
		return sb.toString();
	}

	public String getAllPostCount(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) from post,department where post.department_id=department.id ");
		Map<String, Object> parameter = (Map<String, Object>) map.get("map");
		if (parameter != null && parameter.size() > 0) {
			if (parameter.get("postId") != null && (!"".equals(parameter.get("postId")))) {
				sb.append(" and post_id ='" + parameter.get("postId") + "'");
			}
			if (parameter.get("postName") != null && (!"".equals(parameter.get("postName")))) {
				sb.append(" and post_Name ='" + parameter.get("postName") + "'");
			}
		}
		sb.append(" ORDER BY post_id DESC ");
		return sb.toString();
	}
}