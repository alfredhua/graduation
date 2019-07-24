<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../include/head.jsp"></jsp:include>

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
				<form action="record/saveRecord.do" id="addRecordForm" method="post">
					<input type="hidden" name="userid"  id="userid" value="${user.userId }" />
						<table class="table table-bordered">						
							<tr class="info">
							   <td scope="row">用户名:</td>
							   <td><input type="text" id="userName" name="userName" value="${user.userName}" disabled="disabled" ></td>
							   <td scope="row">真实姓名:</td>
							   <td><input type="text" id="realName" name="realName" value="${user.realName}" disabled="disabled"></td>
							</tr>
							<tr class="info">
							   <td scope="row">请假开始时间:</td>
							   <td><input  class="laydate-icon" name="opentime" id="opentime" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
							   <td scope="row">请假结束时间:</td>
							   <td><input class="laydate-icon"  id="endtime" name="endtime"  onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
							</tr>
							<tr class="info">
							   <td scope="row">请假类别:</td>
							   <td colspan="3">
							   <input type="radio" id="absencetype" name="absencetype" value="1"> 事假
							   <input type="radio" id="absencetype" name="absencetype" value="2"> 病假
							   <input type="radio" id="absencetype" name="absencetype" value="3"> 婚假
							   <input type="radio" id="absencetype" name="absencetype" value="4"> 年假  
							   <input type="radio" id="absencetype" name="absencetype" value="5"> 其他    
							   </td>
							 
							</tr>
							<tr class="info">
							   <td scope="row">请假原因:</td>
							   <td colspan="3"><textarea id="reason" name="reason" style="width: 931px; height: 146px;"></textarea></td>	 
							</tr>					
						</table>
						</form>
					   </div>
				</div>
		</div>
<%@include file="../include/foot.jsp" %> 

