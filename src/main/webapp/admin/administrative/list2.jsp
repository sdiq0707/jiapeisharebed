<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#save").click(function(){
		location.href="goSave";
	});
});
</script>
</head>
<body>
<h3>科室信息</h3>	
<button id="save" class="btn btn-success" >增加科室</button>
	<form action="searchByAid" method="post">
		<font color="red" size="5">aid:</font><input type="text" name="aid"  placeholder="请输入科室编号"/>
		<input type="submit" value="检索"/>
	</form>
<!-- 	<form action="searchByAname" method="post"> -->
<!-- 		aname:<input type="text" name="aname" placeholder="请输入科室名称"/> -->
<!-- 		<input type="submit" value="检索"/> -->
<!-- 	</form> -->
	<hr />
<div id="app">	
		<table class="table table-bordered table-hover table-striped" >
				<tr class="text-center">
					<td>科室编号</td>
					<td>科室名称</td>
<!-- 					<td>所属医院</td> -->
					<td>软删除</td>
					<td>操作</td>
				</tr>
			
				<tr v-for="administrative in json.list" class="text-center">
					<td>{{administrative.aid}}</td>
					<td>{{administrative.aname}}</td>
					<td>{{administrative.isdelete==1?'正常':'已删除'}}</td>
					<td>
						<button class="btn btn-success" @click="findById(administrative.aid)">编辑</button>
						<button class="btn btn-info" v-if="administrative.isdelete==1" @click="delete1(administrative.aid)">删除</button>
						<button class="btn btn-danger" v-if="administrative.isdelete==0" @click="revoke(administrative.aid)">恢复</button>
					</td>
				</tr>
		</table>
			<table class="table table-bordered table-hover table-striped" >	
				<tr colspan="5">
					<td><button class="btn btn-danger" @click="first()">First</button></td>
					<td><button class="btn btn-info" @click="next()">Next</button></td>
					<td><button class="btn btn-success" @click="before()">Before</button></td>
					<td><button class="btn btn-primary " @click="end()">End</button></td>
					第<input type="text" id="pageNow" name="pageNow" v-model="pageNow" size="3"/>页
					每页<input type="text" name="limit" v-model="limit" size="3"/>条记录
					{{json.page.pageNow}}/{{json.page.pageCount}}
					共{{json.page.count}}条记录
					<input type="button" @click="get()" value="go">
				</tr>
			</table>	
</div>	
</body>
</html>
<script >
$.ajaxSetup({
	global:true,
	type:"POST",
	async:false,//表示同步
	cache:false
});
window.onload = function(){
		var vm = new Vue({
			el:'#app',
			data:{
				json:'',
				pageNow:1,
				limit:10,
				aid:'',
				aname:''
			},
			mounted:function(){//服务器启动直接调用的数据
		        this.get();
		    },
			methods:{
				get:function(){
					this.$http({
						method:'post',
						emulateJSON:true,//post方式提交，若有中文，必须加,转换其提交格式
						url:'findJSON', 
						params:{
							pageNow:this.pageNow,
							limit:this.limit,
							aid:this.aid,
							aname:this.aname
						},
					}).then(function(res){
						this.json=res.body;
					},function(){
						console.log('请求失败处理');
					});
				},
				first:function(){
					this.pageNow=1;
					this.get();
				},
				next:function(){
					if(this.pageNow>=this.json.page.pageCount){
						this.pageNow=this.json.page.pageCount;
					} else{
						this.pageNow=parseInt(this.pageNow)+1;
						this.get();
					}
				},
				before:function(){
					if(this.pageNow<=1){
						this.pageNow=1;
					}else{
						this.pageNow=parseInt(this.pageNow)-1;
	 					this.get();
					}
				},
				end:function(){
					this.pageNow=this.json.page.pageCount;
					this.get();
				},
				findById:function(aid){
					window.location.href ="<%=basePath%>admin/administrative/update.jsp?aid="+aid;
				},
				delete1:function(aid){
					window.location.href ="<%=basePath%>admin/administrative/delete?aid="+aid;
				},
				revoke:function(aid){
					window.location.href ="<%=basePath%>admin/administrative/revoke?aid="+aid;
				}
			}
		});
	}
</script>

