<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
</head>
<body>
	<div id="app">
			<h4>用户管理/用户</h4>
			手机号<INPUT TYPE="text" NAME="phone">
			性别<INPUT TYPE="text" NAME="sex"><br>
			注册日期<INPUT TYPE="text"NAME="regtime">至<INPUT TYPE="text"NAME="regtime">
			<input type="button" value="Query">
			<br><br><hr>
			<TABLE border="1px" width="100%">
				<tr>
					<td><button>导出报表</button> 用户总数：10000</td>
				</tr>
				<TR>
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
			</TABLE>
	</div>
</body>
</html>