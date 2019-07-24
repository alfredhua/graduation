<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<script type="text/javascript">
	$(function(){
	
	});
	function sendSalary(userId){
		$.post("salary/sendSalary.do",{userId:userId},function(msg){
			if(msg=='1'){
				layer.alert("成功发放!");
			}
		});
	}
</script>
<title>薪资管理</title>
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
					<h4>薪资列表</h4>
						<!-- <a href="user/updateUserSend.do" class="a_demo_one">薪资修改</a>	 -->
					</div>
					<div style="margin-top: 25px;">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>编号</th>
							<th>用户名</th>
							<th>真实姓名</th>
							<th>基本薪资</th>
							<th>餐补</th>
							<th>奖惩</th>
							<th>总额</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty pageVo.voList}">
							<td colspan="7" style="text-align: center;">暂无数据</td>
						</c:if>
						<c:if test="${ not empty pageVo.voList}">
							<c:forEach items="${pageVo.voList }" var="data">
								<tr class="info">
									<td>${data.userId}</td>
									<td>${data.userName}</td>
									<td><a
										href="salary/getSalaryBottle.do?userid=${data.userId}">${data.realName}</a></td>
									<td>${data.basic}</td>
									<td>${data.eat}</td>
									<td>${data.punishment}</td>
									<td>${data.totalize}</td>
									<td><a
										href="salary/updateSalarySend.do?userId=${data.userId}"
										class="a_demo_one">修改</a> <a
										onclick="sendSalary(${data.userId})" class="a_demo_one">发放</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
				</div>
		</div>
<%@include file="../include/foot.jsp" %> 

