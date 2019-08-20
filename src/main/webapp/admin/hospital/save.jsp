<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加医院</title>
</head>
<body>
<form action="save">
	医院名称：<input type="text" name="hname" /><br/>
	所属省份：<input type="text" name="province" /><br/>
	所属城市：<input type="text" name="city" /><br/>
	所属地区：<input type="text" name="zone" /><br/>
	所属县：<input type="text" name="country" /><br/>
	医院租金：<input type="text" name="rent" /><br/>
	医院账户：<input type="text" name="account" /><br/>
	软删除：<input type="text" name=isdelete /><br/>
<button type="submit">save</button><br/>
</form>
</body>
</html>