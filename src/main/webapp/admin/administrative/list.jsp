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
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
<h6>所查询的科室信息</h6>
	<table class="table table-bordered table-hover table-striped" >
				<tr class="text-center">
					<td>aid</td>
					<td>aname</td>
					<td>isdelete</td>
					<td>operation</td>
				</tr>
				<tr>
					<td>${administrative.aid}</td>
					<td>${administrative.aname}</td>
					<td>${administrative.isdelete==1?'正常':'已删除'}</td>
					<td>
						<a href="findById?aid=${administrative.aid }">编辑</a>
						|
						<a href="findByIdDetail?aid=${administrative.aid }">详情</a>
						|
						<a href="${administrative.isdelete==1?'delete':'revoke'}?aid=${administrative.aid }">${administrative.isdelete==1?'已删除':'恢复'}</a>
					</td>
				</tr>
		</table>
</body>
</html>
