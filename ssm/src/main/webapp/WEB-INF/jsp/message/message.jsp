<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>

 <script type="text/javascript">	
	$(function(){
		$("#sendSomeUser").on("click",function(){
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
				layer.open({
			    	title:"消息内容",
			        type: 1,
			        shift: 5,
			        offset:["20%" , "35%"],
			        area: ['250px', '280px'],
			        shadeClose: false, //点击遮罩关闭
			        content: $('#messageDiv')
			    });
			}
		});	
			$("#sendMessageBtn").on("click",function(){
				var ownUser="${user.userId}";
				var IdArray='';
				var arrChk=$("input[name='check']:checked");
			    $(arrChk).each(function(){
			    	if(this.value!=ownUser){
			  	  		IdArray+= this.value+",";      
			    	}
			    }); 
				$.post("message/sendMessageTo.do",{idArray:IdArray,context:$("#context").val()},function(msg){
					if(msg!="0"){
						layer.confirm('发送成功', {
						    btn: ['确定'] //按钮
						},function(){
							 window.location.reload();
						});
					}
				});
			});	

			$("#sendMessageBtn2").on("click",function(){				
				$.post("message/sendMessageTo.do",{idArray:	$("#selecrUserId").val()+",",context:$("#context1").val()},function(msg){
					if(msg!="0"){
						layer.confirm('发送成功', {
						    btn: ['确定'] //按钮
						},function(){
							 window.location.reload();
						});
					}
				});
			});	 

	});

	function sendMessage(userId){
		var ownUser="${user.userId}";
		if(userId==ownUser){			
			layer.alert('不能给自己发送消息')
		}else{
			$("#selecrUserId").val(userId);
			layer.open({
		    	title:"消息内容",
		        type: 1,
		        shift: 5,
		        offset:["20%" , "35%"],
		        area: ['250px', '280px'],
		        shadeClose: false, //点击遮罩关闭
		        content: $('#messageDiv2')
		    });
		}
	} 

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
			<div style="height:40px">
				<div style="float: left;height: 40px">	
				 <form action="message/sendMessage.do" method="post" id="query" name="query">
					<input type="hidden" name="currentPage" id="currentPage" value="${pageVo.currentPage}"/>
					<input type="hidden" name="pageSize" id="pageSize" value="${pageVo.pageSize}">
					<span>用户名:</span><input type="text" name="userName" value="${us.userName}" class="mytxt">
					<span>真实姓名:</span><input type="text" name="realName" value="${us.realName}" class="mytxt">
					<button >查询</button>		
					<input type="button" id="sendSomeUser" name="sendSomeUser" value="消息群发">	
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
							   <th>电话</th>
							   <th>邮箱</th>
								<th>操作</th>
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
							    <td>${data.telephone}</td>
							  <td>${data.email}</td>
							  <td> <a onclick="sendMessage(${data.userId})"  class="a_demo_one">发送消息</a></td> 
						
							</tr>
							</c:forEach>
							
							  </c:if>
						  </tbody>
						</table>
				   </div>
					   <%@include file="../include/page2.jsp"%>
				</div>
			<div id="messageDiv" class="messageDiv" style="display:none;">
			<form id="messageForm" action="message/sendMessageTo.do"
				method="POST" >			
				<div class="box-body">
					<label class="control-label">消息内容： </label>
					<textarea id="context" name="context" rows="" cols=""
						style="width: 200px; height: 96px; resize: none"></textarea>
				</div>
				<div class="box-body">
					<input id="sendMessageBtn" class="button blue" type="button" value="确定">
				</div>
			</form>
		</div>		
				<div id="messageDiv2" class="messageDiv2" style="display:none;">
			<form id="messageForm2" action="message/sendMessageTo.do"
				method="POST" >			
				<div class="box-body">
				<input type="hidden" name="selecrUserId" id="selecrUserId" >
					<label class="control-label">消息内容： </label>
					<textarea id="context1" name="context1" rows="" cols=""
						style="width: 200px; height: 96px; resize: none"></textarea>
				</div>
				<div class="box-body">
					<input id="sendMessageBtn2" class="button blue" type="button" value="确定">
				</div>
			</form>
		</div>	
		</div> 
 <%@include file="../include/foot.jsp" %> 

