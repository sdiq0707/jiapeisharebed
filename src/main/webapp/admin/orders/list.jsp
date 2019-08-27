<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<script>
	$.ajaxSetup({
			global:true,
			type:"POST",
			async:false,
			cache:false
		});
	var hospitals;
	var cs;
	$(function(){
		$.ajax({
			   url: "findAllhospital",
			   dataType:"json",
			   success: function(msg){
				hospitals = msg;
			    fillH(); 
			   }
		});
	});
	function fillH(){
		$.each(hospitals,function(i,hospital){
			
			$("#select-1").append("<option value="+hospital.hid+">"+hospital.hname+"</option>");
		});
		
	}
	function fillA(value){	
		$("#select-2").empty();
		$("#select-2").append("<option value=\"\" selected=\"selected\">-请先选择医院-</option>");
		$.each(hospitals,function(i,hospital){
			var hid=hospital.hid;
			if(hid==value){
				cs = hospital.administrative;
				$.each(cs,function(i,item){
					$("#select-2").append("<option value="+item.aid+">"+item.aname+"</option>");
			});
			}
		});
		
	}
</script>
</head>
<body>
	<form action="/admin/orders/findAll" method="post">
		
		

		<label class="item item-input">
			<span class="input-label">订单号</span>
			<input name="onum" placeholder="输入订单号" maxlength="12" type="text"/>
		</label>
		<div class="ui-field-contain">
			<label for="hid">所属医院</label>
			<select name="hid" id="select-1" onchange="fillA(this.value)">
				<option value="" selected="selected" >--请选择医院--</option>
				
			</select>
			<label for="aid">所属科室</label>
			<select name="aid" id="select-2" >
				<option value="" selected="selected">--请先选择医院--</option>
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
		请输入开始时间：<input type="date" placeholder="请输入开始时间"  name="btime" >
		请输入结束时间：<input type="date" placeholder="请输入结束时间"  name="etime"><br>
		<button type="button" class="btn btn-success" type="submit">提交</button>
		<button type="reset" class="btn btn-danger">重置</button>
	</form>
	<div>
		<h4>共${count }条记录</h4>
	</div>
	<div>
		<table id="table-1" class="table table-sm" style=" text-align: center;">
			<thead>
				<tr>
					<th scope="col">订单号</th>
					<th scope="col">床位编号</th>
					<th scope="col">支付金额</th>
					<th scope="col">支付状态</th>
					<th scope="col">下单时间</th>
					<th scope="col">归还时间</th>
					<th scope="col">支付时间</th>
					<th scope="col">所属医院</th>
					<th scope="col">所属科室</th>
					<th scope="col">用户手机号</th>
					<th scope="col">订单状态</th>				
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" var="orders">
				<tr>
					<!-- //订单号 -->
					 <th scope="row">${orders.onum}</th>
					<!-- 床位编号 -->
					<td>${orders.actualpay }</td>
					<!-- 支付金额 -->
					<td>${orders.actualpay }</td>
					<!-- 支付状态 -->
					<td>${orders.paystatus }</td>
					<!-- 下单时间 -->
					<td>
					<fmt:formatDate value="${orders.ordertime }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<!--归还时间-->
					<td>
					<fmt:formatDate value="${orders.returntime }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<!--支付时间-->
					<td>
					<fmt:formatDate value="${orders.paytime }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<!--所属医院-->
					<td>
						${orders.bed.hospitaiAdministrative.hospital.hname }
					</td>
					<!--所属科室-->
					<td>
						${orders.bed.hospitaiAdministrative.administrative.aname }
					</td>
					<!--用户手机号-->
					<td>${orders.cid }</td>
					<!--订单状态-->
					<td>${orders.orderstatus }</td>				
					<td>
						<a href="findById?oid=${orders.oid }">详情</a>
						|
						<a href="${orders.isdelete==1?'revoke':'delete' }?oid=${orders.oid }">
							${orders.isdelete==1?'恢复':'删除' }
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>