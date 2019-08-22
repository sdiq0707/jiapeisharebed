<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加医院</title>
</head>
<body>
<form action="save" method="post">
	医院名称：<input type="text" name="hname" /><br/>
	<div id="app">
	所属省份：<SELECT id="p" NAME="province" v-on:change="fillC($event.target.selectedIndex)" >
			<option  v-for="p in json">{{p.pname}}</option>
			</SELECT>
						
	所属城市：<SELECT id="c" NAME="city" @change="fillZ($event.target.selectedIndex)">
			<option v-for="c in citys">{{c.cname}}</option>
			</SELECT>
	所属地区：<SELECT id="z" NAME="zone">
			<option v-for="z in zones">{{z.zname}}</option>
			</SELECT>
	</div>
	所属县：<input type="text" name="country" /><br/>
	医院租金：<input type="text" name="rent" /><br/>
	医院账户：<input type="text" name="account" /><br/>
	软删除：<input type="text" name=isdelete /><br/>
<button type="submit">save</button><br/>
</form>
</body>
</html>
<script>
	window.onload = function(){
	    var vm = new Vue({
	        el:'#app',
	        data:{
	            json:'',
	            citys:'',
	            zones:''
	   	    },
	        mounted:function(){
	        	this.fillP();
	        },
	        methods:{
	        	fillP:function(){
	            	this.$http({
	                	method:'post',
	                	url:'findProvince',
	                	emulateJSON:true, 
	                	params:{
	                	},	
	                }).then(function(res){
	                	 this.json=res.body;
	                	 this.fillC(0);
	                },function(){
	                    console.log('请求失败处理');
	                });
	            },
	            fillC:function(obj){
	            	this.citys = this.json[obj].citys;
	            	this.fillZ(0);
	            },
	            fillZ:function(obj){
	            	this.zones = this.citys[obj].zones;
	            }
	            
	        }
	    });
	}
	
	
</script>