<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h4>基本信息</h4>

<input name="cid" type="hidden" value="${customer.cid }">
手机号:${customer.phone }"
昵称:${customer.cnickname }"
性别:${customer.sex }"<br>
注册时间:${customer.regtime }"
订单总数:${customer.ordertimes}"<br>
累计消费:${customer.sumconsume }"<br>
<a href="findById?cid=${customer.cid }">编辑资料</a>
<a href="delete?cid=${customer.cid }">删除用户</a>

<hr>



</body>
</html>