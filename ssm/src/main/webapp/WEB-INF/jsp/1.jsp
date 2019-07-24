<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../include/head.jsp"></jsp:include>

<title>用户列表</title>
</head>
 <body class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include>  
		<div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
	
			<div class="bs-example4" data-example-id="contextual-table">
					<div>
						<a href="user/addUserSend.do" class="a_demo_one">角色添加</a>	
						<a href="user/updateUserSend.do" class="a_demo_one">角色修改</a>	
					</div>
					<div style="margin-top: 25px;">
						<table class="table table-bordered">
						  <thead>
							<tr>
							  <th>选择</th>
							  <th>编号</th>
							  <th>用户名</th>
							  <th>真实姓名</th>
							  <th>年龄</th>
							   <th>性别</th>
							   <th>电话</th>
							   <th>邮箱</th>
							    <th>家庭住址</th>
							</tr>
						  </thead>
						  <tbody>
							<tr class="info">
							  <td>复选框</td>
							  <th scope="row">1</th>
							  <td>Column content</td>
							  <td>Column content</td>
							  <td>Column content</td>
							    <td>Column content</td>
							  <td>Column content</td>
							  <td>Column content</td>
							   <td>Column content</td>

		
							</tr>
						  </tbody>
						</table>
					   </div>
				</div>
		</div>
<%@include file="../include/foot.jsp" %> 

