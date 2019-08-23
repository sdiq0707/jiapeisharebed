<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<h3>订单记录</h3>
<button>导出报表</button> &nbsp;&nbsp;&nbsp;&nbsp; 订单总数：${customer.ordertimes}
<TABLE border="1px" width="100%">
	<TR>
		<TD>订单号</TD>
		<TD>床位号</TD>
		<TD>所属医院</TD>
		<TD>所属科室</TD>
		<TD>实际支付</TD>
		<TD>下单时间</TD>
		<TD>租用时长</TD>
	</TR>

	<c:forEach items="${customer.orders}" var="orders">
		<TR>
			<TD>${orders.onum}</TD>
			<TD>${orders.bed.bnum}</TD>
			<TD>${orders.bed.fkid}</TD>
			<TD>${orders.bed.fkid}</TD>
			<TD>${orders.actualpay}</TD>
			<TD><f:formatDate value="${orders.ordertime}"
					pattern="yyyy-MM-dd hh:mm:ss" /></TD>
			<TD>${orders.onum}</TD>
		</TR>
	</c:forEach>
</TABLE>
