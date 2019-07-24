package com.test.service;

import java.util.Map;

import com.test.bean.DailyBean;
import com.test.bean.User;
import com.test.util.common.PageVo;

public interface DailyService {
	
	int addDaily(DailyBean entity);

	Integer existDateDaily(DailyBean entity);

	PageVo<Map<String, Object>> getDailyListByUserId(DailyBean daily);

	void exportDaily(DailyBean entity);

}
