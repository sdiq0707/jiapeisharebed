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
<form action="update" method="post">
<input name="cid" type="hidden" value="${customer.cid }">
手机号:<input type="text" name="fid" value="${customer.phone }">
昵称:<input type="text" name="uid" value="${customer.cnickname }">
性别:<input type="text" name="bnum" value="${customer.sex }"><br>
注册时间:<input type="text" name="productor" value="${customer.regtime }">
订单总数:<input type="text" name="productorconnectname" value="${customer.ordertimes}"><br>
累计消费:<input type="text" name="productorphone" value="${customer.sumconsume }"><br>
<input type="submit" value="保存">
<input type="url" value="取消"><br>
</form>

<hr>



</body>
</html>