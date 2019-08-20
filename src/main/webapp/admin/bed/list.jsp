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
	<td>bid</td>
	<td>fid</td>
	<td>uid</td>
	<td>bnum</td>
	<td>productor</td>
	<td>productorconnectname</td>
	<td>productorphone</td>
	<td>bstatus</td>
	<td>istrouble</td>
	<td>isdelete</td>
	<td>fkid</td>
	<td>编辑</td>
</tr>
<c:forEach items="${beds }" var="bed">
<tr>
	<td>${bed.bid }</td>
	<td>${bed.fid }</td>
	<td>${bed.uid }</td>
	<td>${bed.bnum }</td>
	<td>${bed.productor }</td>
	<td>${bed.productorconnectname }</td>
	<td>${bed.productorphone }</td>
	<td>${bed.bstatus }</td>
	<td>${bed.istrouble }</td>
	<td>${bed.isdelete==1? '已删除' : '正常'}</td>
	<td>${bed.fkid }</td>
	<td><a href="findById?bid=${bed.bid }">修改</a>|<a href="${bed.isdelete==1?'revoke':'delete' }?bid=${bed.bid }">${bed.isdelete==1?'恢复':'删除' }</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>