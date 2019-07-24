<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<script type="text/javascript">
function readURL(input) {  
    
    if (input.files && input.files[0]) {  
        var reader = new FileReader();  
        reader.onload = function (e) {  
            $('#displayImg').removeAttr('src');  
            $('#displayImg').attr('src', e.target.result);  
            var api = $('#displayImg').Jcrop({  
                setSelect: [ 20, 20, 200, 200 ],  
                aspectRatio: 1,  
                onSelect: updateCoords  
                }  
            );  
        }  

        reader.readAsDataURL(input.files[0]);  
    }  
      
      
}  
  
function updateCoords(c){     
    $('#x').val(c.x);  
    $('#y').val(c.y);  
    $('#w').val(c.w);  
    $('#h').val(c.h);  
};  
$(function(){
	$("#uploadBtn").on("click",function(){
		$("#uploadForm").submit();
	});		
})

  
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
			<div class="bs-example4" data-example-id="contextual-table">
			<form id="uploadForm" name="form" action="person/uploadImgtests.do" class="form-horizontal"
    				  method="post" enctype="multipart/form-data">
		    <div style="text-align: center;">
		            <div >
		           		 <div>
		               <img alt="" style="width: 115px;height: 115px;" src="<c:if test='${not empty personInfo.head}'>${personInfo.head}</c:if><c:if test='${ empty personInfo.head}'>static/images/head.png</c:if>" style="margin-left: 25px;" id="cutimg"/>
		               </div>
		               <div style="text-align: center;">
		             	   <input type="file" style="margin: 0 auto 0px 596px;" name="file" id="fcupload" onchange="readURL(this);"/>
		             <!-- 	 <input type="button" id="uploadBtn" value="上传"> -->
		            
		                </div>                 
		         <!--        <input type="hidden" id="x" name="x"/>
		                <input type="hidden" id="y" name="y"/>
		                <input type="hidden" id="w" name="w"/>
		                <input type="hidden" id="h" name="h"/> -->
		          </div>
		  </form>
		
		          <div>
		          	<table class="table" style="width:50% ;text-align: center; margin-left: 350px;" >
					  <tbody>
					  	<tr>
					    	<td style="text-align: right;">用户编号:</td>
					  		<td style="text-align: left;"><input type="text" id="userId" name="userId" value="${user.userId}" disabled="disabled" /></td>
					  		<td style="text-align: right;">用户名:</td>
					  		<td style="text-align: left;"><input type="text" id="userName" name="userName" value="${user.userName}" disabled="disabled" /></td>
					  	
					  	</tr>
					  	<tr>
					  		<td style="text-align: right;">真实姓名:</td>
					  		<td style="text-align: left;"><input type="text" id="realName" name="realName" value="${user.realName }" disabled="disabled" /></td>
					  		<td style="text-align: right;">手机号码:</td>
					  		<td style="text-align: left;"><input type="text" id="phone" name="phone" value="${personInfo.phone }" /></td>
					  	</tr>
					  	<tr>
					  		<td style="text-align: right;">毕业院校:</td>
					  		<td style="text-align: left;"><input type="text" id="school" name="school"  value="${personInfo.school}" /></td>
					  		<td style="text-align: right;">专业:</td>
					  		<td style="text-align: left;"><input type="text" id="specialty" name="specialty" value="${personInfo.specialty }"/></td>
					     </tr>
					  	<tr>	  	
					  		<td style="text-align: right;">微博:</td>
					  		<td style="text-align: left;"><input type="text" id="weibo" name="weibo"  value="${personInfo.weibo }" /></td>
					  		<td style="text-align: right;">微信:</td>
					  		<td style="text-align: left;"><input type="text" id="weixin" name="weixin"   value="${personInfo.weixin }" /></td>
					  	</tr>
					  	<tr>
						    <td style="text-align: right;">兴趣爱好:</td>
					  		<td style="text-align: left;"><input type="text" id="favourites" name="favourites"  value="${personInfo.favourites }" /></td>
					  							  	
					  		<td style="text-align: right;">企业邮箱:</td>
					  		<td style="text-align: left;"><input type="text" id="email" name="email"  value="${user.email }" /></td>
					  	</tr>
					  	<tr>

					  		<td style="text-align: right;">个人简介:</td>
					  		<td style="text-align: left;"><textarea rows="5" cols="5" style="width: 141px; height: 111px;" id="personinformation" name="personinformation" ><c:if test="${not empty personInfo.personinformation }">${personInfo.personinformation}</c:if></textarea></td>
					  			<td style="text-align: right;">技能:</td>
					  		<td style="text-align: left;"><textarea rows="5" cols="5"  style="width: 141px; height: 111px;" id="technology" name="technology"><c:if test="${not empty personInfo.technology}">${personInfo.technology }</c:if></textarea></td>		
					  	</tr>
					  </tbody>
					</table>
					</div>
					<div style="text-align: center">										
					  	 <input id="uploadBtn" type="button" value="确定">
					    <input type="reset"  value="重置"/>				 
					</div>
				</div>
		    </div>	
			</div>
		</div>
<%@include file="../include/foot.jsp" %> 

