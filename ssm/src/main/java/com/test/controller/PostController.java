package com.test.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.DepartmentBean;
import com.test.bean.PostBean;
import com.test.bean.baseBean.PageVo;
import com.test.service.DepartmentService;
import com.test.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	@Resource
	private PostService postService;
	
	@Resource
	private DepartmentService  departmentService;
	
	@RequestMapping("addPost.do")
	@ResponseBody
	public int addPost(PostBean post, Model model){
		return  postService.addPost(post);
	}
	@RequestMapping("existPost.do")
	@ResponseBody
	public int existPost(PostBean post, Model model){
		return  postService.existPost(post);
	}
	
	@RequestMapping("postList.do")
	public String getPostListbyDepartmentId(PostBean post,Model model){
		List<Map<String, Object>> postList = postService.getPostListbyDepartmentId(post.getDepartmentId());
		DepartmentBean department = departmentService.getDepartmentById(post.getDepartmentId());
		model.addAttribute("postList", postList);
		model.addAttribute("department", department);
		return "post/postList";
	}
	@RequestMapping("alPostList.do")
	public String getAllPost(PostBean post,Model model){
		PageVo<Map<String,Object>> pageVo=new PageVo<Map<String,Object>>();
		 pageVo = postService.getAllPost(post);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("post", post);
		return "post/allPost";
	}
	
	@RequestMapping("getPost.do")
	@ResponseBody
	public List<PostBean> getPost(@Param("departmentId") Integer departmentId, Model model) {
		List<PostBean> postList = postService.getPosbyDepartmentId(departmentId);
		return postList;
	}
	
	@RequestMapping("getpost.do")
	public String getPostById(PostBean post,Model model){
		 Map<String, Object> map = postService.getPostById(post.getPostId());
		model.addAttribute("map", map);
		return "post/podtDetail";
	}
	
}
