<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<link href="static/date/css/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
$(function(){
	$("#saveDaily").on("click",function(){
		if($("#worktime").val()>8||$("#worktime").val()==0||$("#worktime").val()==""){
			layer.tips('请输入正确的时间', '#worktime');
			return;
		}else if($("#worksite").val()==0){
			layer.tips('请选择工作地点！', '#worksite');
			return;
		}else if($("#dailycontext").val().trim()==""){
			layer.tips('请填写工作内容！', '#dailycontext');
			
			return;
		}else{
			layer.confirm('日报一旦提交不可修改，确认提交？', {
				  btn: ['确定','取消'] //按钮
				}, function(){
				 	$.post("daily/addDailyForm.do", $("#addDailyForm").serialize(),function(data){
						if(data>0){
							layer.confirm('添加成功', {
								  btn: ['确定'] //按钮
								}, function(){
									 window.location.reload();//刷新当前页面.	
								});
						}	
				  	}); 
				},function(){
					 window.location.reload();//刷新当前页面
				});
		
		}
	});

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
				<div class="aboluo-w-700">
	<div class="aboluo-leftdiv">
		<div class="aboluo-tools">
			<div class="aboluo-calendar-select-year" ></div>
			<div class="aboluo-calendar-month">
				<a class="aboluo-month-a-perv" href="javascript:;">&lt; </a>
				<a class="aboluo-month-a-next" href="javascript:;"> &gt;</a>
			</div>
			<input type="button" class="aboluo-toToday" style="height: 30px;" value="返回今天" />
		</div>
		<div class="aboluo-rilidiv">
			<table class="aboluo-rilitable" cellspacing="0" cellpadding="0" >
				<thead class="aboluo-rilithead">
					<tr>
						<th style=" padding-left: 23px;">一</td>
						<th style=" padding-left: 23px;">二</td>
						<th style=" padding-left: 23px;">三</td>
						<th style=" padding-left: 23px;">四</td>
						<th style=" padding-left: 23px;">五</td>
						<th  style="color:red;padding-left: 23px;">六</td>
						<th style="color:red;padding-left: 23px;">日</td>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div class="aboluo-rightdiv">
		<p class="aboluo-xssj"><p>
		<p class="aboluo-currday"></p>
		 <p class="aboluo-ssjjr" style="display: none;"></p> 
		<p class="aboluo-xsmx"></p>
	</div>
</div>

<div id="context" style="display:none;">
	<form id="addDailyForm"  method="post">
			<div class=" " style="text-align: center">
			<input type="hidden" id="userid" name="userid" value="${user.userId }">
				<table class="adddailyTable " >
					  <tbody>
					  	<tr >
					  		<td style="height: 0px; width: 150px;">姓名:</td>
					  		<td><input type="text" id="userName" name="userName" value="${user.userName }" disabled="disabled" /></td>
					  		<td style="height: 0px; width: 150px;">入职时间:</td>
					  		<td><input type="text" id="workdate1" name="workDate1" value="${fn:substring(user.workDate, 0, 10)}" disabled="disabled" /></td>
					  		
					  	</tr>
					  	<tr>
					  		<td style="height: 0px; width: 150px;">性别:</td>
					  		<td>
					  		<input type="text" id="userName" name="userName"  value="<c:if test="${user.sex eq '1' }">男</c:if> 
					  		   <c:if test="${user.sex eq '2' }">女</c:if>" disabled="disabled" />
							</td>
					  		<!-- <td style="height: 0px; width: 150px;">职位:</td>
					  		<td><input type="text" /></td> -->
					  	</tr>
					  	<tr>
					  		<td style="height: 0px; width: 150px;">日报时间:</td>
					  		<td>
					  		<input type="text" id="workdate" name="workdate"  />
							</td>				  	
					  	</tr>
				         <tr>
					  		   <td style="height: 0px; width: 150px;">正常工作详情:</td>			  						  	
					  	  </tr>
					  	     <tr>
					  	    	<td style="height: 0px; width: 150px;">工作时长:</td>	
					  	    	<td><input type="number" name="worktime" id="worktime" min="0" max="8" value="8"/></td>
					  		    <td style="height: 0px; width: 150px;">工作地点:</td>						  			  						  	
					           <td><select name="worksite" id="worksite">
					            <option value="0">请选择</option>
					           <option value="1">公司办公</option>
					           <option  value="2">本地驻场</option>
					           <option  value="3">出差驻场</option>
					           </select></td>
					  	 </tr>
					  	 <tr>
					  	 <td style="height: 0px; width: 150px;">工作内容:</td>
					  	 <td colspan="3" > 	
					  	 <textarea id="dailycontext" name="dailycontext" style="width: 561px; height: 132px;  margin-top: 10px;"></textarea>
					  	 </td>
					  	 </tr>
					  	   <tr>
					  		   <td style="height: 0px; width: 150px;">加班工作详情:</td>			  						  	
					  	  </tr>
					  	     <tr>
					  	    	<td style="height: 0px; width: 150px;">工作时长:</td>	
					  	    	<td><input type="number" name="overtime" id="overtime" min="0" max="8" value="0" /></td>						  			  						  	
					  	  </tr>
					  	 <tr>
					  	 <td style="height: 0px; width: 150px;">工作内容:</td>
					  	 <td colspan="3" > 	
					  	 <textarea id="overworkcontext" name="overworkcontext" style="width: 561px; height: 132px; margin-top: 10px;"></textarea>
					  	 </td>
					  	 </tr>
					  	 <tr>
					  	 <td colspan="4">
					  	   <input type="button" id="saveDaily" name="saveDaily" class="button blue" style=" margin-top: 10px;" value="确定"/>
					  	   <input type="reset" class="button blue" style=" margin-top: 10px;"  value="重置"/>	
					  	</td>
					  	 </tr>
					  
					  	</table>					  			  						  	
					  	</tr>
					  
					  </tbody>
					</table>
				<!-- 	<div style="text-align: center">										
					  	<input type="button" id="saveUser" name="saveUser" class="button blue"  value="确定"/>
					  	<input type="reset" class="button blue"  value="重置"/>				 
					</div>
 -->
			</div>
		</form>
</div>


<!-- <script type="text/javascript" src="static/date/js/jquery-1.8.3.min.js"></script> -->
<script type="text/javascript" src="static/date/js/datouwang.js"></script>		
		</div>
<%@include file="../include/foot.jsp" %> 

