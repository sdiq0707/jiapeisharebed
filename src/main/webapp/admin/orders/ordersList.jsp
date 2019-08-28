<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<!-- 	<script>
	$.ajaxSetup({
			global:true,
			type:"POST",
			async:false,
			cache:false
		});
	var hospitals;
	var cs;
	$(function(){
		$.ajax({
			   url: "findAllhospital",
			   dataType:"json",
			   success: function(msg){
				hospitals = msg;
			    fillH(); 
			   }
		});
	});
	function fillH(){
		$.each(hospitals,function(i,hospital){
			
			$("#select-1").append("<option value="+hospital.hid+">"+hospital.hname+"</option>");
		});
		
	}
	function fillA(value){	
		$("#select-2").empty();
		$("#select-2").append("<option value=\"\" selected=\"selected\">-请先选择医院-</option>");
		$.each(hospitals,function(i,hospital){
			var hid=hospital.hid;
			if(hid==value){
				cs = hospital.administrative;
				$.each(cs,function(i,item){
					$("#select-2").append("<option value="+item.aid+">"+item.aname+"</option>");
			});
			}
		});
		
	}
</script> -->
</head>
<body>
<div id="app">
		
		<label class="item item-input">
			<span class="input-label">订单号</span>
			<input name="onum" placeholder="输入订单号"  v-model="onum" maxlength="12" type="text"/>
		</label>

		<div class="ui-field-contain">
			<label for="hid">所属医院</label>
			<select name="hid" id="select-1" v-model="hid" @change="fillA()">
				<option value="" selected="selected" >--请选择医院--</option>
				<option v-for="hostipal in hostipaljson" :value="hostipal.hid"  >{{hostipal.hname}}</option>
			</select>
			<label for="aid"  >所属科室</label>
			<select name="aid" id="select-2" v-model="aid">
				<option value="" selected="selected">-请先选择医院--</option>
			</select>
			<label for="status">订单状态</label>
			<select name="status" id="select-3" v-model="status">
				<option value="" selected="selected">订单状态</option>
				<option value="1">待支付</option>
				<option value="2">进行中</option>
				<option value="4">已完成</option>
				<option value="5">交易关闭</option>
				<option value="6">异常</option>
			</select>
		</div>
		请输入开始时间：<input type="date" placeholder="请输入开始时间"  name="btime" v-model="btime" >
		请输入结束时间：<input type="date" placeholder="请输入结束时间"  name="etime" v-model="etime"><br>
		<button class="btn btn-success" @click="getOrders()" >提交</button>
		<button type="reset" class="btn btn-danger">重置</button>
	<div>
		<h4>共${count }条记录</h4>
	</div>
	
		<table id="table-1" class="table table-sm" style=" text-align: center;">
			<thead>
				<tr>
					<th scope="col">订单号</th>
					<th scope="col">床位编号</th>
					<th scope="col">支付金额</th>
					<th scope="col">支付状态</th>
					<th scope="col">下单时间</th>
					<th scope="col">归还时间</th>
					<th scope="col">支付时间</th>
					<th scope="col">所属医院</th>
					<th scope="col">所属科室</th>
					<th scope="col">用户手机号</th>
					<th scope="col">订单状态</th>				
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
			
				<tr v-for="orders in ordersjson.list">
					<!-- //订单号 -->
					 <th scope="row">{{orders.onum}}</th>
					<!-- 床位编号 -->
					<td>{{orders.actualpay }}</td>
					<!-- 支付金额 -->
					<td>{{orders.actualpay }}</td>
					<!-- 支付状态 -->
					<td>{{orders.paystatus }}</td>
					<!-- 下单时间 -->
					<td>
					{{orders.ordertime }}
					</td>
					<!--归还时间-->
					<td>
					{{orders.returntime }}
					</td>
					<!--支付时间-->
					<td>
					{{orders.paytime }}
					</td>
					<!--所属医院-->
					<td>
						{{orders.bed.hospitaiAdministrative.hospital.hname }}
					</td>
					<!--所属科室-->
					<td>
						{{orders.bed.hospitaiAdministrative.administrative.aname }}
					</td>
					<!--用户手机号-->
					<td>{{orders.cid }}</td>
					<!--订单状态-->
					<td>{{orders.orderstatus }}</td>				
					<td>
					<button @click="details(orders.oid)">详情</button>
						
						|
						<button v-if="orders.isdelete==1" @click="revoke(orders.oid)">
							恢复
						</button>
						<button v-if="orders.isdelete==0" @click="sdelete(orders.oid)">
							删除
						</button>
						
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>

</html>
<script>
	window.onload = function(){
	    var vm = new Vue({
	        el:'#app',
	        data:{
	            ordersjson:'',
	            hostipaljson:'',
	            onum:'',
	            btime:'',
	            etime:'',
	            hid:'',
	    		aid:'',
	    		status:''
	        },
	        mounted:function(){
	        	this.getOrders();
	        	this.getHostipals();
	        },
	        methods:{
	        	getOrders:function(){
	            	this.$http({
	                	method:'post',
	                	url:'findAll',
	                	emulateJSON:true, 
	                	params:{
	                		onum:this.onum,
	        	            btime:this.btime,
	        	            etime:this.etime,
	        	            hid:this.hid,
	        	    		aid:this.aid,
	        	    		status:this.status
	                	},	
	                }).then(function(res){
	                	 this.ordersjson=res.body;
	                	 
	                });
	            },
	            getHostipals:function(){
	            	this.$http({
	                	method:'post',
	                	url:'findAllhospital',
	                	emulateJSON:true, 
	                	params:{
	                		
	                	},	
	                }).then(function(res){
	                	 this.hostipaljson=res.body;
	                	 
	                });
	            },
	            fillA:function(){


		            
	            	
	            		$("#select-2").empty();
	            		$("#select-2").append("<option value=\"\" selected=\"selected\">-请先选择医院-</option>");
	            		$.each(this.hostipaljson,function(i,hostipal){
	            			if(hostipal.hid==this.hid){
	            				 var administratives = hostipal.administrative;
	            				$.each(administratives,function(i,item){
	            					$("#select-2").append("<option value="+item.aid+">"+item.aname+"</option>");
	            				});
	            			}
	            		});
	            		
	            	


		        },
		        details:function(oid){
			        window.location.href="findById?oid="+oid;
		        	/* this.$router.push({
			        	name: "findById",
					    params: {'oid': oid}
				    }); */
			     },
			     revoke:function(oid){
			    	 this.$http({
		                	method:'post',
		                	url:'revoke',
		                	emulateJSON:true, 
		                	params:{
			                	oid:oid
		                	}
		                }).then(function(){
		                	this.getOrders();
			              });
				 },
				 sdelete:function(oid){
			    	 this.$http({
		                	method:'post',
		                	url:'delete',
		                	emulateJSON:true, 
		                	params:{
			                	oid:oid
		                	}
		                }).then(function(){
		                	this.getOrders();
			              });
		             
				 },
			     
	            first:function(){
	            	this.pageNow = 1;
	            	this.get();
	            },
	            next:function(){
	            	this.pageNow = parseInt(this.pageNow)+1;
	            	this.get();
	            },
	            before:function(){
	            	this.pageNow = parseInt(this.pageNow)-1;
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