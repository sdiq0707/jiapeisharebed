<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑科室</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="app">
	<h4>编辑科室</h4>
	<form id="ff" action="update" method="post">
		<input type="hidden" name="aid" v-model="json.administrative.aid" id="aid"/>
 		科室名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="json.administrative.aname" name="aname" placeholder="请输入科室名称" size=20/><br> 
		请选择所属医院:
			<select v-model="hid" name="hid">
				<option :value="hospital.hid" v-for="hospital in hospitals">{{hospital.hname}}</option>
			</select>
		<br>
		软删除:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" v-model="json.administrative.isdelete" name="isdelete" placeholder="请输入0或1" size=20/><br> 
		<button class="btn btn-danger" type="reset">取消</button>
		<button class="btn btn-success" type="submit">保存</button>
	</form>
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
	
	var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
		var vm = new Vue({
			el:'#app',
			data:{
				json:'',
				hospitals:'',
				hid:''
			},
			mounted:function(){
		        this.get();
		    },
			methods:{
				get:function(){
					this.$http({
						method:'post',
						emulateJSON:true,//post方式提交，若有中文，必须加,转换其提交格式
						url:'findById', 
						params:{
							aid:theRequest.aid
						},
					}).then(function(res){
						this.json=res.body;
// 						this.hid = this.json.administrative.hospital.hid;
						this.hospitals=this.json.hospitals;
					},function(){
						console.log('请求失败处理');
					});
				}
			}
		});
	}
</script>