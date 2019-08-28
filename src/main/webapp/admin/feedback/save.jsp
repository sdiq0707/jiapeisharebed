<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户反馈信息</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form :form action="save" commandName="cmsModel" method="post" enctype="multipart/form-data">
		反馈内容：<input type="text" name="content" placeholder="请填写反馈信息"/><br/>
		照片：<input type="file" name="file"/><br/>
		手机号：<input type="text" name="phone"  placeholder="请填写反馈人手机号"/><br/>
		反馈时间：<input type="date" name="time1" placeholder="请填写反馈时间"/><br/>
		软删除：<input type="text" name="isdelete"  placeholder="请填写0或1"/><br/>
		<button class="btn btn-info" type="submit">提交</button>
	</form>
</body>
</html>