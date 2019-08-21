<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加科室</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h4>增加科室</h4>
	<form action="${administrative==null?'save':'update'}" method="post">
		<input type="hidden" name="aid" value="${administrative.aid }"/>
		科室名称:<input name="aname" placeholder="请输入科室名称" value="${administrative.aname }"/><br>
		请选择医院:
			<select>
				<c:forEach items="${hospitals}" var="hospital">
						<option name="opt" value="${hospital.hid }">${hospital.hname}</option>
				</c:forEach>
			</select>
		<br>
		软删除：<input name="isdelete" placeholder="请输入0或1" value="${administrative.isdelete }"/><br>
		<button class="btn btn-danger" type="reset">取消</button>  <button class="btn btn-info" type="submit">${administrative==null?'Save':'Update'}</button>
	</form>
</body>
</html>