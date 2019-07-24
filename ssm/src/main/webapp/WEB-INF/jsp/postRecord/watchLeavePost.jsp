<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/head.jsp"></jsp:include>

<title>离职详情</title>

<script type="text/javascript">
	$(function(){
		$("#passBtn").on("click",function(){
				$.post("postRecord/passLeavePost.do",
						{userid:$("#userid").val(),
						leavestatus:4},
						function(msg){
							if(msg=="1"){
								window.location.href="postRecord/leavePostList.do?";
								}else{
									location.reload(); 
								}
				});
		
		});
		$("#notPassBtn").on("click",function(){			
				$.post("postRecord/passLeavePost.do",
						{userid:$("#userid").val(),
						leavestatus:5},
						function(msg){
							if(msg=="1"){
							window.location.href="postRecord/leavePostList.do?";
							}else{
								location.reload(); 
							}
				});

		});
	});
</script>
</head>
 <body class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include>  
		<div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
	
			<div class="bs-example4" data-example-id="contextual-table">	
			<h4>离职详情</h4>	
				<div style="margin-top: 25px;">
				<form action="record/saveRecord.do" id="addRecordForm" method="post">
					<input type="hidden" name="userid"  id="userid" value="${map.userId }" />
						<table class="table table-bordered">						
							<tr class="info">
							   <td scope="row">用户名:</td>
							   <td>${map.userName }</td>
							   <td scope="row">真实姓名:</td>
							   <td>${map.realName }</td>
							</tr>
							<tr class="info">
							   <td scope="row">离职时间:</td>
							   <td><fmt:formatDate value="${map.leavetime}" pattern="yyyy-MM-dd"/></td>
							   <td scope="row"></td>
							   <td></td>
							</tr>

							<tr class="info">
							   <td scope="row">离职原因:</td>
							   <td colspan="3"><textarea id="reason" name="reason" style="width: 931px; height: 146px;" disabled="disabled">${map.reason}</textarea></td>	 
							</tr>	
							<tr class="info">
							   <td colspan="4">	<input type="button" id="passBtn" name="passBtn" value="通过">
									<input type="button" id="notPassBtn" name="notPassBtn" value="拒绝">	
									 <input type="button" id="returnBtn" name="returnBtn" value="返回" onclick="javascript:history.back(-1);">
							 </td>

							</tr>	
								
						</table>
						</form>
					   </div>
				</div>
		</div>
<%@include file="../include/foot.jsp" %> 

