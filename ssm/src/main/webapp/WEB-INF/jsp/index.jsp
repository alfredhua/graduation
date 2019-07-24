<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/head.jsp"%>

<script type="application/x-javascript"> 
	$(function(){
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        myChart.setOption({
            title: {
                text: '入职人员数量分布'
            },
            tooltip: {},
            legend: {
                data:['人数']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
             xAxis: {
            	 axisLabel:{
            		 rotate:30 
            	 },
            	 data: []
            }, 
            yAxis: {
            	min:0,
            	max:10
            },
            series: [{        
                type: 'bar',
                data: []
            }]
        });
        
        $.get('user/getUserWorkTime.do').done(function(msg){   
        	var obj = jQuery.parseJSON(msg)        
        	  myChart.setOption({
        		  xAxis: {
        	            data:obj.date
        	        },
        	       series: [{
        	            name: '人数',
        	            data: obj.amount
        	      }]
        	  });
        });
        
        var myChart2 = echarts.init(document.getElementById('main2'));
        myChart2.setOption({
        	    title : {
        	        text: '公司男女比例',       	      
        	        x:'center'
        	    },
        	    tooltip : {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
        	    },
        	    legend: {
        	        orient : 'vertical',
        	        x : 'left',
        	        data:[]
        	    },
        	    toolbox: {
        	        show : true,
        	        feature : {
        	            mark : {show: true},
        	            dataView : {show: true, readOnly: false},
        	            magicType : {
        	                show: true, 
        	                type: ['pie', 'funnel'],
        	                option: {
        	                    funnel: {
        	                        x: '25%',
        	                        width: '50%',
        	                        funnelAlign: 'left',
        	                        max: 1548
        	                    }
        	                }
        	            },
        	            restore : {show: true},
        	            saveAsImage : {show: true}
        	        }
        	    },
        	    calculable : true,
        	    series : [
        	        {
        	            name:'访问来源',
        	            type:'pie',
        	            radius : '55%',
        	            center: ['50%', '60%'],
        	            data:[]
        	        }
        	    ]
        	});
         $.get('user/getUserSex.do').done(function(msg){   
        	var obj = jQuery.parseJSON(msg)        
        	  myChart2.setOption({
        		  series: [{
        	            name: '人数',
        	            data: obj.pvDatas
        	      }]
        	  });
        });
      		
	})
</script>
<title>后台管理</title>
</head>
 <body class="sticky-header left-side-collapsed" >
<jsp:include page="list.jsp"></jsp:include>   
		<div class="main-content">
			<div class="header-section">
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<jsp:include page="include/topNotification.jsp"></jsp:include>
			</div>
		 <div>
			<div class="col-md-4 span_8" style="margin-top: 26px;width: 600px">
				<div class="activity_box activity_box1" style="margin-left: 50px;">
					<h3>入职人员数量分布</h3>
					<div  id="style-2" >
						<div >
							<div id="main" class="single-bottom" style="width: 500px;height:300px;">
								
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
				<div class="col-md-4 span_8" style="margin-top: 26px;width: 600px">
				<div class="activity_box activity_box1" style="margin-left: 50px;">
					<h3>日报填写记录</h3>
					<div  id="style-2" >
							<table class="table table-bordered" style="width: 520px;">
									<thead>
											<tr>
											<th>日报时间</th>
									<th>工作内容</th>
									<th>工作地点</th>
									<th>工作时长</th>
									<th>加班内容</th>
									<th>加班时长</th>
											</tr>
											</thead>										
									  <tbody>
									  <c:if test="${empty pageDaily.voList}">
									   		<tr><td colspan="5" style="text-align: center;">暂无数据</td></tr>
									   </c:if>
									  <c:if test="${ not empty pageDaily.voList}">
											  <c:forEach items="${pageDaily.voList }" var="data">
													<tr class="info">
									<td><fmt:formatDate value="${data.workDate}" pattern="yyyy-MM-dd" /> </td>
									<td>${fn:substring(data.dailyContext, 0, 5)}...</td>
									<td>
									  <c:if test="${data.workSite eq '1'}">公司办公</c:if>
									 <c:if test="${data.workSite eq '2'}">本地驻场</c:if>
									 <c:if test="${data.workSite eq '3'}">出差驻场</c:if>
									</td>
									<td>${data.workTime }</td>
									<td><c:if test="${empty  data.overWorkContext }">无</c:if>
									<c:if test="${not empty  data.overWorkContext }">${data.overWorkContext }</c:if></td>
									<td>${data.overTime }</td>
								</tr>
												</c:forEach>
										</c:if>		 
									</tbody>
								</table>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			
			<div class="col-md-4 span_8" style="margin-top: 26px;width: 600px">
				<div class="activity_box activity_box1" style="margin-left: 50px;">
					<h3>公司男女比例</h3>
					<div  id="style-2" >
						<div >
							<div id="main2" class="single-bottom" style="width: 500px;height:300px;">
								
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
				<div class="col-md-4 span_8" style="margin-top: 26px;width: 620px">
				<div class="activity_box activity_box1" style="margin-left: 69px;">
					<h3>薪资发放记录</h3>
					<div  id="style-2" >
						<div >
							<div class="single-bottom">
									<table class="table table-bordered" style="width: 520px;">
									<thead>
											<tr>
												<td>基本薪资</td>
												<td>餐补</td>
												<td>奖惩</td>
												<td>发放时间</td>
												<td>总额</td>
											</tr>
											</thead>										
									  <tbody>
									  <c:if test="${empty page.voList}">
									   		<tr><td colspan="5" style="text-align: center;">暂无数据</td></tr>
									   </c:if>
									  <c:if test="${ not empty page.voList}">
											  <c:forEach items="${page.voList }" var="data">
												 <tr >
													   <td>${data.basic}</td>
													  <td>${data.eat}</td>
													  <td>${data.punishment}</td>
													  <td>${fn:substring(data.grantTime, 0, 10)}</td>
													  <td>${data.totalize}</td>
												</tr> 
												</c:forEach>
										</c:if>		 
									</tbody>
								</table>
								
							</div>
						
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
	

			</div>	
			</div>

		</div>
<%@include file="include/foot.jsp" %> 

