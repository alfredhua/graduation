<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<link href="static/JqueryPagination/mricode.pagination.css" rel="stylesheet" />
<script src="static/JqueryPagination/jquery-2.1.4.min.js"></script>
<script src="static/JqueryPagination/mricode.pagination.js"></script>
<body>
  <script>

            $("#page").pagination({
                pageIndex: "${departmentTwo.pageVo.currentPage}"-1,
                pageSize: "${departmentTwo.pageVo.pageSize}",
                total: "${departmentTwo.pageVo.total}",
                debug: true,
                showJump: true,
                showPageSizes: true,
                pageElementSort: ['$page', '$size', '$jump'],
             
            });

       
    </script>
</body>
</html>

