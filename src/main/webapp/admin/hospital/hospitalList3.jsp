<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>医院管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		$('#dg').datagrid({   
		    url:'findAll',
		    fitColumns:true,
		    striped:true,
		    pageSize:20,
		    height:500,
		    pagination:true,
		    title:'医院管理',
		    toolbar: '#tb',
		    columns:[[   
		        {field:'hid',title:'hid',width:100},   
		        {field:'hname',title:'hname',width:100},   
		        {field:'province',title:'province',width:100,align:'center'},   
		        {field:'city',title:'city',width:100,align:'center'},   
		        {field:'zone',title:'zone',width:100,align:'center'},   
		        {field:'country',title:'country',width:100,align:'center'},   
		        {field:'rent',title:'rent',width:100,align:'center'},   
		        {field:'account',title:'account',width:100,align:'center'},   
		        {field:'isdelete',title:'isdelete',width:100,align:'center',formatter: function(value,row,index){
					if (row.isdelete){
						return '已删除';
					} else {
						return '正常';
					}
				}
			        }, 
			    {field:'hresper',title:'医院对接人',width:100,align:'center'},    
		        {field:'operate',title:'operate',width:100,align:'center',formatter: function(value,row,index){
		        	if (!row.isdelete){
			        	var btns="<a id=\"btn\" href=\"javascript:deleteById("+row.hid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>";
							btns+="<a id=\"btn\" href=\"javascript:findById("+row.hid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>";
		        		return btns;
					} else {
						var btns="<a id=\"btn\" href=\"javascript:revokeById("+row.hid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-undo'\">恢复</a>";
							btns+="<a id=\"btn\" href=\"javascript:findById("+row.hid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>";
						return btns;
					}
					
				}
			        }
			    
		    ]],
		    onLoadSuccess: function(index,field,value){
				$('.easyui-linkbutton').linkbutton({   
				});  
			}     
		});
		
	})
	function deleteById(hid){
		$.messager.confirm('Confirm','Are you sure you want to delete record?',function(r){   
		    if (r){   
		    	$.getJSON("delete",{hid:hid},function(json){
		    		$.messager.show({
		    			title:'My Title',
		    			msg:json.msg,
		    			timeout:5000,
		    			showType:'slide'
		    		});
						$('#dg').datagrid('reload');    // reload the current page data 
					});
				}  
			  
			}); 
	} 
			
	function revokeById(hid){
		$.messager.confirm('Confirm','Are you sure you want to revoke record?',function(r){   
		    if (r){   
		    	$.getJSON("revoke",{hid:hid},function(json){
					$.messager.show({
		    			title:'My Title',
		    			msg:json.msg,
		    			timeout:5000,
		    			showType:'slide'
		    		});
						$('#dg').datagrid('reload');    // reload the current page data 
					});
				}  
			  
			}); 
		}
	function openForm(){
		$('#ff').form('clear');	
		$('#win').window('open');  // open a window 
	}
	function dosave(){
		var hid=$("#hid").val();
		var path="save";
		if(hid!=null&&hid!=""&&hid!=undefined){
			path="update";
			}
		$('#ff').form('submit', {   
		    url:path,   
		    onSubmit: function(){   
		        // do some check   
		        // return false to prevent submit;   
		    },   
		    success:function(data){   
		        var json=eval("("+data+")");
		        $.messager.show({
	    			title:'My Title',
	    			msg:json.msg,
	    			timeout:5000,
	    			showType:'slide'
	    		});
		        	$('#win').window('close'); 
					$('#dg').datagrid('reload');    // reload the current page data 
		    }   
		});  
	} 
	 function findById(hid){
		 $('#ff').form('clear');	
		$('#win').window('open');  // open a window 
			 $.getJSON("findById",{hid:hid},function(json){
				$('#ff').form('load',json);	// 从URL加载
			});
	}
	 $('#ss').searchbox({   
		    searcher:function(value,name){   
		        alert(value + "," + name)   
		    },   
		    menu:'#mm',   
		    prompt:'Please Input Value'  
		});  
</script>
<script>
	$.ajaxSetup({
			global:true,
			type:"POST",
			async:false,
			cache:false
		});
	var hm;
	$(function(){
			$.ajax({
					url:"findHospitalManager",
					dataType:"json",
					success:function(msg){
							hm=msg;
							alert(hm);
						}
				});
		});
	</script>
</head>
<body>
<table id="dg"></table>

<div id="tb">
	<a href="javascript:openForm()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">增加</a>
</div>


 <div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"  
        data-options="iconCls:'icon-save',modal:true,closed:true">  
		  <form id="ff" method="post">
		<input type="hidden" name="hid" id="hid" /><br/>
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
		医院对接人：<SELECT id="hs" NAME="hresper">
						<option v-for="h in persons">{}</option>
				</SELECT><br/>
		医院租金：<input type="text" name="rent" /><br/>
		医院账户：<input type="text" name="account" /><br/>
		软删除：<input type="text" name=isdelete /><br/>
<button type="button" onclick="dosave()">save</button><br/>
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
	                	url:'findProvince2',
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
