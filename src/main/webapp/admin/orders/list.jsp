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
	<form action="/admin/orders/findAll" method="post">
		<label class="item item-input">
			<span class="input-label">订单号</span>
			<input name="onum" placeholder="输入订单号" maxlength="12" type="text"/>
		</label>
		<div class="ui-field-contain">
			<label for="hospital">所属医院</label>
			<select name="hospital" id="select-2">
				<option value="" selected="selected">请选择医院</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
			<label for="administrative">所属科室</label>
			<select name="administrative" id="select-2">
				<option value="" selected="selected">请选择科室</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
			<label for="status">订单状态</label>
			<select name="status" id="select-3">
				<option value="" selected="selected">订单状态</option>
				<option value="1">待支付</option>
				<option value="2">进行中</option>
				<option value="4">已完成</option>
				<option value="5">交易关闭</option>
				<option value="6">异常</option>
			</select>
		</div>
		<input type="date" placeholder="请输入开始时间"  name="btime">
		<input type="date" placeholder="请输入结束时间"  name="etime"><br>
		<button class="button button-light" type="submit">提交</button>
		<button type="reset">重置</button>
	</form>
	<table id="table-1" border="1">
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
				<th>
				<a href="findById?oid=${orders.oid }">详情</a>
				|
				删除
				</th>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>