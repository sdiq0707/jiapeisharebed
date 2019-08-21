<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
		$.ajaxSetup({
			global:true,
			type:"post",
			async:false,
			cache:false

		});

		var ps;
		var cs;
		
		$(function(){
			$.ajax({
				url:"findProvince",
				dataType:"json",
				success: function(msg){
					ps=msg;
					fillP();
				}
			});
		});
		
	

	function fillP(){
		$.each(ps,function(i,item){
			$("#p").append("<option value="+i+">"+item.pname+"</option>");
		});
		fillC(0);
	}	

	function fillC(index){
		$("#c").empty();
		cs=ps[index].citys;
		$.each(cs,function(i,item){
			$("#c").append("<option value="+i+">"+item.cname+"</option>");
		});
		fillZ(0);
	}	

	function fillZ(index){
		$("#z").empty();
		var zs=cs[index].zones;
		$.each(zs,function(i,item){
			$("#z").append("<option value="+i+">"+item.zname+"</option>");
		});
	}			
	
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加医院</title>
</head>
<body>
<form action="save">
	医院名称：<input type="text" name="hname" /><br/>
	所属省份：<select id="p"  name="province"  onchange="fillC(this.value)">
			</select>
						
	所属城市：<select id="c" name="city" onchange="fillZ(this.value)">
			</select>
	所属地区：<select id="z" name="zone">
			</select>
	所属县：<input type="text" name="country" /><br/>
	医院租金：<input type="text" name="rent" /><br/>
	医院账户：<input type="text" name="account" /><br/>
	软删除：<input type="text" name=isdelete /><br/>
<button type="submit">save</button><br/>
</form>
</body>
</html>