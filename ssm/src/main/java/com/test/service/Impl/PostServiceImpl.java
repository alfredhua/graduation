package com.test.service.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.service.base.BaseService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.PostBean;
import com.test.bean.PostSalaryBean;
import com.test.bean.baseBean.PageVo;
import com.test.dao.PostBeanMapper;
import com.test.dao.PostSalaryBeanMapper;
import com.test.service.PostService;

import javax.annotation.Resource;

@Service("postService")
public class PostServiceImpl  extends BaseService implements PostService {

	private PostBeanMapper postMapper;
	private PostSalaryBeanMapper postSalaryMapper;

	@Override
	public int addPost(PostBean post) {
		int i = postMapper.insert(post);
		if (i > 0) {
			PostSalaryBean postSalary = new PostSalaryBean();
			postSalary.setPostid(post.getPostId());
			postSalary.setBasic(new BigDecimal(post.getBasic()));
			postSalary.setCreatetime(new Date());
			postSalaryMapper.insert(postSalary);
			return i;
		} else {
			return 0;
		}
	}

	@Override
	public int existPost(PostBean post) {
		PostBean postBean = postMapper.selectByPrimaryKey(post.getPostId());
		PostBean postBean2 = postMapper.selectByPostName(post.getPostName());
		if (postBean != null) {
			return 1;
		} else if (postBean2 != null) {
			return 2;
		} else {
			return 0;
		}
	}

	@Override
	public List<Map<String, Object>> getPostListbyDepartmentId(Integer departmentId) {

		return postMapper.getPostListbyDepartmentId(departmentId);
	}

	@Override
	public List<PostBean> getPosbyDepartmentId(Integer departmentId) {

		return postMapper.getPostbyDepartmentId(departmentId);
	}

	public PostBeanMapper getPostMapper() {
		return postMapper;
	}

	@Autowired
	public void setPostMapper(PostBeanMapper postMapper) {
		this.postMapper = postMapper;
	}

	public PostSalaryBeanMapper getPostSalaryMapper() {
		return postSalaryMapper;
	}

	@Autowired
	public void setPostSalaryMapper(PostSalaryBeanMapper postSalaryMapper) {
		this.postSalaryMapper = postSalaryMapper;
	}

	@Override
	public PageVo<Map<String, Object>> getAllPost(PostBean post) {
		Map<String, Object> map = new HashMap<String, Object>();// map为了放查询参数
		map.put("postId", post.getPostId());
		map.put("postName", post.getPostName());
		if (post.getCurrentPage() == null) {
			post.setCurrentPage(1);
		}
		if (post.getPageSize() == null) {
			post.setPageSize(10);
		}
		PageVo<Map<String, Object>> pageVo = new PageVo<Map<String, Object>>();
		pageVo.setCurrentPage(post.getCurrentPage());
		pageVo.setPageSize(post.getPageSize());
		List<Map<String, Object>> postList = postMapper.getAllPost(map,
				(post.getCurrentPage() - 1) * post.getPageSize(), post.getCurrentPage() * post.getPageSize());
		Integer total = postMapper.getAllPostCount(map);
		pageVo.setVoList(postList);
		pageVo.setTotal(total);
		return pageVo;
	}

	@Override
	public Map<String, Object> getPostById(Integer postId) {

		return postMapper.queryPostbyId(postId);
	}

	@Override
	public PostBean getPostByPostId(int postId) {
		return postMapper.selectByPrimaryKey(postId);
	}

}
