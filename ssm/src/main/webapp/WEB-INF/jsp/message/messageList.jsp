<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<title>消息列表</title>
</head>
 <body id="body" class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include> 
		   <div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
				 <form action="message/messageList.do" method="post" id="query" name="query">
					<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
					<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">
				</form>
			<div class="bs-example4" data-example-id="contextual-table">
			<h4>消息列表</h4>
			<div style="margin-top: 25px;">
					<%-- 	<table class="table table-bordered">
						  <thead>
							<tr>
							  <th>发送者姓名</th>
							  <th>内容</th>
							  <th>发送时间</th>
							   <th>状态</th>							   
							</tr>
						  </thead>
						  <tbody>
						  <c:if test="${empty pageVo.voList}">
						  	<tr class="info">							  
							  <th colspan="10" style="text-align: center;">未查到数据</th>
							</tr>
						  </c:if>
						   <c:if test="${not empty pageVo.voList}">
						  <c:forEach items="${pageVo.voList}" var="data">
							<tr class="info">

							  <td>${data.sendUserName}</td>
							  <td>${fn:substring(data.context, 0, 10)}...</td>
							    <td><fmt:formatDate value="${data.sendDate}" pattern="yyyy-MM-dd"/> </td>
							  <td><c:if test="${data.readState eq '1'}">
							  		未读
							  	</c:if>
							  	<c:if test="${data.readState eq '2'}">
							  		已读
							  	</c:if>
							  
							  </td>						
							</tr>
							</c:forEach>
							
							  </c:if>
						  </tbody>
						</table> --%>
						
								
								<table class="table table-fhr">
									<tbody>
								
						<c:if test="${empty pageVo.voList}">
						  <tr class="unread checked">						  
							  <th colspan="10" style="text-align: center;">未查到数据</th>
							</tr>
						  </c:if>
						   <c:if test="${not empty pageVo.voList}">
						  <c:forEach items="${pageVo.voList}" var="data">
							<tr class="unread checked">

							  <td class="hidden-xs">
									<input type="checkbox" class="checkbox" value="${data.id }">
								</td>
								<td class="hidden-xs">
								<c:if test="${data.readState eq '1'}">
							  		<i class="fa fa-star"></i>
							  	</c:if>
							  	<c:if test="${data.readState eq '2'}">
							  		<i class="fa fa-star icon-state-warning"></i>
							  	</c:if>
									
								</td>
								<td>${data.sendUserName}</td>
							  <td><a href="message/watchMessage.do?id=${data.id }">${fn:substring(data.context, 0, 10)}...</a></td>
							    <td><fmt:formatDate value="${data.sendDate}" pattern="yyyy-MM-dd hh:mm:ss"/> </td>
							  <td><c:if test="${data.readState eq '1'}">
							  		未读
							  	</c:if>
							  	<c:if test="${data.readState eq '2'}">
							  		已读
							  	</c:if>
							  
							  </td>						
							</tr>
							</c:forEach>
							
							  </c:if>							
									</tbody>
								</table>
							   </div>
							     <%@include file="../include/page2.jsp"%>
						</div>
						<div class="clearfix"> </div>
					</div>
					</div>
				   </div>
					 
				</div>
		</div> 
 <%@include file="../include/foot.jsp" %> 

