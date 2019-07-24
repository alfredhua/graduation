<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>

 <script type="text/javascript">	
$(function(){
	$("#updateUserBtn").on("click",function(){
	
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
			window.location.href="user/updateUserSend.do?userId="+$("input[name='check']:checked").attr("value");
			/* $.post("user/updateUserSend.do", {"userId":$("input[name='check']:checked").attr("value")},function(data){
				$("#body").html(data);
			}); */
		}
	});
	$("#deleteUserBtn").on("click",function(){
		var checklength=$("input[name='check']:checked").length;
		if(checklength<1)
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
			    content: '您未选中指定用户!'
			});		
		}else{
			var IdArray='';
			var arrChk=$("input[name='check']:checked");
		    $(arrChk).each(function(){
		  	  	IdArray+= this.value+",";                       
		    }); 
			$.ajax({
				type: "POST",
				url: "user/deleteUser.do",
				data:{"IdArray":IdArray},
				success:function(data){
					if(data=="true"){
						layer.confirm('删除成功', {
						    btn: ['确定'] //按钮
						},function(){
							 window.location.reload();
						})
					}
				}
			});
		}
		
	});
	$("#updateUserPost").on("click",function(){
		var checklength=$("input[name='check']:checked").length;
		if(checklength<1)
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
			    content: '您未选中指定用户!'
			});		
		}else{
			window.location.href="user/updateUserPost.do?userId="+$("input[name='check']:checked").attr("value");
		}
		
	});
	
	
});
</script>
<title>用户列表</title>
</head>
 <body id="body" class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include> 
		   <div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
			<div class="bs-example4" data-example-id="contextual-table">
			<div style="height:80px">
				<div style="float: left;height: 80px">	
				 <form action="user/userList.do" method="post" id="query" name="query">
					<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
					<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">
					<span>用户名:</span><input type="text" name="userName" value="${us.userName}" class="mytxt">
					<span>真实姓名:</span><input type="text" name="realName" value="${us.realName}" class="mytxt">
					<span>入职时间:</span>
					<input id="workDate1" type="text" name="workDateStart" class="laydate-icon"  value="${us.workDateStart}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
					<input id="workDate2" type="text"  name="workDateEnd" class="laydate-icon"  value="${us.workDateEnd}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
				
				<div>
				<br>
					<!-- <button class="a_demo_one">员工查询</button> -->
					<button class="a_demo_one">员工查询</button>	
					<input id="resetBtn" type="reset" value="重    置" class="a_demo_one">
					<a href="user/addUserSend.do" class="a_demo_one">添加员工</a>	
					<input id="updateUserBtn" type="button" value="员工修改" class="a_demo_one">
					<input id="deleteUserBtn" type="button" value="员工删除" class="a_demo_one">
					<input id="updateUserPost" type="button" value="员工调动" class="a_demo_one">
				</div>
				</div>
					</form>	
			</div>	
			
				<div style="margin-top: 25px;">
						<table class="table table-bordered">
						  <thead>
							<tr>
							  <th>选择</th>
							  <th>编号</th>
							  <th>用户名</th>
							  <th>真实姓名</th>
							  <th>年龄</th>
							   <th>性别</th>
							   <th>入职时间</th>
							   <th>电话</th>
							   <th>邮箱</th>
							    <th>家庭住址</th>
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
							  <td>	
							  <input type="checkbox" value="${data.userId}" id="check" name="check" />
							  </td>
							  <td>${data.userId}</td>
							  <td>${data.userName}</td>
							  <td>${data.realName}</td>
							  <td>${data.age}</td>
							  <td>
							      <c:if test="${data.sex eq '1'}">男</c:if>
							 	  <c:if test="${data.sex eq '0'}">女</c:if>
							  </td>
							   <td><fmt:formatDate value="${data.workDate}" pattern="yyyy-MM-dd"/> </td>
							    <td>${data.telephone}</td>
							  <td>${data.email}</td>
							  <td>${data.address}</td>
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

