<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="save" method="post">
<input type="hidden" name="bid">
选择厂家:<c:forEach items="${factorys }" var="factory">
			<input type="radio" name="fid" value="${factory.fid }">
			${factory.fname }
		</c:forEach><br>
选择股东:<c:forEach items="${shareholders }" var="shareholder">
			<input type="radio" name="uid" value="${shareholder.uid }">
			${shareholder.userinfo.uname }
		</c:forEach><br>
床位编号:<input type="text" name="bnum"><br>
设备厂家联系人:<input type="text" name="productorconnectname"><br>
选择医院：
		<select>
			<c:forEach items="${hospitals }" var="hospital">
			<option value="hospital.hid">${hospital.hname }</option>
			</c:forEach>
		</select><br>
选择科室：
<input type="submit" value="save"><br>
</form>
</body>
</html>