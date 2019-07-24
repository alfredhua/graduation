<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#basic").focusout(function() {
			var basic = $("#basic").val();
			if (isNaN(basic)) {
				layer.tips('请输入正确的金额', '#basic');
				return false;
			} else {
				addMoney();
			}
		});
		$("#eat").focusout(function() {
			var eat = $("#eat").val();
			if (isNaN(eat)) {
				layer.tips('请输入正确的金额', '#eat');
				return false;
			} else {
				addMoney();
			}
		});
		$("#duty").focusout(function() {
			var duty = $("#duty").val();
			if (isNaN(duty)) {
				layer.tips('请输入正确的金额', '#duty');
				return false;
			} else {
				addMoney();
			}
		});
		$("#punishment").focusout(function() {
			var punishment = $("#punishment").val();
			if (isNaN(punishment)) {
				layer.tips('请输入正确的金额', '#punishment');
				return false;
			} else {
				addMoney();
			}
		});
		$("#scot").focusout(function() {
			var scot = $("#scot").val();
			if (isNaN(scot)) {
				layer.tips('请输入正确的金额', '#scot');
				return false;
			} else {
				addMoney();
			}
		});
		function addMoney() {
			var basic = $("#basic").val();
			var eat = $("#eat").val();
			var duty = $("#duty").val();
			var punishment = $("#punishment").val();
			var scot = $("#scot").val();
			$("#totalize").val(
					Number(basic) + Number(eat) + Number(duty)
							+ Number(punishment) - Number(scot));
		}
		$("#saveSalary").on(
				"click",
				function() {
					var basic = $("#basic").val();
					var eat = $("#eat").val();
					var duty = $("#duty").val();
					var punishment = $("#punishment").val();
					var scot = $("#scot").val();
					var totalize = $("#totalize").val();
					if (isNaN(basic) || isNaN(eat) || isNaN(punishment)
							|| isNaN(scot) || isNaN(duty) || isNaN(totalize)) {
					} else {
							$("#saveSalaryForm").submit();
					}
				});
	});
</script>
<title>薪资管理</title>
</head>
<body class="sticky-header left-side-collapsed">
	<jsp:include page="../list.jsp"></jsp:include>
	<div class="main-content">
		<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
		</div>
		<form id="saveSalaryForm" method="post" action="salary/updateSalary.do">
			<div class="panel-body no-padding" style="display: block;">
				<div class="panel-heading bs-example1" style="text-align: center">
					<table class="table table-bordered font-size1"
						style="width: 90%; margin-left: 65px;">
						<input type="hidden" name="userid" id="userid" value="${map.userId}"/>
						<tbody>
							<tr>
								<td><span style="color: red;">*</span>用户名:</td>
								<td>${map.userName }</td>
								<td><span style="color: red;">*</span>真实姓名:</td>
								<td>${map.realName }</td>
							</tr>
							<tr>
								<td><span style="color: red;">*</span>性别:</td>
								<td><c:if test="${map.sex eq '1'}">男</c:if> <c:if
										test="${map.sex eq '0'}">女</c:if></td>
								<td><span style="color: red;">*</span>入职时间:</td>
								<td><fmt:formatDate value="${map.workDate}"
										pattern="yyyy-MM-dd" /></td>

							</tr>
							<tr>
								<td><span style="color: red;">*</span>身份证号码:</td>
								<td>${map.idCode }</td>
								<td></td>
								<td></td>
							</tr>

							<tr>
								<td><span style="color: red;">*</span>所在部门:</td>
								<td>${map.department_Name }</td>
								<td><span style="color: red;">*</span>职位:</td>
								<td>${map.post_Name }</td>

							</tr>
							<tr>
								<td><span style="color: red;">*</span>基本薪资:</td>
								<td><input type="text" id="basic" name="basic"
									value="${map.basic}" /></td>
								<td><span style="color: red;">*</span>餐补:</td>
								<td><input type="text" id="eat" name="eat"
									value="${map.eat}" /></td>

							</tr>
							<tr>
								<td><span style="color: red;">*</span>全勤奖:</td>
								<td><input type="text" id="duty" name="duty"
									value="${map.duty}" /></td>
								<td>奖惩:</td>
								<td><input type="text" id="punishment" name="punishment"
									value="${map.punishment}" /></td>
							</tr>
							<tr>
								<td><span style="color: red;">*</span>赋税</td>
								<td><input type="text" id="scot" name="scot"
									value="${map.scot}" /></td>
								<td><span style="color: red;">*</span>总计:</td>
								<td><input type="text" id="totalize" name="totalize"
									value="${map.totalize}" /></td>
							</tr>
						</tbody>
					</table>
					<div style="text-align: center">
						<input type="button" id="saveSalary" name="saveSalary"
							class="button blue" value="确定" /> <input type="reset"
							class="button blue" value="重置" />
					</div>
				</div>
			</div>
		</form>
	</div>
	<%@include file="../include/foot.jsp"%>