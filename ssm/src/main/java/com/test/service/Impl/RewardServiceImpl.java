package com.test.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.PrizeAndpublishBean;
import com.test.dao.PrizeAndpublishBeanMapper;
import com.test.service.RewardService;
import com.test.service.StaticDefault;
import com.test.util.common.PageVo;

import javax.annotation.Resource;

@Service("rewardService")
public class RewardServiceImpl  extends BaseService implements RewardService {

	private PrizeAndpublishBeanMapper prizeAndpublishBeanMapper;

	public PrizeAndpublishBeanMapper getPrizeAndpublishBeanMapper() {
		return prizeAndpublishBeanMapper;
	}

	@Autowired
	public void setPrizeAndpublishBeanMapper(PrizeAndpublishBeanMapper prizeAndpublishBeanMapper) {
		this.prizeAndpublishBeanMapper = prizeAndpublishBeanMapper;
	}

	@Override
	public int sendWelfare(PrizeAndpublishBean prizeAndpublishBean, String idArray) {
		String subIdArray = idArray.substring(0, idArray.length() - 1);
		String[] userId = subIdArray.split(",");
		int a = 0;
		for (int i = 0; i < userId.length; i++) {
			prizeAndpublishBean.setUserid(Integer.parseInt(userId[0]));
			prizeAndpublishBean.setCreatetime(new Date());
			prizeAndpublishBeanMapper.insert(prizeAndpublishBean);
			a++;
		}
		return a;
	}

	@Override
	public PageVo<Map<String, Object>> getRewardList(PrizeAndpublishBean prizeAndpublishBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", prizeAndpublishBean.getUserid());
		map.put("realName", prizeAndpublishBean.getRealName());
		map.put("userName", prizeAndpublishBean.getUserName());	
		map.put("ptype", prizeAndpublishBean.getPtype());	
		if (prizeAndpublishBean.getCurrentPage() == null) {
			prizeAndpublishBean.setCurrentPage(StaticDefault.pageCurrent);// 设置当前页为1
		}
		if (prizeAndpublishBean.getPageSize() == null) {
			prizeAndpublishBean.setPageSize(StaticDefault.pageSize);// 设置页面的大小
		}
		List<Map<String, Object>> allUser = prizeAndpublishBeanMapper.getRewardList(map,
				(prizeAndpublishBean.getCurrentPage() - 1) * prizeAndpublishBean.getPageSize(), prizeAndpublishBean.getPageSize());
		Integer total = prizeAndpublishBeanMapper.getRewardCount(map);
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo.setVoList(allUser);
		pageVo.setTotal(total);
		pageVo.setPageSize(prizeAndpublishBean.getPageSize());
		pageVo.setCurrentPage(prizeAndpublishBean.getCurrentPage());
		return pageVo;
	}

}
