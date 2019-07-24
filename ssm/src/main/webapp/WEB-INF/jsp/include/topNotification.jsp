<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
		<div class="menu-right">
				<div class="user-panel-top">  	
					<div class="profile_details_left">
						<ul class="nofitications-dropdown">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">${count}</span></a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>${count}条未读消息</h3>
												</div>
											</li>
											<div class="dropdown-backdrop"></div>
											<c:forEach items="${mess }" var="data">
											<li>											   
											   <div class="notification_desc">
												<p><a href="message/watchMessage.do?id=${data.id }">${fn:substring(data.context, 0, 10)}...  </a><fmt:formatDate value="${data.sendDate}" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
												<!-- <p><span></span></p> -->
												</div>
											   <div class="clearfix"></div>	
											 </li>	
											 </c:forEach>									
											<li>
												<div class="notification_bottom">
													<a href="message/messageList.do">查看所有信息</a>
												</div> 
											</li>
										</ul>
							</li>										   		
							<div class="clearfix"></div>	
						</ul>
					</div>
					<div class="profile_details">		
						<ul class="profile_details_a">
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										<span style="background:url(${personInfo.head }) no-repeat center"> </span> 
										 <div class="user-name">
											<!-- <p>Michael<span>Administrator</span></p> -->
											<p>${user.userName }</p>
										 </div>
										 <i class="lnr lnr-chevron-down"></i>
										 <i class="lnr lnr-chevron-up"></i>
										<div class="clearfix" style="width: 150px;"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="person/updatePersonInfoSend.do"><i class="fa fa-cog"></i> 个人信息</a> </li> 
									<li> <a href="user/updatePasswordSend.do"><i class="fa fa-user"></i>修改密码</a> </li> 
									<li> <a href="admin/logout.do"><i class="fa fa-sign-out"></i> 退出</a> </li>
								</ul>
							</li>
							<div class="clearfix"> </div>
						</ul>
					</div>		
         	
					<div class="clearfix"></div>
				</div>
			  </div>
<script type="text/javascript">
	$(function(){
		$(".fa-envelope").on("click",function(){
			$(".nofitications-dropdown > li").addClass("open");
		});
		$(".lnr-chevron-down").on("click",function(){
			$(".profile_details_a > li").addClass("open");
		});
		
	});
</script>