<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<title>职位列表</title>
<script type="text/javascript">

</script>
</head>
 <body class="sticky-header left-side-collapsed" >
<jsp:include page="../list.jsp"></jsp:include>   
		<div class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
			  <div class="bs-example4" data-example-id="contextual-table">		 
			  <div style="height:80px">
				<div style="float: left;height: 60px">		
					<form action="post/alPostList.do" method="post" id="query" name="query">
						<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
						<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">
						<span>职位编号:</span><input type="text" name="postId" value="${post.postId}" class="mytxt">
						<span>职位名称:</span><input type="text" name="postName" value="${post.postName}" class="mytxt">
						<button class="a_demo_one">查询</button>			
					</form>	
				</div>
			</div>
			 <div>
			  <h4>职位列表</h4>
			  </div>	
					<div style="margin-top: 25px;">
						<table class="table table-bordered">
							 <thead>
								<tr>
									<th>职位编号</th>
									<th>职位名称</th>
									<th>职位描述</th>
									<th>所属部门</th>
								</tr>
							</thead>
						  <tbody>
						   <c:if test="${empty pageVo.voList}">
						    <tr class="info">
						  		<td colspan="6" style="text-align: center;">未查询到任何数据</td>
						  	 </tr>
						  </c:if>
						  <c:if test="${not empty pageVo.voList}">
						  	<c:forEach var="data" items="${pageVo.voList}">
							<tr class="info">
								<td>${data.post_id }</td>
								<td><a href="post/getpost.do?postId=${data.post_id }">${data.post_Name }</a></td>
								<td>${data.description }</td>
								<td>${data.departmentName }</td>					
							</tr>
							</c:forEach>
						  </c:if>
						  </tbody>
						</table>
					   </div>
					 <%@include file="../include/page2.jsp"%>
				</div>	
		</div>
<%@include file="../include/foot.jsp" %> 

