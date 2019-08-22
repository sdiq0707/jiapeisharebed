<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

省：
<select id="p" name="" onchange="fillC(this.value)">

</select>

市：
<select id="c" name="" onchange="fillZ(this.value)">

</select>

区：
<select id="z" name="">

</select>