<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>床位管理</title>
</head>
<body>
<a href="goInput">新增</a>
<table border="1" width="100%">
<tr>
	<td>床位ID</td>
	<td>生产厂家ID</td>
	<td>股东ID</td>
	<td>床位编号</td>
	<td>生产厂家</td>
	<td>生产厂家联系人</td>
	<td>生产厂家电话</td>
	<td>状态</td>
	<td>是否故障</td>
	<td>是否删除</td>
	<td>所属医院科室编号</td>
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