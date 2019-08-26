<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String tid = request.getParameter("tid");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>故障管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<h1>hahaha <%= tid %></h1>
<div id="p" class="easyui-panel" title="My Panel"
    style="width:500px;height:150px;padding:10px;background:#fafafa;"
    data-options="iconCls:'icon-save',closable:true,
    collapsible:true,minimizable:true,maximizable:true">
    <p>panel content.</p>
    <p>panel content.</p>
</div>
</body>
</html>