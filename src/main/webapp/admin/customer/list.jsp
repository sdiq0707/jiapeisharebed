<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
	<div id="app">
	<h3>用户管理/用户</h3>
			uname<INPUT TYPE="text" NAME="uname" v-model="uname">
			action<INPUT TYPE="text" v-model="action" NAME="action">
			<input type="button" @click="get()" value="Query">
			
			<TABLE border="1px" width="100%">
				<TR>
					<TD>logid</TD>
					<TD>uid</TD>
					<TD>action</TD>
					<TD>actiontime</TD>
					<TD>uname</TD>
				</TR>
				
					<TR v-for="log in json.list">
						<TD>{{log.logid}}</TD>
						<TD>{{log.uid}}</TD>
						<TD>{{log.action}}</TD>
						<TD>{{log.actiontime}}</TD>
						<TD>{{log.uname}}</TD>
					</TR>
			</TABLE>
			<TABLE border="1" width="100%">
				<TR>
					<TD><button @click="first()">First</button></TD>
					<TD><button @click="next()">Next</button></TD>
					<TD><button @click="before()">Before</button></TD>
					<TD><button @click="end()">End</button></TD>
					<TD>第<INPUT TYPE="text" NAME="pageNow" id="pageNow"
						v-model="pageNow" size="1">页 
						每页<INPUT TYPE="text" NAME="limit" v-model="limit" size="1">条 
						{{json.page.pageNow}}/{{json.page.pageCount}}
						共{{json.page.count}}条
						<input type="button" @click="get()" value="go"></TD>
				</TR>
			</TABLE>
	</div>
</body>
</html>
<script>
	window.onload = function(){
	    var vm = new Vue({
	        el:'#app',
	        data:{
	            json:'',
	            pageNow:1,
	            limit:10,
	            uname:'',
	            action:''
	        },
	        mounted:function(){
	        	this.get();
	        },
	        methods:{
	            get:function(){
	            	this.$http({
	                	method:'post',
	                	url:'findJSON',
	                	emulateJSON:true, 
	                	params:{
	                		pageNow:this.pageNow,
	                		limit:this.limit,
	                		uname:this.uname,
	                		action:this.action
	                	},	
	                }).then(function(res){
	                	 this.json=res.body;
	                },function(){
	                    console.log('请求失败处理');
	                });
	            },
	            first:function(){
	            	this.pageNow = 1;
	            	this.get();
	            },
	            next:function(){
		            if(parseInt(this.pageNow)>=this.json.page.pageCount){
	            		this.pageNow = this.json.page.pageCount;
			        }else {
			        	this.pageNow = parseInt(this.pageNow)+1;
				    }
	            	this.get();
	            },
	            before:function(){
	            	if(parseInt(this.pageNow)<=1){
	            		this.pageNow = 1;
			        }else {
			        	this.pageNow = parseInt(this.pageNow)-1;
				    }
	            	this.get();
	            },
	            end:function(){
	            	this.pageNow = this.json.page.pageCount;
	            	this.get();
	            }
	        }
	    });
	}
</script>