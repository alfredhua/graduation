<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/head.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$("#passBtn").on("click",function(){
			var checklength=$("input[name='check']:checked").length;
			if(checklength!=1)
			{
				layer.open({
				    type: 1,
				    title: '提示',
				    closeBtn:1, //不显示关闭按钮
				    shade: [0],
				    area: ['300px', '205px'],
				    offset: 'rb', //右下角弹出
				    time: 4000, //2秒后自动关闭
				    shift: 2,
				    content: ' 您未选中指定的用户或选中多个'//iframe的url，no代表不显示滚动条
				});		
			}else{
				$.post("postRecord/passLeavePost.do",
						{userid:$("input[name='check']:checked").attr("value"),
						leavestatus:4},
						function(msg){
							if(msg=="1"){
								window.location.href="postRecord/leavePostList.do?";
								}else{
									location.reload(); 
								}
				});
			}
		});
		$("#notPassBtn").on("click",function(){
			var checklength=$("input[name='check']:checked").length;
			if(checklength!=1)
			{
				layer.open({
				    type: 1,
				    title: '提示',
				    closeBtn:1, //不显示关闭按钮
				    shade: [0],
				    area: ['300px', '205px'],
				    offset: 'rb', //右下角弹出
				    time: 4000, //2秒后自动关闭
				    shift: 2,
				    content: ' 您未选中指定的用户或选中多个'//iframe的url，no代表不显示滚动条
				});		
			}else{
				$.post("postRecord/passLeavePost.do",
						{userid:$("input[name='check']:checked").attr("value"),
						leavestatus:5},
						function(msg){
							if(msg=="1"){
							window.location.href="postRecord/leavePostList.do?";
							}else{
								location.reload(); 
							}
				});
			}
		});
	});
</script>
<title>离职列表</title>
</head>
 <body class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include>  
		<div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
	
			<div class="bs-example4" data-example-id="contextual-table">					
				 <form action="postRecord/leavePostList.do" method="post" id="query" name="query">
					<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
					<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">
					<span>用户名:</span><input type="text" name="userName" value="${leavePostBean.userName}" class="mytxt">
					<span>真实姓名:</span><input type="text" name="realName" value="${leavePostBean.realName}" class="mytxt">
					<span>离职时间:</span>
					<input id="leaveTimeStart" type="text" name="leaveTimeStart" class="laydate-icon"  value="${leavePostBean.leaveTimeStart}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
					<input id="leaveTimeEnd" type="text"  name="leaveTimeEnd" class="laydate-icon"  value="${leavePostBean.leaveTimeEnd}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
					<button >员工查询</button>	
					<input type="button" id="passBtn" name="passBtn" value="通过">
					<input type="button" id="notPassBtn" name="notPassBtn" value="拒绝">
				</form>
					<div style="margin-top: 25px;">
						<table class="table table-bordered">
						  <thead>
							<tr>
							  <th>选择</th>
							  <th>编号</th>
							  <th>用户名</th>
							  <th>真实姓名</th>
							  <th>部门</th>
							   <th>职位</th>
							   <th>离职时间</th>
							   <th>离职原因</th>	
							   <th>状态</th>									    
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
							  <td><a href="postRecord/watchLeavePost.do?userid=${data.userId}">${data.userName}</a></td>
							  <td>${data.realName}</td>
							  <td>${data.departmentName}</td>
							  <td> ${data.postName}</td>							    
							    <td><fmt:formatDate value="${data.leavetime}" pattern="yyyy-MM-dd"/> </td> 
							    <td>${data.reason}</td>
							    <td>
							    	<c:if test="${data.leaveStatus eq '0'}">审请中</c:if>
							    	<c:if test="${data.leaveStatus eq '4'}">已离职</c:if>
							    	<c:if test="${data.leaveStatus eq '5'}">拒绝</c:if>  
							    </td>  
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

