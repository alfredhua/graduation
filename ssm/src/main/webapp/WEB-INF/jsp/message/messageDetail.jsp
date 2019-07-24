<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../include/head.jsp"></jsp:include>
<script type="text/javascript">
		$(function(){
			$("#returnBtn").on("click",function(){
				window.location.href="message/messageList.do";
			});
		});
</script>
<title>消息详情</title>
</head>
 <body class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include>  
		<div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
	
			<div class="bs-example4" data-example-id="contextual-table">	
						<div class="panel-body panel-body-com-m">
										<div class="alert alert-info">
											消息详情
										</div>
										<form class="com-mail">
											<hr>
												<label>发送人姓名: </label>
												<input type="text" class="form-control1 control3" value="${message.realName}" disabled="disabled" >
												<label>发送时间 :  </label>	
												<input type="text" class="form-control1 control3" value='${message.senddate}' disabled="disabled">
												<label>消息内容: </label>
												<textarea rows="6" class="form-control1 control2" disabled="disabled">${message.context }</textarea>
											<hr>
											<input type="button" id="returnBtn" value="返回">
										</form>
									</div>
								 </div>
			</div>
		</div>
<%@include file="../include/foot.jsp" %> 

