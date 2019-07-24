<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../include/head.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<script type="text/javascript">
$(function(){
	var id="${map.id}";
	$("#passBtn").on("click",function(){
		$.post("record/updateStatus.do",{idArray:id+",",status:2},function(msg){
			if(msg!='0'){
				layer.confirm('修改成功', {
					  btn: ['重要'] //按钮
					}, function(){
					  window.location.href="record/selectRrcord.do";
					});
			}
		});
	});
	
	$("#notPassBtn").on("click",function(){
		$.post("record/updateStatus.do",{idArray:id+",",status:3},function(msg){
			if(msg!='0'){
				layer.confirm('修改成功', {
					  btn: ['重要'] //按钮
					}, function(){
					  window.location.href="record/selectRrcord.do";
					});
			}
		});
	});
	
});
</script>
<title>详情列表</title>
</head>
 <body class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include>  
		<div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
	
			<div class="bs-example4" data-example-id="contextual-table">	
						<h4>请假详情</h4>	
				<div style="margin-top: 25px;">
				
					<input type="hidden" name="userid"  id="userid" value="${map.userId }" />
						<table class="table table-bordered">						
							<tr class="info">
							   <td scope="row">用户名:</td>
							   <td><input type="text" id="userName" name="userName" value="${map.userName}" disabled="disabled" ></td>
							   <td scope="row">真实姓名:</td>
							   <td><input type="text" id="realName" name="realName" value="${map.realName}" disabled="disabled"></td>
							</tr>
							<tr class="info">
							   <td scope="row">请假开始时间:</td>
							   <td><input disabled="disabled"  class="laydate-icon" name="opentime" id="opentime" value="${map.openTime}" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
							   <td scope="row">请假结束时间:</td>
							   <td><input disabled="disabled" class="laydate-icon"  id="endtime" name="endtime"  value="${map.endTime}" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
							</tr>
							<tr class="info">
							   <td scope="row">请假类别:</td>
							   <td colspan="3">
									<c:if test="${map.absenceType eq '1'}">事假</c:if> <c:if
										test="${map.absenceType eq '2'}">病假</c:if> <c:if
										test="${map.absenceType eq '3'}">婚假</c:if> <c:if
										test="${map.absenceType eq '4'}">年假</c:if> <c:if
										test="${map.absenceType eq '5'}">其他</c:if>
								</td>
							 
							</tr>
							<tr class="info">
							   <td scope="row">请假原因:</td>
							   <td colspan="3"><textarea id="reason" name="reason" style="width: 931px; height: 146px;" disabled="disabled">${map.reason}</textarea></td>	 
							</tr>	
							<tr class="info">				
							   <td colspan="4">
							   <input type="button" id="returnBtn" onclick="javascript :history.back(-1);" value="返回">
							   <input type="button" id="passBtn"  value="通过">
							   <input type="button" id="notPassBtn"  value="拒绝">
							   </td>	 
							</tr>				
						</table>
					
					   </div>
				</div>
		</div>
<%@include file="../include/foot.jsp" %> 

