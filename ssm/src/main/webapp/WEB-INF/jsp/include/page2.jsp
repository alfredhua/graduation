<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<link href="static/JqueryPagination/mricode.pagination.css" rel="stylesheet" />
<script src="static/JqueryPagination/jquery-2.1.4.min.js"></script>
<script src="static/JqueryPagination/mricode.pagination.js"></script>
<body>

				<div class="marge">
			     		 <div id="page" class="m-pagination"></div>
					</div>
  <script>
            $("#page").pagination({
                pageIndex:'${pageVo.currentPage}'-1,
                pageSize: '${pageVo.pageSize}',
                total: '${pageVo.total}',
                debug: true,
                showJump: true,
                showPageSizes: true,
                pageElementSort: ['$page', '$size', '$jump'],
             
            });
            
            $("#page").on("pageClicked", function (event, data) { 
            	$("#currentPage").val(data.pageIndex+1);
            	$("#query").submit();
           }).on('jumpClicked', function (event, data) {
        	   $("#currentPage").val( data.pageIndex+1);

        		$("#query").submit();
           }).on('pageSizeChanged', function (event, data) {
        	   $("#pageSize").val(data.pageSize);
        	   $("#currentPage").val( data.pageIndex+1); 
        		$("#query").submit();
           });
    </script>
</body>
</html>

