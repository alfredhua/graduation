package com.test.service.Impl;

import java.util.List;
import java.util.Map;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.DepartmentBean;
import com.test.bean.baseBean.PageVo;
import com.test.dao.DepartmentBeanMapper;
import com.test.service.DepartmentService;

import javax.annotation.Resource;

@Service("departmentService")
public class DepartmentServiceImpl  extends BaseService implements DepartmentService{


	Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	private DepartmentBeanMapper departmentBeanMapper;
	private static Integer DEFAULT_PAGE_SIZE=5;
	

	@Override
	public int updateDepartment(DepartmentBean department) {
		int updateByPrimaryKeySelective = departmentBeanMapper.updateByPrimaryKeySelective(department);
		return updateByPrimaryKeySelective;
	}

	@Override
	public int deleteDepartment(String  IdArray) {
		logger.info("要删除的部门的id"+IdArray);
		String departmentId = IdArray.substring(0,IdArray.length()-1);
		String[] split = departmentId.split(",");
		int deleteByPrimaryKey=0;
		for (int j = 0; j < split.length; j++) {	
			DepartmentBean department = departmentBeanMapper.selectByPrimaryKey(Integer.parseInt(split[j]));
			logger.info("删除的id"+department.getDepartmentId());
			if(department!=null){		
				List<DepartmentBean> department3 = departmentBeanMapper.selectByparentId(Integer.parseInt(split[j]));
				//是否存在子级部门
				if(department3.isEmpty() && department.getParentId()==0){
					deleteByPrimaryKey = departmentBeanMapper.deleteByPrimaryKey(Integer.parseInt(split[j]));
				}else{
					return 0;
				}
			}	 
		}
		return deleteByPrimaryKey;
	}

	@Override
	public DepartmentBean getDepartmentById(Integer departmentId) {
		DepartmentBean departmentBean = departmentBeanMapper.selectByPrimaryKey(departmentId);
		if(departmentBean.getParentId()!=0){
		departmentBean.setParentDepartmentName(
				departmentBeanMapper.selectByPrimaryKey(departmentBean.getParentId())
				.getDepartmentName());
		}
		return  departmentBean;
	}

	@Override
	public List<DepartmentBean> queryDepartment() {
		return departmentBeanMapper.selectAllList();
	}
	@Override
	public DepartmentBean queryAllDepartment(DepartmentBean department) {
		PageVo<DepartmentBean> findPageVo = findPageVo(department);
		try {
			logger.info("开始查询");
			if (findPageVo != null) {
				department.setPageVo(findPageVo);
				int currentPage = department.getPageVo().getCurrentPage();
				logger.info("开始查询"+currentPage);
				int pageSize = department.getPageVo().getPageSize();
			
				List<DepartmentBean> allDepartment = departmentBeanMapper.selectAll((currentPage-1)*pageSize, pageSize);
				if (!allDepartment.isEmpty()) {
					for (int i = 0; i < allDepartment.size(); i++) {
						Integer parentId = allDepartment.get(i).getParentId();
						if (parentId != 0) {
							DepartmentBean parentDepartment = departmentBeanMapper.selectByPrimaryKey(parentId);
							allDepartment.get(i).setParentDepartmentName(parentDepartment.getDepartmentName());
						}else{
							allDepartment.get(i).setParentDepartmentName("无");
						}
					}
				}
				department.getPageVo().setVoList(allDepartment);
				Integer total = departmentBeanMapper.selectCount();
				department.getPageVo().setTotal(total);
				
			}
		} catch (Exception e) {
			logger.info("查询结果有误!");
		}
		return department;
	}
	
	
	
	@Override
	public int insertDepartment(DepartmentBean department) {
		logger.info("开始添加部门,名称:"+
				department.getDepartmentName()+"，id:"+department.getDepartmentId());
		int i = departmentBeanMapper.insert(department);
		if(i>0){
			logger.info("添加部门成功");
			return i;
		}else{
			return -1;
		}
	
	}
	@Override
	public int existAddDepartment(int id,String departmentName) {
		logger.info("验证部门名称和id,名称:"+
				departmentName+"，id:"+id);
		DepartmentBean department1 = departmentBeanMapper.selectByPrimaryKey(id);
		if(department1!=null){
			return 1;
		}
		DepartmentBean department2 = departmentBeanMapper.selectByName(departmentName);
		if(department2!=null){
			return 2;
		}
		return 3;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageVo<DepartmentBean> findPageVo(DepartmentBean department) {
		try {
			if(department!=null){
				PageVo<DepartmentBean> pageVo2 = department.getPageVo();
			if ( pageVo2 != null) {
				PageVo pageVo = new PageVo();
				int pageSize = pageVo2.getPageSize();
				pageVo.setPageSize(pageSize < 1 ? DEFAULT_PAGE_SIZE
						: pageSize);
				pageVo.setCurrentPage(pageVo2.getCurrentPage());

				return pageVo;
			} else {
				PageVo pageVo = new PageVo();
				pageVo.setPageSize(DEFAULT_PAGE_SIZE);
				pageVo.setCurrentPage(1);
				return pageVo;
			}
			}
		} catch (NumberFormatException e) {
			logger.error("格式化页码异常", e);
		}
		return null;
	}
	
	
	public DepartmentBeanMapper getDepartmentBeanMapper() {
		return departmentBeanMapper;
	}
	@Autowired
	public void setDepartmentBeanMapper(DepartmentBeanMapper departmentBeanMapper) {
		this.departmentBeanMapper = departmentBeanMapper;
	}

	@Override
	public DepartmentBean getDepartmentByDepartmentId(Integer departmentId) {
		// TODO Auto-generated method stub
		return departmentBeanMapper.selectBydepartmentId(departmentId);
	}





}
