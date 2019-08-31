<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>佳陪后台管理系统</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div class="container" align="center">
		<div class="jumbotron">
			<h1>欢迎进入佳陪共享床登陆页面！</h1>
		</div>
	</div>

<div align="center">	
<form  action="login" method="post" >
		<div class="form-group">
			<label for="uname" class="col-sm-10 control-label">用户名：</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" name="uname" 
					   placeholder="请输入用户名">
			</div>
		</div>
		<div class="form-group">
			<label for="upass" class="col-sm-10 control-label">密码：</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" name="upass" 
					   placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label>
						<input type="checkbox"> 请记住我
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-info">登录</button>
				<button type="reset" class="btn btn-danger">重置</button>
			</div>
		</div>
</form> 
</div>
<div id="Clock" style='position:absolute;bottom:0px;left:650px'><h3>&copy;xxxx公司版权所有</h3></div>
</body>
</html>