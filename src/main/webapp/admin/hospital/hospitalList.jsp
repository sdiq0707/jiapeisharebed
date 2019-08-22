<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>医院管理</title>
</head>
<body>
<table border="1" width="100%">
<tr>
	<td>hid</td>
	<td>hname</td>
	<td>province</td>
	<td>city</td>
	<td>zone</td>
	<td>country</td>
	<td>rent</td>
	<td>account</td>
	<td>isdelete</td>
	<td>operation</td>
</tr>
<c:forEach items="${hospitalList }" var="hospital">
<tr>
	<td>${hospital.hid }</td>
	<td>${hospital.hname }</td>
	<td>${hospital.province }</td>
	<td>${hospital.city }</td>
	<td>${hospital.zone }</td>
	<td>${hospital.country }</td>
	<td>${hospital.rent }</td>
	<td>${hospital.account }</td>
	<td>${hospital.isdelete==0?'正常':'已删除' }</td>
	<td>
	<a href="${hospital.isdelete==1?'revoke':'delete' }?hid=${hospital.hid }">
	${hospital.isdelete==1?'恢复':'删除' }
	</a>
	|
	<a href="goUpdate?hid=${hospital.hid }">update</a>
	</td>
</tr>
</c:forEach>
</table>
<button><a href="goSave">save<a></button>
</body>
</html>