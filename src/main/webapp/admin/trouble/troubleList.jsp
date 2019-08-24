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
    <title>故障管理</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
    <script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
<table id="dg"></table>


<div id="tb">
    <a href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">增加</a>
</div>


<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"
     data-options="iconCls:'icon-save',modal:true,closed:true">
    <form id="form" method="post">
        <input hidden="hidden" name="tid" >
        故障标题：<input  type="text" name="ttitle"/><br/>
        故障描述：<input type="text" name="tdescribe"/><br/>
        故障类型：<input type="text" name="ttype"/><br/>
        申报人：<input type="text" name="tdeclarant"/><br/>
        申报人电话：<input type="text" name="declarantphone"/><br/>
        故障时间：<input id="dd" type="text" name="tdeclaretime" class="easyui-datebox" required="required"/><br/>
        床位号：
        <div id="app">
            <SELECT id="p" NAME="bid">
            <option v-for="p in json">{{p.bid}}</option>
        </SELECT>
        </div>
        <button type="button" onclick="sub()">save</button>
        <br/>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    var formflag='';
    $(function () {
        $('#dg').datagrid({
            url: 'findAll',
            fitColumns: true,
            striped: true,
            pagination: true,
            title: '故障管理',
            toolbar: '#tb',
            columns: [[
                {field: 'tid', title: '故障号', width: 100},
                {field: 'ttitle', title: '故障标题', width: 100},
                {field: 'tdescribe', title: '故障描述', width: 100, align: 'center'},
                {field: 'ttype', title: '故障类型', width: 100, align: 'center'},
                {field: 'tdeclarant', title: '申报人', width: 100, align: 'center'},
                {field: 'declarantphone', title: '申报人电话', width: 100, align: 'center'},
                {
                    field: 'tstatus',
                    title: '故障状态',
                    width: 100,
                    align: 'center',
                    formatter: function (value, row, index) {
                        if (row.tstatus) {
                            return '已备案';
                        } else {
                            return '修复中';
                        }
                    }

                },
                {field: 'tdeclaretime', title: '故障时间', width: 100, align: 'center'},
                {field: 'bid', title: '床位号', width: 100, align: 'center'},
                {
                    field: 'isdeclare',
                    title: '是否申报',
                    width: 100,
                    align: 'center',
                    formatter: function (value, row, index) {
                        if (row.isdeclare) {
                            return '已申报';
                        } else {
                            return '未申报';
                        }
                    }
                },
                {
                    field: 'isdelete',
                    title: '是否删除',
                    width: 100,
                    align: 'center',
                    formatter: function (value, row, index) {

                        if (row.isdelete) {
                            return '已删除';
                        } else {
                            return '正常';
                        }
                    }
                },
                {
                    field: 'operate',
                    title: 'operate',
                    width: 100,
                    align: 'center',
                    formatter: function (value, row, index) {
                        if (!row.isdelete) {

                            var btns = "<a id=\"btn\" href=\"javascript:deleteById(" + row.tid + ")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>";
                            btns += "<a id=\"btn2\" href=\"javascript:updateById(" + row.tid + ")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>";
                            return btns;
                        } else {
                            var btns = "<a id=\"btn\" href=\"javascript:revokeById(" + row.tid + ")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-undo'\">恢复</a>";
                            btns += "<a id=\"btn2\" href=\"javascript:updateById(" + row.tid + ")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>";
                            return btns;
                        }

                    }
                }

            ]],
            onLoadSuccess: function (index, field, value) {
                $('.easyui-linkbutton').linkbutton({});
            }
        });

    })

    function deleteById(tid) {
        $.messager.confirm('Confirm', '真的要删除吗?', function (r) {
            if (r) {
                $.getJSON("deleteById", {tid: tid}, function (json) {
                    $.messager.show({
                        title: 'My Title',
                        msg: json.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });
                    $('#dg').datagrid('reload');
                });
            }

        });
    }

    function revokeById(tid) {
        $.messager.confirm('Confirm', '真的要恢复吗?', function (r) {
            if (r) {
                $.getJSON("revokeById", {tid: tid}, function (json) {
                    $.messager.show({
                        title: 'My Title',
                        msg: json.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });
                    $('#dg').datagrid('reload');    // reload the current page data
                });
            }

        });
    }

    function openForm() {
        $('#win').window('open');
    }
    function add(){
        openForm();
        $('#win').panel({title: "新增故障"});
        formflag='add';
        dosth();

    }
    function updateById(tid){
        openForm();
        $('#win').panel({title: "编辑故障"});
        formflag='update';
        dosth(tid);

    }
var url='';
    function dosth(tid) {
        if(formflag==='update'){
            $.post("findByTid",{tid:tid},function(data){
                $("#form input").each(function (i, item) {
                    var name = $(item).attr("name");
                    $(item).val(data[name]);
                })
                $("#form select").each(function (i, item) {
                    var name = $(item).attr("name");
                    for (var key in data) {
                        if (name == key) {
                            $(item).find("option").each(function (i, option) {
                                if ($(option).val() == data[name]) {
                                    $(option).prop("selected", true);
                                }
                            })
                        }
                    }
                })

            });
            url='updateById';
        }else {
            url='save';
            $("#form input").empty();
        }

    }

    function sub() {

        $('#form').form('submit', {

            url: url,
            onSubmit: function () {
                // do some check
                // return false to prevent submit;
            },
            success: function (data) {
                var json = eval("(" + data + ")");
                $.messager.show({
                    title: 'My Title',
                    msg: json.msg,
                    timeout: 5000,
                    showType: 'slide'
                });
                $('#win').window('close');
                $('#dg').datagrid('reload');    // reload the current page data
            }
        });
    }


</script>
<script>
    window.onload = function () {
        var vm = new Vue({
            el: '#app',
            data: {
                json: '',
                beds:'',
            },
            mounted: function () {
                this.fillP();
            },
            methods: {
                fillP: function () {
                    this.$http({
                        method: 'post',
                        url: 'findAllBed',
                        emulateJSON: true,
                        params: {},
                    }).then(function (res) {
                        this.json = res.body;
                    }, function () {
                        console.log('请求失败处理');
                    });
                },

            }
        });

    }


</script>