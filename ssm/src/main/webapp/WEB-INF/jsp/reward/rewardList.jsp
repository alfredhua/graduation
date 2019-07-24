<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>

<title>奖惩记录</title>
</head>
 <body id="body" class="sticky-header left-side-collapsed bg" >
<jsp:include page="../list.jsp"></jsp:include> 
		   <div  class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="../include/topNotification.jsp"></jsp:include>
			</div>
		<div class="bs-example4" data-example-id="contextual-table">
			<div style="height: 40px">
				<div style="float: left; height: 40px">
					<form action="money/getRewardList.do" method="post" id="query"
						name="query">
						<input type="hidden" name="ptype" id="ptype"
							value="0" /> 
						<input type="hidden" name="userid" id="userid"
							value="${prizeAndpublishBean.userid}" /> 
						<input type="hidden" name="currentPage" id="currentPage"
							value="${pageVo.currentPage}" /> <input type="hidden"
							name="pageSize" id="pageSize" value="${pageVo.pageSize}">
						<span>用户名:</span><input type="text" name="userName"
							value="${prizeAndpublishBean.userName}" class="mytxt"> <span>真实姓名:</span><input
							type="text" name="realName" value="${prizeAndpublishBean.realName}" class="mytxt">
						<button>查询</button>
				</div>
				</form>
			</div>
			<div class="grid_3 grid_5">
				<h3>奖励记录</h3>
				<div class="but_list">
					<div class="bs-example bs-example-tabs" role="tabpanel"
						data-example-id="togglable-tabs">
						<ul id="myTab" class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="money/getRewardList.do?ptype=1&userid=${prizeAndpublishBean.userid}"
								id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
								aria-expanded="true">奖励</a></li>
							<li ><a href="money/getPublish.do?ptype=0&userid=${prizeAndpublishBean.userid}"
								>惩罚</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade in active" id="home"
								aria-labelledby="home-tab">
								<div style="margin-top: 25px;">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>用户名</th>
												<th>真实姓名</th>
												<th>奖励名称</th>
												<th>奖励原因</th>
												<th>奖励时间</th>
												<th>描述</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${empty pageVo.voList}">
												<tr class="info">
													<th colspan="6" style="text-align: center;">未查到数据</th>
												</tr>
											</c:if>
											<c:if test="${not empty pageVo.voList}">
												<c:forEach items="${pageVo.voList}" var="data">
													<tr class="info">
														<td>${data.userName}</td>
														<td>${data.realName}</td>
														<td>${data.pName}</td>
														<td>${data.pReason}</td>
														<td>
														<fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
														</td>
														<td>${data.pDescription}</td>
													</tr>
												</c:forEach>
											</c:if>
										</tbody>
									</table>
								</div>
								<%@include file="../include/page2.jsp"%>
							</div>
						</div>
			
					</div>
				</div>
			</div>
		</div>

		<%-- <div style="margin-top: 25px;">
						<table class="table table-bordered">
						  <thead>
							<tr>
							  <th>用户名</th>
							  <th>真实姓名</th>
							  <th>奖励名称</th>							  
							   <th>奖励原因</th>							   
							   <th>奖励时间</th>
							   <th>描述</th>
							</tr>
						  </thead>
						  <tbody>
						  <c:if test="${empty pageVo.voList}">
						  	<tr class="info">							  
							  <th colspan="10" style="text-align: center;">未查到数据</th>
							</tr>
						  </c:if>
						   <c:if test="${not empty pageVo.voList}">
						  <c:forEach items="${pageVo.voList}" var="data">
							<tr class="info">
							  <td>${data.userName}</td>
							  <td>
							  <${data.realName}</td>
							  <td>${data.pName}</td>							
							    <td>${data.pReason}</td>
				       		  <td>${data.createTime}</td>
				       		  <td>${data.pDescription}</td>					
							</tr>
							</c:forEach>							
						</c:if>
						  </tbody>
						</table>
				   </div>
					   <%@include file="../include/page2.jsp"%>
				</div>	 --%>
		</div> 
 <%@include file="../include/foot.jsp" %> 

