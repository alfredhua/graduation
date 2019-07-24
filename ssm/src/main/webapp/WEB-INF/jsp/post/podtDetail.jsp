<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp"%>
<script type="text/javascript">
	
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
	<div class="bs-example4" data-example-id="contextual-table" style="margin: 0 auto;text-align: center;" >
			<div style=" margin-left: 450px;">
				<table style="height: 300px">
					<tr>
					<td>职位编号：</td>
					<td><input id="postId" type="text" maxlength="5" name="postId"  disabled="disabled" value="${map.post_id }" ></td>
					</tr>
					
					<tr>
					<td>职位名称：</td>
					<td><input id="postName" type="text" maxlength="5" name="postName"  disabled="disabled"  value="${map.post_Name }" ></td>
					</tr>
					<tr>
					<td>基本薪资：</td>
					<td><input id="basic" type="text" maxlength="5" name="basic"  disabled="disabled" value="${map.basic }" ></td>
					</tr>
					<tr>
					<td> 职位描述：
					</td>
					<td><textarea id="postdescription" name="postdescription" rows="" cols=""
						style="width: 200px; height: 96px; resize: none"  disabled="disabled">${map.description } </textarea></td>
					</tr>
					
					<tr>
					<td><input type="button" id="returnBtn" name="returnBtn" onclick="javaScript:history.back(-1);" value="返回"></td>	
					</tr>		
				</table>
				</div>
			</div>
		</div>
<%@include file="../include/foot.jsp" %> 

