<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>

	<%@ include file="/../include/usericon.jsp" %>
	
		<h4>用户管理/用户</h4>
		<br>
		<form method="post" action="findAll">
			手机号<INPUT TYPE="text" NAME="phone" value="${customer.phone }">
			性别<INPUT TYPE="text" NAME="sex" value="${customer.sex }">
			<input type="submit" value="Query" class="btn btn-success">
		</form>
			注册日期<INPUT TYPE="date"  NAME="regtime" value="${customer.regtime }">
			至<INPUT TYPE="date" pattern="yy-MM-dd" name="etime"  value="${customer.regtime }">
			<br><br><hr>
			<button class="btn btn-success">导出报表</button> 
			<span >用户总数：</span>${count}
			<TABLE class="table table-bordered table-hover table-striped">
				<TR class="success">
					<TD>手机号</TD>
					<TD>昵称</TD>
					<TD>性别</TD>
					<TD>注册时间</TD>
					<TD>订单总数</TD>
					<TD>累计消费(元)</TD>
					<TD>账号余额(元)</TD>
					<TD>状态</TD>
					<TD>操作</TD>
				</TR>
				
				<c:forEach items="${list}" var="customer">
					<TR>
						<TD>${customer.phone}</TD>
						<TD>${customer.cnickname}</TD>
						<TD>${customer.sex}</TD>
						<TD>
							<f:formatDate value="${customer.regtime}"
								pattern="yyyy-MM-dd hh:mm:ss" />
						</TD>
						<TD>${customer.ordertimes}</TD>
						<TD>￥${customer.sumconsume}</TD>
						<TD>￥${customer.balance}</TD>
						<TD>${customer.isdelete==1? '不可用' : '正常'}</TD>
						<TD>
							<a href="findByIdDetail?cid=${customer.cid }">详情</a>   
							<a href="${customer.isdelete==1?'revoke':'delete' }?cid=${customer.cid }">${customer.isdelete==1?'恢复':'删除' }</a>
						</TD>
					</TR>
				</c:forEach>
				<tr>
					<td colspan="9">
						<ul class="pagination">
						    <li><a href="#">&laquo;</a></li>
						    <li class="active"><a href="#">1</a></li>
						    <li class="disabled"><a href="#">2</a></li>
						    <li><a href="#">3</a></li>
						    <li><a href="#">4</a></li>
						    <li><a href="#">5</a></li>
						    <li><a href="#">&raquo;</a></li>
						</ul>
					</td>
				</tr>
			</TABLE>
</body>
</html>