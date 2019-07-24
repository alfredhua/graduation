<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp"%>
<script type="application/x-javascript"> 
	$(function(){
		$("#returnList").on("click",function(){
			$.post("user/userList.do");
		});
		 $("#checkedAll").on("click",function () {//全选         	
				$("input:checkbox").prop('checked','checked');
          });  
  
         $("#checkedRev").on("click",function () {
        		$("input:checkbox").each(function(){
    			    if($(this).val() != 1){
    			   	 	$(this).removeAttr('checked');  
    			    }
    			 });
         });  
         $("#save").on("click",function () { 	     	 
		 	
		      var adIds = "";  
	          $("input:checked").each(function(i){     
	               adIds +=$(this).val()+",";  
	          });  
	         $.post("role/saveRole.do", { adIds:adIds, rolename:$("#roleName").val(),
	        		 remark:$("#remark").val(),id:$("#rolesId").val()},function(){
	        		    window.location.href="role/rolesList.do";       		    		 
	           });
       });  
	})



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
	
			<div class="bs-example4" data-example-id="contextual-table" style="font-size: 18px">
				<form action="" method="POST">
				<input type="hidden" value="${role.id}" name="rolesId" id="rolesId">
					<div class="box-body">
					<div>				
					    <label class="control-label" style="margin-left: -400px">
					    <span style="color:red;">*</span>角色名称：</label>
					     <input id="roleName" name="roleName" type="text" value="${role.rolename }" class="roleName validate[required]" data-errormessage-value-missing="* 请输入角色名称" maxlength="25"  />
					</div><br/>
					<div>
																	       		
					    <label class="control-label" style="margin-left: -400px">
					    <span style="color:red;">*</span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
					     <input id="remark" name="remark" value="${role.remark }" type="text" class="remark validate[required,maxSize[50]]" data-errormessage-value-missing="* 请输入备注"  />
					</div><br/>
					<div>					 
					    	<label class="control-label" style="margin-left: -500px">
				    			<span style="color:red;">*</span>权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：
				    		</label>
							<input type="button" id="checkedAll" class="a_demo_one" value="全选"/>
							<input type="button" id="checkedRev" class="a_demo_one" value="全否">				
					</div>
				</div>
				<div id="check" style="margin-left: 307px;margin-top: 20px;">
						
					   <c:forEach items="${menus}" var="menu" >
					   <div style="margin-top: 10px;">
						<label class="control-label"  >
								${menu.name}:
					   	</label>				
					 		<c:if test="${empty menu.childrenMenu}">					 	
					   		  <input type="checkbox"  value="${menu.id}"  name="url" 
					   		  <c:forEach items="${resource}" var="resource" varStatus="status">
										<c:if test="${resource.url eq menu.url}">
											checked="checked" 
										</c:if>
									</c:forEach>
					   		    <c:if test="${menu.id eq '1'}">checked disabled="disabled"</c:if>  />	模块	<br>
					 	  	</c:if>	
						   	<c:if test="${!empty menu.childrenMenu}">							   	 
							<c:forEach items="${menu.childrenMenu}" var="child">						
							      <input type="checkbox"  value="${child.id}" name="id"   
							      <c:forEach items="${resource}" var="resource" varStatus="status">
										<c:if test="${resource.url eq child.url}">
											checked="checked" 
										</c:if>
									</c:forEach>/>	${child.check}	
								 <label class="control-label">${child.name}</label>
							</c:forEach>
							<br>			   	
					  	 	</c:if>		
					  	 </div>	
						</c:forEach>				
				</div>
				<div style="margin-left: 307px">
					<input id="save" class="button blue" type="button" value="保存">
					<input id="returnList" class="button blue" onclick="javascript:history.back(-1);" type="button" value="返回">		
					</div>
				</form>			
			</div>
			
		</div>
<%@include file="../include/foot.jsp" %> 

