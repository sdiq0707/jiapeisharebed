<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<h5>订单记录</h5>
<button class="btn btn-success">导出报表</button> &nbsp;&nbsp;&nbsp;&nbsp; <span>订单总数：${customer.ordertimes}</span>
<TABLE class="table table-bordered table-hover table-striped">
	<TR class="success">
		<TD>订单号</TD>
		<TD>床位号</TD>
		<TD>所属医院</TD>
		<TD>所属科室</TD>
		<TD>实际支付</TD>
		<TD>下单时间</TD>
		<TD>租用时长</TD>
	</TR>

	<c:forEach items="${customer.orders}" var="orders" varStatus="i">
		<TR>
			<TD>${orders.onum}</TD>
			<TD>${orders.bed.bnum}</TD>
			<TD>${orders.bed.hospitaiAdministrative.hospital.hname}</TD>
			<TD>${orders.bed.hospitaiAdministrative.administrative.aname}</TD>
			<TD>${orders.actualpay}</TD>
			<TD><f:formatDate value="${orders.ordertime}"
					pattern="yyyy-MM-dd hh:mm:ss" /></TD>
			<TD>${times[i.index]}</TD>
		</TR>
	</c:forEach>
</TABLE>
