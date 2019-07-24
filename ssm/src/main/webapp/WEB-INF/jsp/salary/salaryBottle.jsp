<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/head.jsp"></jsp:include>

<title>薪资发放列表</title>
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
						<form action="salary/getSalaryBottle.do" method="post" id="query" name="query">
							<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
							<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">
						</form>
					</div>
					<div style="margin-top: 25px;">
					<div>
							<table class="table table-bordered">
						  <thead>
							<tr>							 
							  <th>编号</th>
							  <th>用户名</th>
							  <th>真实姓名</th>
							  <th>基本薪资</th>
							  <th>餐补</th>
							  <th>奖惩</th>
							  <th>发放时间</th>
							  <th>总额</th>
							</tr>
						  </thead>
						  <tbody>
						   <c:if test="${empty pageVo.voList}">
						   		<td colspan="8" style="text-align: center;">暂无数据</td>
						   </c:if>
						  <c:if test="${ not empty pageVo.voList}">
						  <c:forEach items="${pageVo.voList }" var="data">
							<tr class="info">
								  <td>${data.userId }</td>
								  <td>${data.userName}</td>
								  <td>${data.realName}</td>
								   <td>${data.basic}</td>
								  <td>${data.eat}</td>
								  <td>${data.punishment}</td>
								  <td> ${data.grantTime}</td>
								  <td>${data.totalize}</td>
							</tr>
							</c:forEach>
							</c:if>
						  </tbody>					
						</table>
					   </div>
					   	   <%@include file="../include/page2.jsp"%>
					   	   </div>
					   	   		<input type="button" onclick="javascript:history.back(-1);" value="返回">
				</div>
		
		</div>
<%@include file="../include/foot.jsp" %> 

