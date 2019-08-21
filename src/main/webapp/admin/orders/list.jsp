<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table id="table-1">
		<thead>
			<tr>
				<th>订单号</th>
				<th>床位编号</th>
				<th>支付金额</th>
				<th>支付状态</th>
				<th>下单时间</th>
				<th>归还时间</th>
				<th>支付时间</th>
				<th>所属医院</th>
				<th>所属科室</th>
				<th>用户手机号</th>
				<th>订单状态</th>				
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="orders">
			<tr>
				<!-- //订单号 -->
				<th>${orders.onum}</th>
				<!-- 床位编号 -->
				<th>${orders.actualpay}</th>
				<!-- 支付金额 -->
				<th>${orders.actualpay}</th>
				<!-- 支付状态 -->
				<th>${orders.paystatus}</th>
				<!-- 下单时间 -->
				<th>${orders.ordertime}</th>
				<!--归还时间-->
				<th>${orders.returntime}</th>
				<!--支付时间-->
				<th>${orders.paytime}</th>
				<!--所属医院-->
				<th></th>
				<!--所属科室-->
				<th></th>
				<!--用户手机号-->
				<th>${orders.cid}</th>
				<!--订单状态-->
				<th>${orders.orderstatus}</th>				
				<th>详情|删除</th>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>