<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					
				 <form action="postRecord/postRecordList.do" method="post" id="query" name="query">
					<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
					<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">
					<span>用户名:</span><input type="text" name="userName" value="${postRecord.userName}" class="mytxt">
					<span>真实姓名:</span><input type="text" name="realName" value="${postRecord.realName}" class="mytxt">
					<button class="a_demo_one">员工查询</button>	
				</form>
					<div style="margin-top: 25px;">
						<table class="table table-bordered">
						  <thead>
							<tr>
							  <th>选择</th>
							  <th>编号</th>
							  <th>用户名</th>
							  <th>真实姓名</th>
							  <th>原部门</th>
							   <th>原职位</th>
							   <th>当前部门</th>
							   <th>当前职位</th>
							   <th>调职时间</th>									    
							</tr>
						  </thead>
						  <tbody>
							  <c:if test="${empty pageVo.voList}">
						  	<tr class="info">							  
							  <th colspan="9" style="text-align: center;">未查到数据</th>
							</tr>
						  </c:if>
						   <c:if test="${not empty pageVo.voList}">
						  <c:forEach items="${pageVo.voList}" var="data">
							<tr class="info">
							  <td>	
							  <input type="checkbox" value="${data.userId}" id="check" name="check" />
							  </td>
							  <td>${data.userId}</td>
							  <td>${data.userName}</td>
							  <td>${data.realName}</td>
							  <td>${data.oldDepartment}</td>
							  <td> ${data.oldPost}</td>
							    <td>${data.newDepartmentName}</td>
							  <td>${data.newPostName}</td>
							  <td><fmt:formatDate value="${data.changeTime}" pattern="yyyy-MM-dd"/> </td>
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

