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
厂家编号:<input type="text" name="fid"><br>
选择股东:<c:forEach items="${shareholders }" var="shareholder">
			<input type="radio" name="chk" value="${shareholder.uid }">
			${shareholder.userinfo.uname }
		</c:forEach><br>
床位编号:<input type="text" name="bnum"><br>
设备厂家名称:<input type="text" name="productor"><br>
设备厂家联系人:<input type="text" name="productorconnectname"><br>
厂家联系电话:<input type="text" name="productorphone"><br>
医院科室编号:<input type="text" name="fkid"><br>
<input type="submit" value="save"><br>
</form>
</body>
</html>