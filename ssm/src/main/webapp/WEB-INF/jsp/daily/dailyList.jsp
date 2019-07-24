<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<script type="text/javascript">
$(function(){
	$("#ExportDailyBtn").on("click",function(){
		window.open("daily/exportDaily.do");
	/* 	$.post("",function(){
			
		}); */
	});
});
</script>
<title>后台管理</title>
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
					<form action="daily/selectDaily.do" id="query">
					<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
					<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">		
					<input id="workDate1" type="text" name="workDateStart" class="laydate-icon" value="${daily.workDateStart}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
					<input id="workDate2" type="text"  name="workDateEnd" class="laydate-icon" value="${daily.workDateEnd}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
					   <input id="selectDailyBtn" type="submit" value="查询" class="a_demo_one">
						<input id="ExportDailyBtn" type="button" value="导出日报" class="a_demo_one">
					</form>
					</div>
					<div style="margin-top: 25px;">
						<table class="table table-bordered">
							 <thead>
								<tr>
									<th>日报时间</th>
									<th>工作内容</th>
									<th>工作地点</th>
									<th>工作时长</th>
									<th>加班内容</th>
									<th>加班时长</th>
								</tr>
							</thead>
						  <tbody>
						   <c:if test="${empty pageVo.voList}">
						    <tr class="info">
						  		<td colspan="6" style="text-align: center;">未查询到任何数据</td>
						  	 </tr>
						  </c:if>
						  <c:if test="${not empty  pageVo.voList}">
						  	<c:forEach var="data" items="${pageVo.voList}">
							<tr class="info">
									<td><fmt:formatDate value="${data.workDate}" pattern="yyyy-MM-dd" /> </td>
									<td>${data.dailyContext }</td>
									<td>
									  <c:if test="${data.workSite eq '1'}">公司办公</c:if>
									 <c:if test="${data.workSite eq '2'}">本地驻场</c:if>
									 <c:if test="${data.workSite eq '3'}">出差驻场</c:if>
									</td>
									<td>${data.workTime }</td>
									<td><c:if test="${empty  data.overWorkContext }">无</c:if>
									<c:if test="${not empty  data.overWorkContext }">${data.overWorkContext }</c:if></td>
									<td>${data.overTime }</td>
								</tr>
							</c:forEach>
						  </c:if>
						  </tbody>
						</table>
					   </div>
					     <%@include file="../include/page2.jsp"%>
				</div>	
			<%-- 
			<div class="bs-example4" data-example-id="simple-responsive-table">
				<div style="height:80px">
				<div style="float: left;height: 80px">		
				<form action="user/userList.do" method="post" id="query" name="query">
					<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
					<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">				
					<span>日报日期:</span>
					<input id="workDate1" type="text" name="workDateStart" class="laydate-icon mytxt" value="" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
					<input id="workDate2" type="text"  name="workDateEnd" class="laydate-icon mytxt" value="" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
				   <input id="updateUserBtn" type="button" value="查询" class="a_demo_one">
					<input id="deleteUserBtn" type="button" value="导出日报" class="a_demo_one">
				 <div>
				</div>
				</div>
				</form>	
			</div>
			<div class="table-responsive">
			<div class="table table-bordered">
			<table>
			   <tr>
				   <th>日报时间</th>
				   <th>工作内容</th>
				   <th>工作地点</th>
				   <th>工作时长</th>
				   <th>加班内容</th>
				   <th>加班时长</th>
			   </tr>
			   <tr>
			   <c:if test="${empty pageVo.voList}">
			      <td colspan="6" style="text-align: center;">无数据</td>
			   </c:if>
			   <c:if test="${not empty pageVo.voList}">
			     <c:forEach var="data" items="${pageVo.voList}">
			        <td>${data.workDate }</td>
			         <td>${data.dailyContext }</td>
			         <td>${data.workSite }</td>
			         <td>${data.workTime }</td>
			         <td>${data.overWorkContext }</td>
			         <td>${data.overTime }</td>
			      </c:forEach>
			   </c:if>
			   </tr>
			</table>
			</div>
			</div>
			</div> --%>

		</div>
<%@include file="../include/foot.jsp" %> 

