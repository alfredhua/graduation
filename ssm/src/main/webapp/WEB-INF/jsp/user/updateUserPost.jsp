<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/head.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
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
	$("#saveBtn").on("click",function(){
		$.post("user/transferUser.do",{userId:$("#userId").val(),
										departmentId:$("#department").val(),
										postId:$("#postId").val()},
										function(msg){
											if(msg=="true"){
												window.location.href="postRecord/postRecordList.do";
											}
										});
		
	});
	
	
});
</script>
<title>用户列表</title>
</head>
 <body class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include>  
		<div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
	
			<div class="bs-example4" data-example-id="contextual-table" style="margin: 0 auto;text-align: center;" >
				<div style=" margin-left: 200px;margin-right: 200px;">
				<table class="table table-bordered font-size1">
				<input type="hidden" value="${userId}" name="userId" id="userId">
					<tr>
				  	<td>当前所在部门:</td>
					  <td>
					  		${olddepartment.departmentName }	
					  </td>
					</tr>
					<tr>
				  	<td>当前职位</td>
					 	<td>
					 	 	${post.postName }		
						</td>
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
					  					  	
					 </tr>
					<tr>
						<td><span style="color:red;">*</span>职位:</td>
					  		<td>
					  			<select id="postId" name="postId" class="selected">
					  		     	<option value="0">请选择</option>
					  			
					  			</select>
					  		</td>	
					</tr>				
					<td><input type="button" id="saveBtn" value="确定"></td>
					<td><input type="reset" value="返回" onclick="javascript:history.back(-1)"></td>
					</tr>		
				</table>
				</div>
				</div>
					   </div>
				</div>
		</div>
<%@include file="../include/foot.jsp" %> 

