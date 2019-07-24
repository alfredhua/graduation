<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<jsp:include page="include/head.jsp"></jsp:include>
<title>后台管理</title>
</head>



<jsp:include page="include/foot.jsp"></jsp:include>