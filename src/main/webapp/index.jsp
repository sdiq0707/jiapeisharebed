<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>佳陪后台管理系统</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>欢迎进入佳陪后台系统</h3>
<hr>
<form action="login" method="post">
	uname:<input type="text" name="uname"><br/>
	upass:&nbsp;&nbsp;<input type="password" name="upass"><br/>
	<button type="submit" class="btn btn-info">登陆</button>
	<button type="reset" class="btn btn-danger">重置</button>
</form>
</body>
</html>