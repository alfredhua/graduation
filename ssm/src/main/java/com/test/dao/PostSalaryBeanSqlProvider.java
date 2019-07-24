package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.bean.PostSalaryBean;

public class PostSalaryBeanSqlProvider {

    public String insertSelective(PostSalaryBean record) {
        BEGIN();
        INSERT_INTO("postSalary");
        
        if (record.getPostid() != null) {
            VALUES("postId", "#{postid,jdbcType=INTEGER}");
        }
        
        if (record.getBasic() != null) {
            VALUES("basic", "#{basic,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalize() != null) {
            VALUES("totalize", "#{totalize,jdbcType=DECIMAL}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PostSalaryBean record) {
        BEGIN();
        UPDATE("postSalary");
        
        if (record.getBasic() != null) {
            SET("basic = #{basic,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalize() != null) {
            SET("totalize = #{totalize,jdbcType=DECIMAL}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("postId = #{postid,jdbcType=INTEGER}");
        
        return SQL();
    }
}