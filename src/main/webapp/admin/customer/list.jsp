<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<script>
			$(document).ready(function(){

				$(".delBtn").click(function(){
					var sel = window.confirm("您确认删除该用户吗？删除后有关用户信息会全部删除哦？");
					if(sel){
						location.href="delete?cid="+$(this).val();
					}
				});
			});
		</script>
</head>
<body>
	<div id="app">
	<h4>用户管理/用户</h4>
			手机号<INPUT TYPE="text" NAME="phone">
			性别<INPUT TYPE="text" NAME="sex">
			注册日期<INPUT TYPE="text"NAME="regtime">
			<input type="button" value="Query">
			
			<TABLE border="1px" width="100%">
				<TR>
					<TD>手机号</TD>
					<TD>昵称</TD>
					<TD>性别</TD>
					<TD>注册时间</TD>
					<TD>订单总数</TD>
					<TD>累计消费(￥)</TD>
					<TD>操作</TD>
				</TR>
				
				<c:forEach items="${list}" var="customer">
					<TR>
						<TD>${customer.phone}</TD>
						<TD>${customer.cnickname}</TD>
						<TD>${customer.sex}</TD>
						<TD>
							<fmt:formatDate value="${customer.regtime}"
								pattern="yyyy-MM-dd hh:mm:ss" />
						</TD>
						<TD>${customer.ordertimes}</TD>
						<TD>${customer.sumconsume}</TD>
						<TD>
							<a href="findByIdDetail?cid=${customer.cid }">详情</a>   
							<button class="delBtn" value="${customer.cid }">删除</button>
						</TD>
					</TR>
				</c:forEach>
			</TABLE>
			
	</div>
</body>
</html>