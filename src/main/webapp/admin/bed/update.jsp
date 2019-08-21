<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<input name="bid" type="hidden" value="${bed.bid }">
厂家编号:<input type="text" name="fid" value="${bed.fid }"><br>
选择股东:<input type="text" name="uid" value="${bed.uid }"><br>
床位编号:<input type="text" name="bnum" value="${bed.bnum }"><br>
设备厂家名称:<input type="text" name="productor" value="${bed.productor }"><br>
设备厂家联系人:<input type="text" name="productorconnectname" value="${bed.productorconnectname }"><br>
厂家联系电话:<input type="text" name="productorphone" value="${bed.productorphone }"><br>
状态:<input type="text" name="bstatus" value="${bed.bstatus }"><br>
是否故障:<input type="text" name="istrouble" value="${bed.istrouble }"><br>
是否删除:<input type="text" name="isdelete" value="${bed.isdelete }"><br>
医院科室编号:<input type="text" name="fkid" value="${bed.fkid }"><br>
<input type="submit" value="update"><br>
</form>
</body>
</html>