<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>

<title>后台管理</title>
</head>
<body class="sticky-header left-side-collapsed">
	<jsp:include page="../list.jsp"></jsp:include>
	<div class="main-content">
		<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
		</div>
		<div class="bs-example4" data-example-id="contextual-table">
			<h4>请假列表</h4>
			<div>
				<form action="" method="post" id="query" name="query">
					<input type="hidden" name="currentPage" id="currentPage"
						value="${pageVo.currentPage}" /> <input type="hidden"
						name="pageSize" id="pageSize" value="${pageVo.pageSize}">
					<%-- <span>用户名:</span><input type="text" name="userName" value="${us.userName}" class="mytxt"> --%>
					<span>真实姓名:</span><input type="text" name="realName"
						value="${record.realName}" class="mytxt">
					<span>入职时间:</span>
					<input id="openTimeStart" type="text" name="openTimeStart" class="laydate-icon"  value="${record.openTimeStart}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
					<input id="openTimeEnd" type="text"  name="openTimeEnd" class="laydate-icon"  value="${record.openTimeEnd}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"> 
					<button>查询</button>
				</form>
			</div>
			<div style="margin-top: 25px;">

				<table class="table table-bordered">
					<tr class="info">
						<th>用户名:</th>
						<th>真实姓名:</th>
						<th>请假开始时间</th>
						<th>请假结束时间</th>
						<th>原因</th>
						<th>类型</th>
						<th>状态</th>
					</tr>
					<c:if test="${empty pageVo.voList}">
						<tr class="info">
							<td colspan="7" style="text-align: center;">暂无数据</td>
						</tr>
					</c:if>
					<c:if test="${not empty pageVo.voList}">
						<c:forEach var="data" items="${ pageVo.voList}">
							<tr class="info">
								<td><a href="record/getRecordById.do?id=${data.id}&userid=${data.userid}">${data.userName}</a></td>
								<td>${data.realName}</td>
								<td><fmt:formatDate value="${data.openTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td><fmt:formatDate value="${data.endTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>${data.reason}</td>
								<td><c:if test="${data.absenceType eq '1'}">事假</c:if> <c:if
										test="${data.absenceType eq '2'}">病假</c:if> <c:if
										test="${data.absenceType eq '3'}">婚假</c:if> <c:if
										test="${data.absenceType eq '4'}">年假</c:if> <c:if
										test="${data.absenceType eq '5'}">其他</c:if></td>
								<td><c:if test="${data.state eq '1'}">未审批</c:if>
								<c:if test="${data.state eq '2'}">同意</c:if>
								<c:if test="${data.state eq '3'}">拒绝</c:if></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
			<%@include file="../include/page2.jsp"%>
		</div>
	</div>
	<%@include file="../include/foot.jsp"%>