package com.test.service;

import java.util.Map;

import com.test.bean.PrizeAndpublishBean;
import com.test.util.common.PageVo;

public interface RewardService {

	int sendWelfare(PrizeAndpublishBean prizeAndpublishBean, String idArray);

	PageVo<Map<String, Object>> getRewardList(PrizeAndpublishBean prizeAndpublishBean);

}
