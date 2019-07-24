<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../include/head.jsp"></jsp:include>

<script type="text/javascript">	
	$(function(){ 
		$("#saveBtn").on("click",function(){
			var leavetime=$("#leavetime").val();		
			var reason=$("#reason").val();
		 if(leavetime==null||""==leavetime){
				layer.tips('离职时间不能为空', '#endtime');
				 return false;
			}else if(reason==null||""==reason){
				layer.tips('离职原因不能为空', '#reason');
				 return false;
			}else{
				$("#addLeavePostForm").submit();
			}	
		});	
	});
</script>
<title>请假申请</title>
</head>
 <body class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include>  
		<div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
	
			<div class="bs-example4" data-example-id="contextual-table">	
						<h4>离职申请</h4>	
				<div style="margin-top: 25px;">
				<form action="postRecord/addleavePost.do" id="addLeavePostForm" method="post">
					<input type="hidden" name="userid"  id="userid" value="${user.userId }" />
						<table class="table table-bordered">						
							<tr class="info">
							   <td scope="row">用户名:</td>
							   <td><input type="text" id="userName" name="userName" value="${user.userName}" disabled="disabled" ></td>
							   <td scope="row">真实姓名:</td>
							   <td><input type="text" id="realName" name="realName" value="${user.realName}" disabled="disabled"></td>
							</tr>
							<tr class="info">
							   <td scope="row">离职时间:</td>
							   <td><input  class="laydate-icon" name="leavetime" id="leavetime" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
							   <td </td>
							   <td></td>
							</tr>						
							<tr class="info">
							   <td scope="row">离职原因:</td>
							   <td colspan="3"><textarea id="reason" name="reason" style="width: 931px; height: 146px;"></textarea></td>	 
							</tr>
							<tr>
								<td style="text-align: right;" colspan="2"><input type="button" id="saveBtn" value="提交"></td>
							   <td colspan="2"><input type="button" value="取消"></td>
							</tr>
						</table>
						</form>
					   </div>
				</div>
		</div>
<%@include file="../include/foot.jsp" %> 

