<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<title>职位列表</title>
</head>
 <body class="sticky-header left-side-collapsed" >
<jsp:include page="../list.jsp"></jsp:include>   
		<div class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
			  <div class="bs-example4" data-example-id="contextual-table">
			  <div>
			  <h4>${department.departmentName}</h4>
			  </div>
					<div style="margin-top: 25px;">
						<table class="table table-bordered">
							 <thead>
								<tr>
									<th>职位编号</th>
									<th>职位名称</th>
									<th>职位描述</th>
								</tr>
							</thead>
						  <tbody>
						   <c:if test="${empty postList}">
						    <tr class="info">
						  		<td colspan="6" style="text-align: center;">未查询到任何数据</td>
						  	 </tr>
						  </c:if>
						  <c:if test="${not empty postList}">
						  	<c:forEach var="data" items="${postList}">
							<tr class="info">
									<td>${data.postId } </td>
									<td>${data.postName }</td>
									<td>${data.description }</td>
								</tr>
							</c:forEach>
						  </c:if>
						  </tbody>
						</table>
					   </div>
				</div>	
		</div>
<%@include file="../include/foot.jsp" %> 

