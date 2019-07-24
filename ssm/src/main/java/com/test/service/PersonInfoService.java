package com.test.service;

import com.test.bean.PersonInfoBean;

public interface PersonInfoService {
	
	public void addPersonInfo(PersonInfoBean personInfo);

	public Integer updatepersonInfo(PersonInfoBean person);
	
	public PersonInfoBean getPersonInfobyUserId(int userId);
	
	public Integer updatepersonHead(PersonInfoBean person);
	
	public Integer updateNoHead(PersonInfoBean person);

}
