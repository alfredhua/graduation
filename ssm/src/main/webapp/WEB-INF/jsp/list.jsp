<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="include/head.jsp"%>
    <!-- left side start-->
		<div class="left-side sticky-left-side">

			<!--logo and iconic logo start-->
			<div class="logo">
				<h1><a href="user/index.do">工作<span>面板</span></a></h1>
			</div>
			<div class="logo-icon text-center">
				<a href="user/index.do"><i class="lnr lnr-home"></i> </a>
			</div>
		
			<div class="left-side-inner">
					<ul class="nav nav-pills nav-stacked custom-nav">
						
						<c:if test="${not empty menus}">
					<c:forEach items="${menus}" var="data">
					   <li class="menu-list">
								<a href="${data.url}"><i class="lnr lnr-cog"></i>
								<span>${data.name}</span></a>
								<c:if test="${not empty data.childrenMenu}">
								<ul class="sub-menu-list">
								<c:forEach items="${data.childrenMenu}" var="child">
									<li><a href="${child.url}">${child.name}</a> </li>
								</c:forEach>
								</ul>
								</c:if>
						</li>
						<!-- <li class="menu-list">
								<a href=""><i class="lnr lnr-cog"></i>
								<span>员工管理</span></a>
								<ul class="sub-menu-list">
									<li><a href="user/userList.do">员工查询</a> </li>
									<li><a href="user/addUserSend.do">添加员工</a></li>
								</ul>
						</li>
						<li class="menu-list">
							<a href=""><i class="lnr lnr-spell-check"></i> 
							<span>部门管理</span></a>
							<ul class="sub-menu-list">
									<li><a href="department/departmentList.do">部门列表</a> </li>								
							</ul>
						</li>
						<li class="menu-list">
							<a href=""><i class="lnr lnr-spell-check"></i> 
							<span>角色管理</span></a>
							<ul class="sub-menu-list">
									<li><a href="role/rolesList.do">角色列表</a> </li>
									<li><a href="widgets.html">角色添加</a></li>
							</ul>
						</li> -->
						</c:forEach>
						</c:if>	
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>