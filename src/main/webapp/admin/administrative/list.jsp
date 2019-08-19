<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科室管理</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h4>科室详情</h4>
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
						<td>${administrative.isdelete}</td>
						<td>
							编辑
							|
							<a href="delete?aid=${administrative.aid }">删除</a>
						</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>