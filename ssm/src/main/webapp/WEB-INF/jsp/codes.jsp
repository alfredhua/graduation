<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<jsp:include page="include/head.jsp"></jsp:include>
<title>后台管理</title>
</head>

  
 <body class="sticky-header left-side-collapsed"  onload="initMap()">
    <section>
    <!-- left side start-->
		<div class="left-side sticky-left-side">

			<!--logo and iconic logo start-->
			<div class="logo">
				<h1><a href="index.html">Easy <span>Admin</span></a></h1>
			</div>
			<div class="logo-icon text-center">
				<a href="index.html"><i class="lnr lnr-home"></i> </a>
			</div>

			<!--logo and iconic logo end-->
			<div class="left-side-inner">

				<!--sidebar nav start-->
					<ul class="nav nav-pills nav-stacked custom-nav">
						<li><a href="index.html"><i class="lnr lnr-power-switch"></i><span>Dashboard</span></a></li>
						<li class="menu-list">
							<a href="#"><i class="lnr lnr-cog"></i>
								<span>Components</span></a>
								<ul class="sub-menu-list">
									<li><a href="grids.html">Grids</a> </li>
									<li><a href="widgets.html">Widgets</a></li>
								</ul>
						</li>
						<li><a href="forms.html"><i class="lnr lnr-spell-check"></i> <span>Forms</span></a></li>
						<li><a href="tables.html"><i class="lnr lnr-menu"></i> <span>Tables</span></a></li>              
						<li class="menu-list"><a href="#"><i class="lnr lnr-envelope"></i> <span>MailBox</span></a>
							<ul class="sub-menu-list">
								<li><a href="inbox.html">Inbox</a> </li>
								<li><a href="compose-mail.html">Compose Mail</a></li>
							</ul>
						</li>  
						<li class="menu-list"><a href="#"><i class="lnr lnr-indent-increase"></i> <span>Menu Levels</span></a>  
							<ul class="sub-menu-list">
								<li><a href="charts.html">Basic Charts</a> </li>
							</ul>
						</li>
						<li class="active"><a href="codes.html"><i class="lnr lnr-pencil"></i> <span>Typography</span></a></li>
						<li><a href="media.html"><i class="lnr lnr-select"></i> <span>Media Css</span></a></li>
						<li class="menu-list"><a href="#"><i class="lnr lnr-book"></i>  <span>Pages</span></a> 
							<ul class="sub-menu-list">
								<li><a href="sign-in.html">Sign In</a> </li>
								<li><a href="sign-up.html">Sign Up</a></li>
								<li><a href="blank_page.html">Blank Page</a></li>
							</ul>
						</li>
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>
    <!-- left side end-->
    
    <!-- main content start-->
		<div class="main-content">
			<!-- header-starts -->
			<div class="header-section">
			 
			<!--toggle button start-->
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<!--toggle button end-->

			<!--notification menu start -->
			<div class="menu-right">
				<div class="user-panel-top">  	
					<div class="profile_details_left">
						<ul class="nofitications-dropdown">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
									
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>You have 3 new messages</h3>
												</div>
											</li>
											<li><a href="#">
											   <div class="user_img"><img src="images/1.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor sit amet</p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											 </a></li>
											 <li class="odd"><a href="#">
												<div class="user_img"><img src="images/1.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor sit amet </p>
												<p><span>1 hour ago</span></p>
												</div>
											  <div class="clearfix"></div>	
											 </a></li>
											<li><a href="#">
											   <div class="user_img"><img src="images/1.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor sit amet </p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											</a></li>
											<li>
												<div class="notification_bottom">
													<a href="#">See all messages</a>
												</div> 
											</li>
										</ul>
							</li>
							<li class="login_box" id="loginContainer">
									<div class="search-box">
										<div id="sb-search" class="sb-search">
											<form>
												<input class="sb-search-input" placeholder="Enter your search term..." type="search" id="search">
												<input class="sb-search-submit" type="submit" value="">
												<span class="sb-icon-search"> </span>
											</form>
										</div>
									</div>
										<!-- search-scripts -->
										<script src="js/classie.js"></script>
										<script src="js/uisearch.js"></script>
											<script>
												new UISearch( document.getElementById( 'sb-search' ) );
											</script>
										<!-- //search-scripts -->
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 3 new notification</h3>
											</div>
										</li>
										<li><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet</p>
											<p><span>1 hour ago</span></p>
											</div>
										  <div class="clearfix"></div>	
										 </a></li>
										 <li class="odd"><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet </p>
											<p><span>1 hour ago</span></p>
											</div>
										   <div class="clearfix"></div>	
										 </a></li>
										 <li><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet </p>
											<p><span>1 hour ago</span></p>
											</div>
										   <div class="clearfix"></div>	
										 </a></li>
										 <li>
											<div class="notification_bottom">
												<a href="#">See all notification</a>
											</div> 
										</li>
									</ul>
							</li>	
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tasks"></i><span class="badge blue1">22</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 8 pending task</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="task-info">
												<span class="task-desc">Database update</span><span class="percentage">40%</span>
												<div class="clearfix"></div>	
											   </div>
												<div class="progress progress-striped active">
												 <div class="bar yellow" style="width:40%;"></div>
											</div>
										</a></li>
										<li><a href="#">
											<div class="task-info">
												<span class="task-desc">Dashboard done</span><span class="percentage">90%</span>
											   <div class="clearfix"></div>	
											</div>
										   
											<div class="progress progress-striped active">
												 <div class="bar green" style="width:90%;"></div>
											</div>
										</a></li>
										<li><a href="#">
											<div class="task-info">
												<span class="task-desc">Mobile App</span><span class="percentage">33%</span>
												<div class="clearfix"></div>	
											</div>
										   <div class="progress progress-striped active">
												 <div class="bar red" style="width: 33%;"></div>
											</div>
										</a></li>
										<li><a href="#">
											<div class="task-info">
												<span class="task-desc">Issues fixed</span><span class="percentage">80%</span>
											   <div class="clearfix"></div>	
											</div>
											<div class="progress progress-striped active">
												 <div class="bar  blue" style="width: 80%;"></div>
											</div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all pending task</a>
											</div> 
										</li>
									</ul>
							</li>		   							   		
							<div class="clearfix"></div>	
						</ul>
					</div>
					<div class="profile_details">		
						<ul>
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										<span style="background:url(images/1.jpg) no-repeat center"> </span> 
										 <div class="user-name">
											<p>Michael<span>Administrator</span></p>
										 </div>
										 <i class="lnr lnr-chevron-down"></i>
										 <i class="lnr lnr-chevron-up"></i>
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li> 
									<li> <a href="#"><i class="fa fa-user"></i>Profile</a> </li> 
									<li> <a href="sign-up.html"><i class="fa fa-sign-out"></i> Logout</a> </li>
								</ul>
							</li>
							<div class="clearfix"> </div>
						</ul>
					</div>		
					<div class="social_icons">
						<div class="col-md-4 social_icons-left">
							<a href="#" class="yui"><i class="fa fa-facebook i1"></i><span>300<sup>+</sup> Likes</span></a>
						</div>
						<div class="col-md-4 social_icons-left pinterest">
							<a href="#"><i class="fa fa-google-plus i1"></i><span>500<sup>+</sup> Shares</span></a>
						</div>
						<div class="col-md-4 social_icons-left twi">
							<a href="#"><i class="fa fa-twitter i1"></i><span>500<sup>+</sup> Tweets</span></a>
						</div>
						<div class="clearfix"> </div>
					</div>		             	
					<div class="clearfix"></div>
				</div>
			</div>
			<!--notification menu end -->
			</div>
	<!-- //header-ends -->
			<div id="page-wrapper">
				<div class="graphs">
					<h3 class="blank1">Short Codes</h3>
					<div class="grid_3 grid_4">
					  <h3>Headings</h3>
					  <div class="bs-example">
						<table class="table">
						  <tbody>
							<tr>
							  <td><h1 id="h1">h1. Bootstrap heading<a class="anchorjs-link" href="#h1.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h1></td>
							  <td class="type-info">Semibold 36px</td>
							</tr>
							<tr>
							  <td><h2 id="h2">h2. Bootstrap heading<a class="anchorjs-link" href="#h2.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h2></td>
							  <td class="type-info">Semibold 30px</td>
							</tr>
							<tr>
							  <td><h3 id="h3">h3. Bootstrap heading<a class="anchorjs-link" href="#h3.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h3></td>
							  <td class="type-info">Semibold 24px</td>
							</tr>
							<tr>
							  <td><h4 id="h4">h4. Bootstrap heading<a class="anchorjs-link" href="#h4.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h4></td>
							  <td class="type-info">Semibold 18px</td>
							</tr>
							<tr>
							  <td><h5 id="h5.-bootstrap-heading">h5. Bootstrap heading<a class="anchorjs-link" href="#h5.-bootstrap-heading"><span class="anchorjs-icon"></span></a></h5></td>
							  <td class="type-info">Semibold 14px</td>
							</tr>
							<tr>
							  <td><h6>h6. Bootstrap heading</h6></td>
							  <td class="type-info">Semibold 12px</td>
							</tr>
						  </tbody>
						</table>
						</div>
					  </div>	
					  <div class="grid_3 grid_5">
						<h3>Buttons</h3>
						 <div class="but_list">
						  <p>
							<button type="button" class="btn btn_5 btn-lg btn-default">Default</button>
							<button type="button" class="btn btn_5 btn-lg btn-primary">Primary</button>
							<button type="button" class="btn btn_5 btn-lg btn-success warning_1">Success</button>
							<button type="button" class="btn btn_5 btn-lg btn-info">Info</button>
							<button type="button" class="btn btn_5 btn-lg btn-warning warning_11">Warning</button>
							<button type="button" class="btn btn_5 btn-lg btn-danger">Danger</button>
							<button type="button" class="btn btn_5 btn-lg btn-link">Link</button>
						  </p>
						  <p>
							<button type="button" class="btn btn-default">Default</button>
							<button type="button" class="btn btn-primary">Primary</button>
							<button type="button" class="btn btn-success warning_2">Success</button>
							<button type="button" class="btn btn-info">Info</button>
							<button type="button" class="btn btn-warning warning_22">Warning</button>
							<button type="button" class="btn btn-danger">Danger</button>
							<button type="button" class="btn btn-link">Link</button>
						  </p>
						  <p>
							<button type="button" class="btn btn-sm btn-default">Default</button>
							<button type="button" class="btn btn-sm btn-primary">Primary</button>
							<button type="button" class="btn btn-sm btn-success warning_3">Success</button>
							<button type="button" class="btn btn-sm btn-info">Info</button>
							<button type="button" class="btn btn-sm btn-warning warning_33">Warning</button>
							<button type="button" class="btn btn-sm btn-danger">Danger</button>
							<button type="button" class="btn btn-sm btn-link">Link</button>
						  </p>
						  <p>
							<button type="button" class="btn btn-xs btn-default">Default</button>
							<button type="button" class="btn btn-xs btn-primary">Primary</button>
							<button type="button" class="btn btn-xs btn-success warning_4">Success</button>
							<button type="button" class="btn btn-xs btn-info">Info</button>
							<button type="button" class="btn btn-xs btn-warning warning_44">Warning</button>
							<button type="button" class="btn btn-xs btn-danger">Danger</button>
							<button type="button" class="btn btn-xs btn-link">Link</button>
						  </p>
						</div>
					  </div>
					  <div class="grid_3 grid_5">
						<h3>Labels</h3>
						 <div class="but_list">
						  <h1>
							<span class="label btn_6 label-default">Default</span>
							<span class="label btn_6 label-primary">Primary</span>
							<span class="label btn_6 label-success">Success</span>
							<span class="label btn_6 label-info">Info</span>
							<span class="label btn_6 label-warning">Warning</span>
							<span class="label btn_6 label-danger">Danger</span>
						  </h1>
						  <h2>
							<span class="label btn_7 label-default">Default</span>
							<span class="label btn_7 label-primary">Primary</span>
							<span class="label btn_7 label-success">Success</span>
							<span class="label btn_7 label-info">Info</span>
							<span class="label btn_7 label-warning">Warning</span>
							<span class="label btn_7 label-danger">Danger</span>
						  </h2>
						  <h3>
							<span class="label label-default">Default</span>
							<span class="label label-primary">Primary</span>
							<span class="label label-success">Success</span>
							<span class="label label-info">Info</span>
							<span class="label label-warning">Warning</span>
							<span class="label label-danger">Danger</span>
						  </h3>
						  <h4>
							<span class="label label-default">Default</span>
							<span class="label label-primary">Primary</span>
							<span class="label label-success">Success</span>
							<span class="label label-info">Info</span>
							<span class="label label-warning">Warning</span>
							<span class="label label-danger">Danger</span>
						  </h4>
						  <h5>
							<span class="label label-default">Default</span>
							<span class="label label-primary">Primary</span>
							<span class="label label-success">Success</span>
							<span class="label label-info">Info</span>
							<span class="label label-warning">Warning</span>
							<span class="label label-danger">Danger</span>
						  </h5>
						  <h6>
							<span class="label label-default">Default</span>
							<span class="label label-primary">Primary</span>
							<span class="label label-success">Success</span>
							<span class="label label-info">Info</span>
							<span class="label label-warning">Warning</span>
							<span class="label label-danger">Danger</span>
						  </h6>
						 </div>
					   </div>
					   <div class="grid_3 grid_5">
						 <h3>Progress Bars</h3>
							 <div class="tab-content">
								  <div class="tab-pane active" id="domprogress">
									  <div class="progress">    
										<div class="progress-bar progress-bar-primary" style="width: 20%"></div>
									  </div>
									  <p>Info with <code>progress-bar-info</code> class.</p>
									  <div class="progress">    
										<div class="progress-bar progress-bar-info" style="width: 60%"></div>
									  </div>
									  <p>Success with <code>progress-bar-success</code> class.</p>
									  <div class="progress">
										<div class="progress-bar progress-bar-success" style="width: 30%"></div>
									  </div>
									  <p>Warning with <code>progress-bar-warning</code> class.</p>
									  <div class="progress">
										<div class="progress-bar progress-bar-warning" style="width: 70%"></div>
									  </div>
									  <p>Danger with <code>progress-bar-danger</code> class.</p>
									  <div class="progress">
										<div class="progress-bar progress-bar-danger" style="width: 50%"></div>
									  </div>
									  <p>Inverse with <code>progress-bar-inverse</code> class.</p>
									  <div class="progress">
										<div class="progress-bar progress-bar-inverse" style="width: 40%"></div>
									  </div>
									   <p>Inverse with <code>progress-bar-inverse</code> class.</p>
									  <div class="progress">
										<div class="progress-bar progress-bar-success" style="width: 35%"><span class="sr-only">35% Complete (success)</span></div>
										<div class="progress-bar progress-bar-warning" style="width: 20%"><span class="sr-only">20% Complete (warning)</span></div>
										<div class="progress-bar progress-bar-danger" style="width: 10%"><span class="sr-only">10% Complete (danger)</span></div>
									  </div>
								</div>
						   </div>
					   </div>
					   <div class="grid_3 grid_5">
						 <h3>Alerts</h3>
						 <div class="but_list">
						   <div class="alert alert-success" role="alert">
							<strong>Well done!</strong> You successfully read this important alert message.
						   </div>
						   <div class="alert alert-info" role="alert">
							<strong>Heads up!</strong> This alert needs your attention, but it's not super important.
						   </div>
						   <div class="alert alert-warning" role="alert">
							<strong>Warning!</strong> Best check yo self, you're not looking too good.
						   </div>
						   <div class="alert alert-danger" role="alert">
							<strong>Oh snap!</strong> Change a few things up and try submitting again.
						   </div>
						 </div>
					   </div>
					   <div class="grid_3 grid_5">
						 <h3>Pagination</h3>
						 <div class="col-md-6 page_1">
						  <nav>
						  <ul class="pagination pagination-lg">
							<li><a href="#" aria-label="Previous"><i class="fa fa-angle-left"></i></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><i class="fa fa-angle-right"></i></a></li>
						  </ul>
						  </nav>
						  <nav>
						  <ul class="pagination">
							<li><a href="#" aria-label="Previous"><i class="fa fa-angle-left"></i></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><i class="fa fa-angle-right"></i></a></li>
						  </ul>
						</nav>
						<nav>
						  <ul class="pagination pagination-sm">
							<li><a href="#" aria-label="Previous"><i class="fa fa-angle-left"></i></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><i class="fa fa-angle-right"></i></a></li>
						  </ul>
						</nav>
						</div>
						<div class="col-md-6 page_1">
							<ul class="pagination pagination-lg">
								<li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
						   </ul>
						<nav>
						  <ul class="pagination">
							<li class="disabled"><a href="#" aria-label="Previous"><i class="fa fa-angle-left"></i></a></li>
							<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><i class="fa fa-angle-right"></i></a></li>
						 </ul>
					   </nav>
						 <ul class="pagination pagination-sm">
							<li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
						</ul>
						</div>
					   <div class="clearfix"> </div>
					   </div>
					   <div class="grid_3 grid_5">
						 <h3>Breadcrumbs</h3>
						 <div class="but_list">
							<ol class="breadcrumb">
							  <li class="active">Home</li>
							</ol>
							<ol class="breadcrumb">
							  <li><a href="#">Home</a></li>
							  <li class="active">Library</li>
							</ol>
							<ol class="breadcrumb">
							  <li><a href="#">Home</a></li>
							  <li><a href="#">Library</a></li>
							  <li class="active">Data</li>
							</ol>
						  </div>
					   </div>
					   <div class="grid_3 grid_5">
						 <h3>Badges</h3>
						   <div class="but_list">
							<div class="col-md-6 page_1">
								<p>Add modifier classes to change the appearance of a badge.</p>
								  <table class="table table-bordered">
									<thead>
										<tr>
											<th width="50%">Classes</th>
											<th width="50%">Badges</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>No modifiers</td>
											<td><span class="badge1">42</span></td>
										</tr>
										<tr>
											<td><code>.badge-primary</code></td>
											<td><span class="badge1 badge-primary">1</span></td>
										</tr>
										<tr>
											<td><code>.badge-success</code></td>
											<td><span class="badge1 badge-success">22</span></td>
										</tr>
										<tr>
											<td><code>.badge-info</code></td>
											<td><span class="badge1 badge-info">30</span></td>
										</tr>
										<tr>
											<td><code>.badge-warning</code></td>
											<td><span class="badge1 badge-warning">412</span></td>
										</tr>
										<tr>
											<td><code>.badge-danger</code></td>
											<td><span class="badge1 badge-danger">999</span></td>
										</tr>
									</tbody>
								  </table>                    
							</div>
							<div class="col-md-6 page_1">
							  <p>Easily highlight new or unread items with the <code>.badge</code> class</p>
								<div class="list-group list-group-alternate"> 
									<a href="#" class="list-group-item"><span class="badge1">201</span> <i class="ti ti-email"></i> Inbox </a> 
									<a href="#" class="list-group-item"><span class="badge1 badge-primary">5021</span> <i class="ti ti-eye"></i> Profile visits </a> 
									<a href="#" class="list-group-item"><span class="badge1">14</span> <i class="ti ti-headphone-alt"></i> Call </a> 
									<a href="#" class="list-group-item"><span class="badge1">20</span> <i class="ti ti-comments"></i> Messages </a> 
									<a href="#" class="list-group-item"><span class="badge1 badge-warning">14</span> <i class="ti ti-bookmark"></i> Bookmarks </a> 
									<a href="#" class="list-group-item"><span class="badge1 badge-danger">30</span> <i class="ti ti-bell"></i> Notifications </a> 
								</div>
						   </div>
						   <div class="clearfix"> </div>
						   </div>
						 </div>
						 <div class="grid_3 grid_5">
							 <h3>Tabs</h3>
							 <div class="but_list">
							   <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
								<ul id="myTab" class="nav nav-tabs" role="tablist">
								  <li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Home</a></li>
								  <li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile">Profile</a></li>
								  <li role="presentation" class="dropdown">
									<a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown" aria-controls="myTabDrop1-contents">Dropdown <span class="caret"></span></a>
									<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1" id="myTabDrop1-contents">
									  <li><a href="#dropdown1" tabindex="-1" role="tab" id="dropdown1-tab" data-toggle="tab" aria-controls="dropdown1">@fat</a></li>
									  <li><a href="#dropdown2" tabindex="-1" role="tab" id="dropdown2-tab" data-toggle="tab" aria-controls="dropdown2">@mdo</a></li>
									</ul>
								  </li>
								</ul>
							<div id="myTabContent" class="tab-content">
							  <div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
								<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
							  </div>
							  <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
								<p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
							  </div>
							  <div role="tabpanel" class="tab-pane fade" id="dropdown1" aria-labelledby="dropdown1-tab">
								<p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
							  </div>
							  <div role="tabpanel" class="tab-pane fade" id="dropdown2" aria-labelledby="dropdown2-tab">
								<p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
							  </div>
							</div>
					   </div>
					   </div>
					  </div>
					  <div class="grid_3 grid_5">
						 <h3>Wells</h3>
						 <div class="but_list">
						   <div class="well">
							There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration
						   </div>
						   <div class="well">
							It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here
						   </div>
						   <div class="well">
							Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic
						   </div>
						 </div>
					  </div>
				</div>
			</div>
		</div>

<jsp:include page="include/foot.jsp"></jsp:include>