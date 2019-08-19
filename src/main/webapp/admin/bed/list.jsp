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
<table border="1" width="100%">
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
	<td>${bed.isdelete }</td>
	<td>${bed.fkid }</td>
</tr>
<c:forEach items="${beds }" var="bed">
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
</tr>
</c:forEach>
</table>
</body>
</html>