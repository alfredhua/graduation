<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Easy Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<link href="static/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="static/css/style.css" rel='stylesheet' type='text/css' />
<link href="static/css/font-awesome.css" rel="stylesheet"> 
<link href="static/css/userTable.css" rel="stylesheet"> 
<link href="static/css/partment.css" rel='stylesheet' type='text/css' />
<link href="static/css/myDiv.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="static/css/icon-font.min.css" type='text/css' />
<!-- <link href="static/layer/laydate/need/laydate.css" rel='stylesheet' type='text/css' /> -->
<script src="static/js/Chart.js"></script>



<link href="static/jquery-ui/jquery-ui.css" rel="stylesheet">
<script src="static/jquery-ui/external/jquery/jquery.js"></script>
<script src="static/jquery-ui/jquery-ui.js"></script>

<script src="static/layer/layer.js"></script>
<script src="static/layer/laydate/laydate.js"></script>


<link href="static/css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="static/js/wow.min.js"></script>


<!-- <link href='http://fonts.useso.com/css?family=Cabin:400,400italic,500,500italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
 Meters graphs -->
<script src="static/js/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" href="static/Jcrop/css/jquery.Jcrop.min.css"></link>
<script type="text/javascript" src="static/Jcrop/js/jquery.Jcrop.min.js"></script>
<html>
<head>
<title>登录</title>
<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'> -->
<link href="static/login/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
</head>
<body>
<!-- contact-form -->	
<div class="message warning">
<div class="contact-form">
	<div class="logo">
		<h1>登录</h1>
	</div>	
<!--- form --->
<form class="form" action="admin/login.do" method="post" name="contact_form">
	<ul>
		<li>
			 <label><img src="static/login/images/contact.png" alt=""></label>
			 <input type="text" name="userName" id="userName" placeholder="用户名" required />		            
		 </li>
		 <li>
			 <label><img src="static/login/images/lock.png" alt=""></label>
			 <input type="Password" name="password" name="password" placeholder="密码" required />		         
		 </li>	
		   <p><font color="red">${errorMsg }</font></p>
		 <li class="style">
		     <input type="Submit" value="登录">
		 </li>
	</ul>	
	<div class="clear"></div>	   	
</form>
</div>
<div class="alert-close"></div>
</div>
<div class="clear"></div>
<!--- footer --->
 <div class="footer">
	<p>design by<a href="www.ahua-guo.com">郭振华</a></p>
</div> 
</body>
</html>