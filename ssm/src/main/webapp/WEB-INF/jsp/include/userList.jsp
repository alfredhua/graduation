<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<%@ include file="../include/head.jsp"%>
<script type="application/x-javascript"> 
addEventListener("load", function()
		{ setTimeout(hideURLbar, 0); 
		}, 
		false);
	function hideURLbar(){
		window.scrollTo(0,1);
		} 
</script>
<title>后台管理</title>
</head>
 <body class="sticky-header left-side-collapsed" >
<jsp:include page="../list.jsp"></jsp:include>   
		<div class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
						用户列表内容
		</div>
<%@include file="../include/foot.jsp" %> 

