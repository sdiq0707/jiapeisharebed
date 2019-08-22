<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<script>
	$.ajaxSetup({
			global:true,
			type:"POST",
			async:false,
			cache:false
		});
	var hs;
	var as;
	$(function(){
			$.ajax({
					url:"findHospital",
					dataType:"json",
					success:function(msg){
							hs=msg;
							fillP();
						}
				});
		});

	function fillP(){
			$.each(hs,function(i,item){
					$("#h").append("<option value="+i+">"+item.hname+"</option>");
				});
				fillA(0);
		}
		function fillA(index){
				$("#a").empty();
				as = hs[index].administrative;
				$.each(as,function(i,item){
					$("#a").append("<option value="+i+">"+item.aname+"</option>");
				});
			}
</script>
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
选择医院：<select id="h" name="hid" onchange="fillA(this.value)"></select>
选择科室：<select id="a" name="aid" ></select>
<input type="submit" value="save"><br>
</form>
</body>
</html>