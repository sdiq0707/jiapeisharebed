<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table-locale-all.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<script>
	$.ajaxSetup({
			global:true,
			type:"POST",
			async:false,
			cache:true
		});
	var hs;
	var as;
	$(function(){
			$.ajax({
					url:"findHospital",
					dataType:"json",
					success:function(msg){
							hs=msg;
							fillP();
						}
				});
		});

	function fillP(){
			$.each(hs,function(i,item){
					$("#h").append("<option value="+item.hid+">"+item.hname+"</option>");
				});
				fillA(0);
		}
		function fillA(index){
				$("#a").empty();
				for(var i=0;i<hs.length;i++){
						if(hs[i].hid==index){
							as =hs[i].administrative;
							}
					}
				$.each(as,function(i,item){
					$("#a").append("<option value="+item.aid+">"+item.aname+"</option>");
				});
			}
</script>
<meta charset="utf-8">
<title>床位管理</title>
</head>
<body>
<h4 align="center">床位管理</h4>
<form action="searchByBid" method="post" class="form-inline" role="form">
	<input type="text" name="bid" placeholder="请输入床位ID">
	<input type="submit" value="搜索">
</form>
<form action="searchByCondition" method="post" class="form-inline" role="form">
	选择医院：<select id="h" name="hid" onchange="fillA(this.value)"></select>
	选择科室：<select id="a" name="aid" ></select><br>
	选择厂家:<c:forEach items="${factorys }" var="factory">
			<input type="radio" name="fid" value="${factory.fid }">
			${factory.fname }
		</c:forEach><br>
	选择股东:<c:forEach items="${shareholders }" var="shareholder">
			<input type="radio" name="uid" value="${shareholder.uid }">
			${shareholder.userinfo.uname }
		</c:forEach>
	<input type="submit" value="条件查询">
</form>
<a href="goInput" class="btn btn-primary">新增</a>
<table class="table table-striped" class="table text nowrap">
<tr>
	<td>床位ID</td>
	<td>厂家ID</td>
	<td>股东ID</td>
	<td>编号</td>
	<td>厂家</td>
	<td>厂家联系人</td>
	<td>厂家电话</td>
	<td>状态</td>
	<td>是否故障</td>
	<td>是否删除</td>
	<td>所属编号</td>
	<td>所属医院</td>
	<td>所属科室</td>
	<td>编辑</td>
</tr>
<c:forEach items="${beds }" var="bed">
<tr>
	<td>${bed.bid }</td>
	<td>${bed.fid }</td>
	<td>${bed.uid }</td>
	<td>${bed.bnum }</td>
	<td>${bed.factory.fname }</td>
	<td>${bed.productorconnectname }</td>
	<td>${bed.factory.phone }</td>
	<td>${bed.bstatus }</td>
	<td>${bed.istrouble }</td>
	<td>${bed.isdelete==1? '已删除' : '正常'}</td>
	<td>${bed.fkid }</td>
	<td>${bed.hospitaiAdministrative.hospital.hname }</td>
	<td>${bed.hospitaiAdministrative.administrative.aname }</td>
	<td><a href="findById?bid=${bed.bid }">修改</a>|<a href="${bed.isdelete==1?'revoke':'delete' }?bid=${bed.bid }">${bed.isdelete==1?'恢复':'删除' }</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
