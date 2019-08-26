<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
	<%@ include file="/../include/usericon.jsp" %>
	
	<h4>
		<a href="findByIdDetail?cid=${customer.cid }"><span class="	glyphicon glyphicon-circle-arrow-left"></span></a>
		用户管理/用户/用户编辑
	</h4>
	<hr>
	<h3>基本信息</h3>
	<form action="update" method="post">
		<input name="cid" type="hidden" value="${customer.cid }">
		手机号:<input type="text" name="phone" value="${customer.phone }">
		昵称:<input type="text" name="cnickname" value="${customer.cnickname }">
		性别:<input type="text" name="sex" value="${customer.sex }"><br>
		注册时间:<f:formatDate value="${customer.regtime }" pattern="yyyy-MM-dd hh:mm:ss"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		订单总数:${customer.ordertimes}<br>
		累计消费:${customer.sumconsume }&nbsp;&nbsp;&nbsp;
		账户余额:${customer.balance }<br>
		<input type="submit" class="btn btn-success" value="修改">
		<input type="reset" class="btn btn-success" value="重置">
	</form>

<br><hr>

<%@ include file="/../include/orderlist.jsp" %>

</body>
</html>