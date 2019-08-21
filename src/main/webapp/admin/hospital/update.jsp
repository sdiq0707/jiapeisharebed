<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改医院</title>
</head>
<body>
<form action="update" method="post">
    <input type="hidden" name="hid" value="${hospital.hid }" /><br/>
	医院名称：<input type="text" name="hname" value="${hospital.hname }" /><br/>
	所属省份：<input type="text" name="province" value="${hospital.province }"/><br/>
	所属城市：<input type="text" name="city" value="${hospital.city }"/><br/>
	所属地区：<input type="text" name="zone" value="${hospital.zone }"/><br/>
	所属县：<input type="text" name="country" value="${hospital.country }"/><br/>
	医院租金：<input type="text" name="rent" value="${hospital.rent }"/><br/>
	医院账户：<input type="text" name="account" value="${hospital.account }" /><br/>
	软删除：<input type="text" name=isdelete value="${hospital.isdelete }"/><br/>
<button type="submit">update</button><br/>
</form>
</body>
</html>