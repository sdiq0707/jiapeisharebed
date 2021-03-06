<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>订单信息</h2>
	<div class="ui-grid-b" style="width: 80%">
		<div class="ui-block-a">订单号 ： ${orders.onum }</div>
		<div class="ui-block-b">订单状态： ${orders.orderstatus }</div>
		<div class="ui-block-c">
		租用时常 ：${days } 天${hours }小时${minutes }分
		</div>
		<div class="ui-block-a">下单时间 ：
			<fmt:formatDate value="${orders.ordertime }" pattern="yyyy-MM-dd hh:mm:ss"/>
		</div>
		<div class="ui-block-b">归还时间： 
		<fmt:formatDate value="${orders.returntime }" pattern="yyyy-MM-dd hh:mm:ss"/>
		</div>
		<div class="ui-block-c">是否异常 ：${orders.isunusual }</div>
		<div class="ui-block-a">异常类型： ${orders.unusualtype }</div>
		<div class="ui-block-b">租用金额： ${orders.actualpay }</div>
	</div>
<HR align=center width=100% color=#987cb9 SIZE=1>
	<h2>床位信息</h2>
	<div class="ui-grid-b">
		<div class="ui-block-a">所属医院：${orders.bed.hospitaiAdministrative.hospital.hname }</div>
		<div class="ui-block-b">所属科室：${orders.bed.hospitaiAdministrative.administrative.aname }</div>
		<div class="ui-block-c">床位编号：${bed.bnum }</div>
	</div>
<HR align=center width=100% color=#987cb9 SIZE=1>
	<h2>支付信息</h2>
	<div class="ui-grid-b">
		<div class="ui-block-a">支付状态：${orders.paystatus }</div>
		<div class="ui-block-b">
		支付时间：
		<fmt:formatDate value="${orders.paytime }" pattern="yyyy-MM-dd hh:mm:ss"/>
		</div>	
	</div>
</body>

</html>