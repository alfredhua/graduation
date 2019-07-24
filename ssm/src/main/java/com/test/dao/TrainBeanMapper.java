package com.test.dao;

import com.test.bean.TrainBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface TrainBeanMapper {
    @Delete({
        "delete from train",
        "where trainId = #{trainid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer trainid);

    @Insert({
        "insert into train (trainId, trainName, ",
        "purpose, beginTime, ",
        "endTime, teacher, ",
        "createTime, datum, ",
        "student_id)",
        "values (#{trainid,jdbcType=INTEGER}, #{trainname,jdbcType=VARCHAR}, ",
        "#{purpose,jdbcType=VARCHAR}, #{begintime,jdbcType=TIMESTAMP}, ",
        "#{endtime,jdbcType=TIMESTAMP}, #{teacher,jdbcType=VARCHAR}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{datum,jdbcType=VARCHAR}, ",
        "#{studentId,jdbcType=INTEGER})"
    })
    int insert(TrainBean record);

    @InsertProvider(type=TrainBeanSqlProvider.class, method="insertSelective")
    int insertSelective(TrainBean record);

    @Select({
        "select",
        "trainId, trainName, purpose, beginTime, endTime, teacher, createTime, datum, ",
        "student_id",
        "from train",
        "where trainId = #{trainid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="trainId", property="trainid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="trainName", property="trainname", jdbcType=JdbcType.VARCHAR),
        @Result(column="purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="beginTime", property="begintime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="teacher", property="teacher", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="datum", property="datum", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER)
    })
    TrainBean selectByPrimaryKey(Integer trainid);

    @UpdateProvider(type=TrainBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TrainBean record);

    @Update({
        "update train",
        "set trainName = #{trainname,jdbcType=VARCHAR},",
          "purpose = #{purpose,jdbcType=VARCHAR},",
          "beginTime = #{begintime,jdbcType=TIMESTAMP},",
          "endTime = #{endtime,jdbcType=TIMESTAMP},",
          "teacher = #{teacher,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "datum = #{datum,jdbcType=VARCHAR},",
          "student_id = #{studentId,jdbcType=INTEGER}",
        "where trainId = #{trainid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TrainBean record);
}