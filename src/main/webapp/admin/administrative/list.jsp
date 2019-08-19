<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科室管理</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="app">
<h3>科室详情</h3>
	<table class="table table-bordered table-hover table-striped" >	
			<tr>
				<td>aid</td>
				<td>aname</td>
				<td>isdelete</td>
			</tr>
			
			<tr v-for="log in json.list">
				<td>{{administrative.aid}}</td>
				<td>{{administrative.aname}}</td>
				<td>{{administrative.isdelete}}</td>
			</tr>
	</table>
</div>	
</body>
</html>