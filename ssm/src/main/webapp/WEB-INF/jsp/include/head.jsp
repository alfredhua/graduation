<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--  <spring:eval var="menus" expression="@menuService.selectMenu(1)" />  --%>
<spring:eval var="menus" expression="@menuService.selectMenu(${user.userId})" /> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<!-- bootstrap -->
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="static/jquery/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>


<script src="static/echarts/echarts.min.js"></script>
