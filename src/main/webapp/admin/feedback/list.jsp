<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户反馈信息</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h5>用户反馈信息展示</h5>
	<form action="" method="post">
		time:<input type="date" name="time1"/>至<input type="date" name="time1"/>
		<button type="submit">搜索</button><button type="reset">取消</button>
	</form>
	<table class="table table-bordered table-hover table-striped" >
		<tr class="text-center">
			<td>fid</td>
			<td>content</td>
			<td>photo</td>
			<td>phone</td>
			<td>time</td>
			<td>isdelete</td>
			<td>operation</td>
		</tr>
		<c:forEach items="${list }" var="feedback">
			<tr class="text-center">
				<td>${feedback.fid}</td>
				<td>${feedback.content}</td>
				<td>
					<img src="<%=basePath%>/upload/${feedback.photo}" width="100px"/>
				</td>
				<td>${feedback.phone}</td>
				<td>
					<fmt:formatDate value="${feedback.time}" pattern="yyyy-MM-dd"/>
				</td>
				<td>${feedback.isdelete==1?'正常':'已删除'}</td>
				<td>
					<a href="${feedback.isdelete==1?'delete':'revoke'}?fid=${feedback.fid}">${feedback.isdelete==1?'删除':'恢复'}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<button class="btn btn-success" onclick="location.href='save.jsp'">增加</button>
</body>
</html>