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
	<a href="findAll"><span class="	glyphicon glyphicon-circle-arrow-left"></span></a>
	用户管理/用户/用户详情
</h4>
<hr>
<h5>基本信息</h5>

<input name="cid" type="hidden" value="${customer.cid }">
手机号:${customer.phone } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
昵称:${customer.cnickname } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
性别:${customer.sex }<br>

注册时间:<f:formatDate value="${customer.regtime }" pattern="yyyy-MM-dd hh:mm:ss"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
订单总数:${customer.ordertimes}<br>

累计消费(元):￥${customer.sumconsume }&nbsp;&nbsp;&nbsp;
账户余额(元):￥${customer.balance }<br>

<a href="findById?cid=${customer.cid }">编辑资料</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${customer.isdelete==1?'revoke':'delete' }?cid=${customer.cid }">${customer.isdelete==1?'恢复使用':'删除用户' }</a>

<br><hr>

<%@ include file="/../include/orderlist.jsp" %>

</body>
</html>