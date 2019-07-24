<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../include/head.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="application/x-javascript"> 	
		$(function(){
			laydate.skin('molv');
			$("#saveUser").on("click",function(){				
				if(check()){
	                 $.post("user/addUser.do",  $("#addUserForm").serialize(),             
						 function (data) {
	                		 if(data=="true"){
	                			 layer.confirm('添加成功', {
	                				  btn: ['确定'] //按钮
	                				}, function(){
	                					window.location.href="user/userList.do";
	                				});
	                			 
	                		 }else{
	                	     	 layer.alert('添加失败，请重新添加');
	                	     	 $("#addUserForm").reset();
	                	     	 window.location.reload(); 
	                		 }
					    });
				}	
			});
			
			$("#department").on("click",function(){
				var id=$("#department").find("option:selected").attr("post_departmentId");
				if(id==0){
					 $("#postId").find("option").remove();
					  $("#postId").append("<option value='0'>请选择</option>");
				}else{
					$.ajax({
						 type: "POST",
						 url: "post/getPost.do",
						 data: "departmentId="+id,
						 success: function(msg){		
							 var contact = JSON.parse(msg);  
							 $("#postId").find("option").remove();
							  $(contact).each(function(i,item){
								  $("#postId").append("<option value='"+item.postId+"'>"+item.postName+"</option>");
							   });
						 }
					});
				}
			});
			
			
			//验证身份证号码
			$("#userName").blur(function(){
				var userName=$("#userName").val();
				if(userName!=null||userName!=""){
				$.ajax({
					   type: "POST",
					   url: "user/existUserName.do",
					   data: "userName="+userName,
					   success: function(msg){
					    if(msg=="false"){
					    	layer.tips('用户名已存在', '#userName');
					    	return false;
					    }else{
					    	return true;
					    }
					   }
					});
				}
			});
			//验证身份证号码
			$("#idCode").blur(function(){
				var idCode=$("#idCode").val().trim();
				if(idCode!=null&&idCode!=""){
				$.ajax({
					   type: "POST",
					   url: "user/existIdCode.do",
					   data: "idCode="+idCode,
					   success: function(msg){
					    if(msg==false){
					    	layer.tips('此身份证号已存在', '#idCode');
					    	return false;
					    }
					   }
					});
				$.ajax({
					   type: "POST",
					   url: "user/checkIdCode.do",
					   data: "idCode="+idCode,
					   dataType:"json",
					   success: function(msg){
						var msg1 = JSON.parse(msg);
					
					    if(msg1.errNum==-1){
					    	layer.tips('请输入正确的身份账号', '#idCode');
					    	return false;
					    }else{
					    	return true;
					    }
					   }
					});
				}else{				
						layer.tips('请输入身份证号', '#idCode');
						return false;
				}
			});
			function check(){
				var userName=$("#userName").val();
				if(userName==null||userName==""){
					layer.tips('用户名不能为空', '#userName');
					return false;
				}
				var password=$("#password").val();
				if(password==null||password==""){
					layer.tips('密码不能为空', '#password');
					return false;
				}
				var password2=$("#password2").val();
				if(password2==null||password2==""){
					layer.tips('确认密码不能为空', '#password2');
					return false;
				}
				if(password.length<=6){
					layer.tips('密码的长度小于6位', '#password');
					return false;
				}
				var idCode=$("#idCode").val().trim();
				if(idCode==null&&idCode==""){
					layer.tips('身份证号码不能为空', '#idCode');
					return false;
				}
				if(password2!=password){
					layer.alert('俩次密码不一字');
					return false;
				}
				var realname=$("#realname").val();
				if(realname==null||realname==""){
					layer.tips('真实姓名不能为空', '#realname');
					return false;
				}
				var birthday=$("#age").val();
				if(birthday==null||birthday==""){
					layer.tips('年龄不能为空', '#age');
					return false;
				}
				var workDate=$("#workDate").val();
				if(workDate==null||workDate==""){
					layer.tips('入职时间不能为空', '#workDate');
					return false;
				}
				var department=$("#department").val();
				if(department==null||department==""||department==0){
					layer.tips('请选择部门', '#department');
					return false;
				}
				var post=$("#postId").val();
				if(post==null||post==""||post==0){
					layer.tips('请选择部门', '#postId');
					return false;
				}
				var state=$("#state").val();
				if(state==null||state==""||state==0){
					layer.tips('请选择状态', '#state');
					return false;
				}
				var roles=$("#roles").val();
				if(roles==null||roles==""||roles==0){
					layer.tips('请选择角色', '#roles');
					return false;
				}
				return true;
			}
			
		});

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
		<form id="addUserForm"  method="post">
		<div class="panel-body no-padding" style="display: block;">
			<div class="panel-heading bs-example1" style="text-align: center">
				<table class="table table-bordered font-size1" style="width:90% ;margin-left: 65px;" >
					  <tbody>
					  	<tr>
					  		<td><span style="color:red;">*</span>用户名:</td>
					  		<td><input type="text" id="userName" name="userName" /></td>
					  		<td><span style="color:red;">*</span>密码:</td>
					  		<td><input type="password" id="password" name="password" /></td>
					  	</tr>
					  	<tr>
					  		<td><span style="color:red;">*</span>性别:</td>
					  		<td>
					  		<input type="radio" id="sex" name="sex" value="1" checked/>男
					  		<input type="radio" id="sex" name="sex" value="0"/>女</td>
					
					  		<td><span style="color:red;">*</span>确认密码:</td>
					  		<td><input type="password" id="password2" name="password2" /></td>
					  	</tr>
					  	<tr>
					  		<td><span style="color:red;">*</span>真实姓名:</td>
					  		<td><input type="text" id="realname" name="realName" /></td>
					  		 <td><span style="color:red;">*</span>身份证号码:</td>
					  		<td><input type="text" id="idCode" name="idcode" /></td>
					  	</tr>
					  	<tr>
						  	<td><span style="color:red;">*</span>年龄:</td>
						  	<td>
						  	<input  type="text"  id="age" name="age"/>
						  	</td>
					  		<td>电话:</td>
					  		<td><input type="text" id="telephone" name="telephone"  /></td>
					  	</tr>
					  	<tr>
					  		<td><span style="color:red;">*</span>入职时间:</td>
					  		<td>
					  		<input id="workDate" name="workDate" class="laydate-icon"  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
					  		</td>
					  		<td>邮箱:</td>
					  		<td><input type="text" id="email" name="email"/></td>
					  	</tr>
					  	<tr>
					  		<td><span style="color:red;">*</span>所在部门:</td>
					  		<td>
					  			<select id="department" name="departmentId" class="selected">
					  				<option value="0" post_departmentId="0">请选择</option>
					  				<c:forEach var="data" items="${departmentList}">
					  			     <option value="${data.departmentId}" post_departmentId="${data.id}">${data.departmentName}</option> 
								     </c:forEach>
					  				</select>
					  		</td>
					  		<td><span style="color:red;">*</span>职位:</td>
					  		<td>
					  			<select id="postId" name="postId" class="selected">
					  		     	<option value="0">请选择</option>
					  				<%-- <option value="0">请选择</option>
					  				<c:forEach var="data" items="${postList}">
					  			     <option value="${data.departmentId}">${data.departmentName}</option> 
								     </c:forEach> --%>
					  			</select>
					  		</td>					  	
					  	</tr>
					  	<tr>
					  		<td><span style="color:red;">*</span>角色:</td>
					 	 	<td><select id="roles" name="roles" class="selected">
					  			<option value="0">请选择</option>
					  			<c:forEach var="data" items="${roleList}">
					  			 <option value="${data.id}" >${data.rolename}</option> 
								</c:forEach>
					  		</select></td>
						  	<td><span style="color:red;">*</span>状态:</td>
					 	 	<td>
						 	 	<select id="state" name="state" class="selected">
						  			<option value="0">请选择</option>					  			
						  			<c:forEach var="data" items="${emplyeeStatus}">
						  			 <option value="${data.id}" >${data.name}</option> 
									</c:forEach>
						  		</select>
					  		</td>	  	
					  	</tr>
					  	<tr>				  	
					  		<td>地址:</td>
					 	 	<td>
					 			 <input type="text" id="address" name="address" value="${userUp.address}"/>			  
					  		</td>
					  	</tr>
					  </tbody>
					</table>
					<div style="text-align: center">										
					  	<input type="button" id="saveUser" name="saveUser" class="button blue"  value="确定"/>
					  	<input type="button" class="button blue"  value="返回" onclick="javascript:history.back(-1)"/>
					  					 
					</div>
				</div>
			</div>
		</form>
	</div>
<%@include file="../include/foot.jsp" %> 

