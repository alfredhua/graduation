package com.test.service.base;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 所有Service的基类，用来注入sqlSession
 * 
 */
@Service("baseService")
public class BaseService  extends SqlSessionDaoSupport {


	@Resource
	@Override
     public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		        super.setSqlSessionFactory(sqlSessionFactory);
	 }

}
