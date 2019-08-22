<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科室管理</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
$(document).ready(function(){
	$("#save").click(function(){
		location.href="goSave";
	});
});
</script>
</head>
<body>
<h4>科室详情</h4>
<button id="save" class="btn btn-success" >增加科室</button>
	<table class="table table-bordered table-hover table-striped" >
			<tr>
				<td>aid</td>
				<td>aname</td>
				<td>isdelete</td>
				<td>operation</td>
			</tr>
			
			<c:forEach items="${list}" var="administrative">
				<tr>
						<td>${administrative.aid}</td>
						<td>${administrative.aname}</td>
						<td>${administrative.isdelete==1?'正常':'已删除'}</td>
						<td>
							<a href="findById?aid=${administrative.aid }">编辑</a>
							|
							<a href="${administrative.isdelete==1?'delete':'revoke' }?aid=${administrative.aid }">${administrative.isdelete==1?'删除':'恢复'}</a>
						</td>
				</tr>
			</c:forEach>
	</table> 
</body>
</html>