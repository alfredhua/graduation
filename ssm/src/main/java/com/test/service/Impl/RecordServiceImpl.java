package com.test.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.test.bean.RecordBean;
import com.test.bean.baseBean.PageVo;
import com.test.dao.RecordBeanMapper;
import com.test.service.RecordService;

@Service("recordService")
public class RecordServiceImpl  extends BaseService implements RecordService {

	private RecordBeanMapper recordMapper;

	@Override
	public int addRecord(RecordBean record) {
		record.setState(1);// 表示申请，但是未通过审核
		return recordMapper.insert(record);
	}

	public RecordBeanMapper getRecordMapper() {
		return recordMapper;
	}

	@Resource
	public void setRecordMapper(RecordBeanMapper recordMapper) {
		this.recordMapper = recordMapper;
	}

	@Override
	public PageVo<Map<String, Object>> getRecordList(RecordBean recordBean) {
		Map<String, Object> map = buildParm(recordBean);
		if (recordBean.getCurrentPage() == null) {
			recordBean.setCurrentPage(1);
		}
		if (recordBean.getPageSize() == null) {
			recordBean.setPageSize(10);
		}
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo.setCurrentPage(recordBean.getCurrentPage());
		pageVo.setPageSize(recordBean.getPageSize());
		List<Map<String, Object>> recordList = recordMapper.getRecordPage(map,
				(recordBean.getCurrentPage() - 1) * recordBean.getPageSize(),
				recordBean.getCurrentPage() * recordBean.getPageSize());
		int recordCount = recordMapper.getRecordCount(map);
		pageVo.setTotal(recordCount);
		pageVo.setVoList(recordList);
		return pageVo;
	}

	public Map<String, Object> buildParm(RecordBean recordBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (recordBean.getUserid() != null && (!"".equals(recordBean.getUserid()))) {
			map.put("userId", recordBean.getUserid());
		}
		if (recordBean.getOpenTimeStart() != null && (!"".equals(recordBean.getOpenTimeStart()))) {
			map.put("openTimeStart", recordBean.getOpenTimeStart());
		}
		if (recordBean.getOpenTimeEnd() != null && (!"".equals(recordBean.getOpenTimeEnd()))) {
			map.put("openTimeEnd", recordBean.getOpenTimeEnd());
		}
		if (recordBean.getRealName() != null && (!"".equals(recordBean.getRealName()))) {
			map.put("realName", recordBean.getRealName());
		}
		return map;
	}

	@Override
	public Map<String, Object> getRecordById(Integer id) {
		Map<String, Object> map = recordMapper.selectById(id);
		return map;
	}

	@Override
	public int updateStatus(String idArray,String status) {
		int a = 0;
		if (!"".equals(idArray)) {
			String id = idArray.substring(0, idArray.length() - 1);
			String[] split = id.split(",");
			for (int j = 0; j < split.length; j++) {
				recordMapper.updateStatusByid(Integer.parseInt(split[j]),Integer.parseInt(status));
				a++;
			}
		}
		return a;
	}

}
