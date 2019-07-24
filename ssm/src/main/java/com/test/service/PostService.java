package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.bean.PostBean;
import com.test.bean.baseBean.PageVo;

public interface PostService {
	
	public int addPost(PostBean post);

	public int existPost(PostBean post);
	
	public List<Map<String,Object>> getPostListbyDepartmentId(Integer departmentId);

	public PageVo<Map<String,Object>> getAllPost(PostBean post);
	
	public List<PostBean> getPosbyDepartmentId(Integer departmentId);

	public  Map<String,Object> getPostById(Integer postId); 
	
	public PostBean getPostByPostId(int postId);

}
