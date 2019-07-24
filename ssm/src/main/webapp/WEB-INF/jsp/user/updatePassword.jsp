<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<script type="text/javascript">
$(function(){
		/* $("#saveBtn").on("click",function(){
			
		}); */
		$("#oldPassword").focusout(function(){
			$.post("user/checkOldPassword.do",{oldPassword:$("#oldPassword").val()},function(msg){
				if(msg=="false"){
					layer.tips('原密码不正确', '#oldPassword');
					return false;
				}  
			});
		});
		function checkNewPassword(){
			var newPassword=$("#newPassword").val();
			if(newPassword==null||newPassword==""){
				layer.tips('新密码不能为空!', '#newPassword');
				return false;
			}
			var reNewPassword=$("#reNewPassword").val();
			if(reNewPassword==null||""==reNewPassword){
				layer.tips('确认密码不能为空!', '#reNewPassword');
				return false;
			}
			if(newPassword!=reNewPassword){
				layer.tips('俩次密码不一致，请重新输入!', '#reNewPassword');
				return false;
			}
			return true;
		}
		
		$("#saveBtn").on("click",function(){
			if(checkNewPassword()){
				$.post("user/updatePassword.do",{newPassword:$("#newPassword").val()},function(msg){
					if(msg=="true"){
						layer.confirm('密码修改成功,请重新登录!', {
							  btn: ['确定'] //按钮
							}, function(){
								 window.location.reload();
							});
					}
				});
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
			<div class="bs-example4" data-example-id="contextual-table" style="margin: 0 auto;text-align: center;" >
			<div style=" margin-left: 450px;">
				<table>
					<tr>
					<td>原密码:</td>
					<td><input type="password" id="oldPassword" name="oldPassword"></td>
					</tr>
					
					<tr>
					<td>新密码:</td>
					<td><input type="password" id="newPassword" name="newPassword"></td>
					</tr>
					<tr>
					<td>确认密码:</td>
					<td><input type="password" id="reNewPassword" name="reNewPassword"></td>
					</tr>
					<tr>
					<td><input type="button" id="saveBtn" value="确定"></td>
					<td><input type="reset" value="重置"></td>
					</tr>		
				</table>
				</div>
			</div>
		</div>
<%@include file="../include/foot.jsp" %> 

