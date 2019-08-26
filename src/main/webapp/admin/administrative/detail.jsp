<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科室详情</title>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h5>科室信息</h5>
	<div class="ui-grid-b" style="width: 80%">
		<div class="ui-block-a">医院名称 ： ${hospital.hname }</div>
		<div class="ui-block-b">科室名称： ${administrative.aname }</div>
		<div class="ui-block-c">银行卡号 ：${hospital.account }</div>
	</div>
<HR align=center width=100% color=#987cb9 SIZE=1>
<h5>床位信息</h5>
<%-- 	<div class="ui-block-a">床位总数：${ }</div> --%>
	<div class="ui-grid-b" style="width: 80%">
		<div class="ui-block-a">医院名称 ： ${hospital.hname }</div>
		<div class="ui-block-b">科室名称： ${administrative.aname }</div>
		<div class="ui-block-c">银行卡号 ：${hospital.account }</div>
	</div>
</body>
</html>