<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp"%>
<%-- <jsp:include page="../include/head.jsp"></jsp:include> --%>
<script type="text/javascript">	
$(function(){
	 "use strict";
	 var flag=false;
	  $.ajax({
  	 	url:"department/getdepartmentList.do",
		type:"POST",		
		success:function(data){	
			var mydata=eval(data);
			var newData1;
			$.each(mydata, function(i, item) {					
			newData1=newData1+"<option value="+item.id+" style='width: 158px;' >"+item.departmentName+"</option>";			
			});
			$("#parentId").append(newData1);
		}
   });

	$('#adddepartmentButton').on('click', function(){
		 flag=false;
		$('#addDepartmentForm')[0].reset();
		
	    layer.open({
	    	title:"部门添加",
	        type: 1,
	        shift: 5,
	        offset:["20%" , "35%"],
	        area: ['380px', '430px'],
	        shadeClose: false, //点击遮罩关闭
	        content: $('#addDepartmetDiv')
	    });
	});
		
	$('#updatedepartmentButton').on('click', function(){
		flag=true;
		$('#addDepartmentForm')[0].reset();
		var checklength=$("input[name='check']:checked").length;
		if(checklength!=1)
		{
			layer.open({
			    type: 1,
			    title: '提示',
			    closeBtn:1, //不显示关闭按钮
			    shade: [0],
			    area: ['300px', '205px'],
			    offset: 'rb', //右下角弹出
			    time: 4000, //2秒后自动关闭
			    shift: 2,
			    content: ' 您未选中指定的部门或者选中多个'//iframe的url，no代表不显示滚动条
			});		
		}else{
			$.ajax({
				type: "POST",
				url: "department/getDepartmentById.do",
				data:{"departmentId":$("input[name='check']:checked").attr("value")},
				success:function(data){
					var mydata=eval(data);
					$.each(mydata,function(i,item){
						$("#id").val(item.id);
						$("#departmentName").val(item.departmentName);
						$("#departmentId").val(item.departmentId);
						$("#departmentType").val(item.departmentType);
						var par=	item.parentId;
					    $("#parentId option").each(function () {
				          /*    var txt = $(this).text(); //获取单个text */
				             var val = $(this).val(); //获取单个value			        
					   		 if(val==par){
				           	 	$(this).attr("selected", true);
				           		return;    	 
				            }
				         });
						$("#description").val(item.description);
					});
					
					  layer.open({
				    	title:"部门修改",
				        type: 1,
				        shift: 5,
				        offset:["20%" , "35%"],
				        area: ['380px', '430px'],
				        shadeClose: false, //点击遮罩关闭
				        content: $('#addDepartmetDiv')
				    })
				}
			}); 
		}
	});
	$('#deleteDepartmentButton').on('click', function(){
		var checklength=$("input[name='check']:checked").length;
		if(checklength<1)
		{
			layer.open({
			    type: 1,
			    title: '提示',
			    closeBtn:1, //不显示关闭按钮
			    shade: [0],
			    area: ['300px', '205px'],
			    offset: 'rb', //右下角弹出
			    time: 4000, //2秒后自动关闭
			    shift: 2,
			    content: '您未选中部门!'
			});		
		}else{
			var IdArray='';
			var arrChk=$("input[name='check']:checked");
		    $(arrChk).each(function(){
		  	  	IdArray+= this.value+",";                       
		    }); 
			$.ajax({
				type: "POST",
				url: "department/deleteDepartment.do",
				data:{"IdArray":IdArray},
				success:function(data){
					if(data>0){
						layer.confirm('删除成功', {
						    btn: ['确定'] //按钮
						},function(){
							 window.location.reload();
						})
					}else{
						layer.confirm('该部门存在上级部门或存在下级部门，不可删除!', {
						    btn: ['确定'] //按钮
						})
					}
				}
			});
		}
	});
	
	$("#addPostButton").on("click",function(){
		var checklength=$("input[name='check']:checked").length;
		if(checklength!=1)
		{
			layer.open({
			    type: 1,
			    title: '提示',
			    closeBtn:1, //不显示关闭按钮
			    shade: [0],
			    area: ['300px', '205px'],
			    offset: 'rb', //右下角弹出
			    time: 4000, //2秒后自动关闭
			    shift: 2,
			    content: ' 您未选中指定的部门或者选中多个'//iframe的url，no代表不显示滚动条
			});	
		}else{
		  layer.open({
	    	title:"职位添加",
	        type: 1,
	        shift: 5,
	        offset:["20%" , "35%"],
	        area: ['380px', '330px'],
	        shadeClose: false, //点击遮罩关闭
	        content: $('#addPostDiv')
		  })
		  }
	})
	
	$("#savePost").on("click",function(){
		if(isNaN($("#basic").val())){
			layer.tips('请输入正确的基本薪资', '#basic');
			return false;
		}else if($("#postName").val().trim()==""||$("#postName").val()==null){
			layer.tips('部门名称不能为空', '#postName');
			return false;
		}else{
		$.post("post/existPost.do",{postId:$("#postId").val(),postName:$("#postName").val()},function(msg){
			if(msg==1){
				layer.tips('部门编号已存在', '#postId');
			}else if(msg==2){
				layer.tips('部门名称已存在', '#postName');
			}else{
				$.post("post/addPost.do",{postId:$("#postId").val(),postName:$("#postName").val(),
					departmentId:$("input[name='check']:checked").val()
					,description:$("#postdescription").val(),basic:$("#basic").val()},function(data){
						if(data=="1"){
							layer.confirm('保存成功', {
							    btn: ['确定'] //按钮
							},function(){	
								$("#addPostForm")[0].reset();
								window.location.reload();
							})
						}
					});
			}
		});	
		}
	});
	
    function validate(){
  		var  departmentNameLength = $("#departmentName").val().trim().length;
			if (departmentNameLength <= 0 || departmentNameLength > 50) {
				layer.tips('部门名称长度在50个字之内,且不能为空!', $("#departmentName"), {
				    tips: [1, '#3595CC'],
				    time: 4000
				});
				 $("#departmentName").focus();
				return false;
			}
			var departmentCodeLength = $("#departmentId").val().trim().length;
			if (departmentCodeLength <= 0 || departmentNameLength > 20) {
				layer.tips('部门编号长度在20个字之内,且不能为空!', $("#departmentId"), {
				    tips: [1, '#3595CC'],
				    time: 4000
				});
				 $("#departmentId").focus();
				return false;
			}
			var departmentTypeLength = $("#departmentType").val().trim().length;
			if (departmentTypeLength <= 0 || departmentTypeLength > 5) {
				layer.tips('部门类型长度在5个字之内,且不能为空!', $("#departmentType"), {
				    tips: [1, '#3595CC'],
				    time: 4000
				});
				 $("#departmentType").focus();
				return false;
			}
			var descriptionLength = $("#description").val().trim().length;
			if (descriptionLength <= 0 || descriptionLength > 50) {
				layer.tips('部门描述字符长度在50个字之内!', $("#description"), {
				    tips: [1, '#3595CC'],
				    time: 4000
				});
				 $("#description").focus();
				return false;
			}
			return true;
     }
	function existIdAndName() {
		var flag = false;
		$.ajax({
			type: "POST",
			url: "department/existAddDepartment.do",
			data:{"departmentName":$("#departmentName").val(),
				"departmentId":$("#departmentId").val()},
			success: function(msg){
				if(msg == 2) {
					layer.tips('部门名称已经存在!', $("#departmentName"), {
					    tips: [1, '#3595CC'],
					    time: 4000
					});
					 $("#departmentName").focus();
	 	         	 return false;
	           	 }else if(msg==1){
	           		layer.tips('部门编号已经存在!', $("#departmentId"), {
					    tips: [1, '#3595CC'],
					    time: 4000
					});
	           		 $("#departmentId").focus();
	 	         	 return false;
	             }else{
					flag = true;
	            }
			},
			async: false
		  });
		  return flag;
		}
     $("#page").on("pageClicked", function (event, data) { 
         $.ajax({
        	url:"department/departmentList.do",
			type:"get",
			data:{"pageVo.currentPage": data.pageIndex+1},
			success:function(data){				
				 $("#body").html(data);
			}
         });
    }).on('jumpClicked', function (event, data) {
    	   $.ajax({
       	 	url:"department/departmentList.do",
			type:"get",
			data:{"pageVo.currentPage": data.pageIndex+1},
			success:function(data){				
				 $("#body").html(data);
			}
        });
    }).on('pageSizeChanged', function (event, data) {
    	   $.ajax({
       	 	url:"department/departmentList.do",
			type:"get",
			data:{"pageVo.currentPage": data.pageIndex+1,
				  "pageVo.pageSize": data.pageSize},
			success:function(data){				
				 $("#body").html(data);
			}
        });
    });
	 $('#save').on('click', function(){
			var flag1=false;
			alert(flag);
			var url="department/addDepartment.do";
			if(flag==true){
				url="department/updateDepartment.do"
				flag1=true;
			}else{
				url="department/addDepartment.do";
				flag1=existIdAndName();
			}
		if(validate()&&flag1){	
			$.ajax({
				url:url,
				type:"post",
				data:{"id":$("#id").val(),
					"departmentName":$("#departmentName").val(),
					"departmentId":$("#departmentId").val(),
					"departmentType":$("#departmentType").val(),
					"parentId":$("#parentId").val(),
					"description":$("#description").val()},
				success:function(data){
					if(data>0){
						layer.confirm('保存成功', {
						    btn: ['确定'] //按钮
						},function(){
							 window.location.reload();
						})
						
					}
				}
			});
		}	
	});		
	 
});
</script>
<title>部门列表</title>
</head>
<body id="body" class="sticky-header left-side-collapsed bg">
	<jsp:include page="../list.jsp"></jsp:include>
	<div class="main-content">
		<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
		</div>


		<div class="bs-example4" data-example-id="contextual-table">
			<button id="adddepartmentButton" class="button blue">添加部门</button>
			<button id="updatedepartmentButton" class="button blue">修改部门</button>
			<button id="deleteDepartmentButton" class="button blue">删除部门</button>
			<button id="addPostButton" class="button blue">职位添加</button>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>选择</th>
						<th>部门编号</th>
						<th>部门名称</th>
						<th>部门类型</th>
						<th>上级部门</th>
						<th>部门描述</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty departmentTwo.pageVo}">
								<tr>
									<td class="text-center" colspan="9">没有找到数据</td>
								</tr>
					</c:if>			
				<c:if test="${not empty departmentTwo.pageVo}">
				<c:forEach var="page" items="${departmentTwo.pageVo.voList}">
						<tr class="info">
								<td>
								<input type="checkbox" value="${page.id}" id="check"
									name="check" />
								</td>
								<th scope="row">${page.departmentId}</th>
							<td><a href="post/postList.do?departmentId=${page.id}">${page.departmentName}</a></td>
							<td>${page.departmentType}</td>
							<td>${page.parentDepartmentName}</td>
							<td>${page.description}</td>
						</tr>
				</c:forEach>				
				</c:if>
				</tbody>
			</table>
					<div class="marge">
			     		 <div id="page" class="m-pagination"></div>
					</div>
			
				<%@include file="../include/page.jsp"%>
		</div>
		<div id="addDepartmetDiv" class="addDepartment" style="display:none;">
			<form id="addDepartmentForm" action="department/addDepartment.do"
				method="POST" >
				<input type="hidden" id="id" name="id"> 
				<div class="box-body">
					<label class="control-label"> <span style="color: red;">*</span>部门名称：
					</label> <input id="departmentName" type="text" maxlength="50"
						name="departmentName">
				</div>
				<div class="box-body">
					<label class="control-label"><span style="color: red;">*</span>
						部门编号： </label> <input id="departmentId" type="text" maxlength="50"
						name="departmentId">
				</div>
				<div class="box-body">
					<label class="control-label"><span style="color: red;">*</span>
						部门类型： </label> <input id="departmentType" type="text" maxlength="5"
						name="departmentType">
				</div>
				<div class="box-body">
					<label class="control-label1"><span style="color: red;">*</span>
						上级部门：</label>
						 <select id="parentId" name="parentId" style="width: 158px;">
						<option value="0" selected="selected">无</option>
						<!-- 	<option value="23">风控中心</option> -->
					</select>
				</div>
				<div class="box-body">
					<label class="control-label"> 部门说明： </label>
					<textarea id="description" name="description" rows="" cols=""
						style="width: 200px; height: 96px; resize: none"></textarea>
				</div>
				<div class="box-body">
					<input id="save" class="button blue" type="button" value="保存">
				</div>
			</form>
		</div>
		
		<div id="addPostDiv" class="addDepartment" style="display:none;">
			<form id="addPostForm" action="post/addPost.do"
				method="POST" >
				
				<div class="box-body">
					<label class="control-label"><span style="color: red;">*</span>
						职位编号： </label> <input id="postId" type="text" maxlength="5"
						name="postId">
				</div>
				<div class="box-body">
					<label class="control-label"><span style="color: red;">*</span>
						职位名称： </label> <input id="postName" type="text" maxlength="5"
						name="postName">
				</div>
				<div class="box-body">
					<label class="control-label"><span style="color: red;">*</span>
						基本薪资： </label> <input id="basic" type="text" maxlength="5"
						name="basic">
				</div>
				<div class="box-body">
					<label class="control-label"> 职位描述： </label>
					<textarea id="postdescription" name="postdescription" rows="" cols=""
						style="width: 200px; height: 96px; resize: none"></textarea>
				</div>
				<div class="box-body">
					<input id="savePost" class="button blue" type="button" value="保存">
				</div>
			</form>
		</div>
	</div>
	<div>
		
	</div>
	
	<%@include file="../include/foot.jsp"%>