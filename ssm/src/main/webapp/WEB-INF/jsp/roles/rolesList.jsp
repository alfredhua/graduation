<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp"%>
<script type="application/x-javascript"> 
	addEventListener("load", function()
		{ 
			setTimeout(hideURLbar, 0); 
		},false);
	
		function hideURLbar(){
			window.scrollTo(0,1);
		} 
		$(function(){
			$('#deleteRole').on('click', function(){
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
					    content: '您未选中任何角色!'
					});		
				}else{
					layer.confirm('确定删除？', {
					    btn: ['确定','取消'] //按钮
					},function(){
					   $.post("role/delRole.do",{id:$("input[name='check']:checked").attr("value") },function(data){
						if(data==1){							
							 window.location.reload();
					    	}
						if(data==0){
							layer.alert('该角色下存在用户，不可删除!!!');
						 }
					   });	
					},function(){
						
					});
				}
				});
			
			$('#updateRole').on('click', function(){
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
					    content: '您未选中任何角色!'
					});		
				}else{
		
					window.location.href="role/updateRoleSend.do?id="+$("input[name='check']:checked").attr("value");
				}
			
		});
		});
		
</script>

<title>角色列表</title>
</head>
 <body class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include>  
		<div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
	
			<div class="bs-example4" data-example-id="contextual-table">
					<div>
						<a href="role/addRoleSend.do" class="a_demo_one">角色添加</a>	
						<a id="updateRole"  class="a_demo_one">角色修改</a>
						<a id="deleteRole"  class="a_demo_one">角色删除</a>	
					</div>
					<div style="margin-top: 25px;">
						<table class="table table-bordered">
						  <thead>
							<tr>
							  <th>选择</th>
							  <th>角色名称</th>
							  <th>备注</th>
							</tr>
						  </thead>
						  <tbody>
						  <c:if test="${empty roleList}">
						  <tr class="info">
						  		未查询到任何数据
						  	</tr>
						  </c:if>
						  <c:if test="${not empty roleList}">
						  	<c:forEach var="role" items="${roleList}">
							<tr class="info">
							  <td>
								<input type="radio" value="${role.id}" id="check" name="check" />							
							  </td>
							  <td scope="row">${role.rolename}</td>
							  <td>${role.remark}</td>	
							</tr>
							</c:forEach>
						  </c:if>
						  </tbody>
						</table>
					   </div>
				</div>
		</div>
<%@include file="../include/foot.jsp" %> 

