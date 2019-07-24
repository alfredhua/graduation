package com.test.service.Impl;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.PersonInfoBean;
import com.test.dao.PersonInfoBeanMapper;
import com.test.service.PersonInfoService;

import javax.annotation.Resource;

@Service("personInfoService")
public class PersonInfoServiceImpl  extends BaseService implements PersonInfoService{


	private PersonInfoBeanMapper personInfoMapper;
	
	@Override
	public void addPersonInfo(PersonInfoBean personInfo) {
		personInfoMapper.insert(personInfo);
		
	}

	public PersonInfoBeanMapper getPersonInfoMapper() {
		return personInfoMapper;
	}
	@Autowired
	public void setPersonInfoMapper(PersonInfoBeanMapper personInfoMapper) {
		this.personInfoMapper = personInfoMapper;
	}

	@Override
	public Integer updatepersonInfo(PersonInfoBean person) {
		int i = personInfoMapper.updateByPrimaryKey(person);
		if (i > 0) {
			return i;
		} else {
			return 0;
		}
	}
	
	@Override
	public Integer updatepersonHead(PersonInfoBean person) {
		int i = personInfoMapper.updateHeadByPrimaryKey(person);
		if (i > 0) {
			return i;
		} else {
			return 0;
		}
	}
	
	@Override
	public Integer updateNoHead(PersonInfoBean person) {
		int i = personInfoMapper.updateNoHead(person);
		if (i > 0) {
			return i;
		} else {
			return 0;
		}
	}

	@Override
	public PersonInfoBean getPersonInfobyUserId(int userId) {	
		return personInfoMapper.selectByPrimaryKey(userId);
	}
	
	


	
	
	

}
