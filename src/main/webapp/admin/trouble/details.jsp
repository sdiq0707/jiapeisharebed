<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
        src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
String tid = request.getParameter("tid");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>故障管理</title>
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>js/easyui/themes/icon.css">
    <script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript"
            src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

    </script>
</head>
<style>
    .unit {
        border: #95b8e7 1px solid;
        width: 85%;
        height: 300px;
        margin: auto;
        margin-top: 25px;
    }

    .unit div {
        margin-top: 30px;
        width: 100%;
        height: 50px;
    }

    #btn {
        margin-top: 20px;
        margin-left: 625px;
    }

    .titleimg {
        height: 30px;
        margin-left: 20px;
        margin-top: 15px;
        float: left;
    }

    .title {
        font-size: 22px;
        color: #404040;
        float: left;
        margin-left: 15px;
        margin-top: 15px;
    }

    .content {
        font-size: 20px;
        color: #000000;
        float: left;
        margin-left: 50px;
        margin-top: 15px;
    }

    #firstmsg {
        margin-top: 60px;
    }

    #firstbed{
        margin-top: 70px;
    }

</style>
<input hidden="hidden" name="tid" id="id" value="<%=tid%>">
<body>
<h1>
    故障详情
    <%=tid%></h1>
<div id="p" class="easyui-panel" title="<%=tid%>号故障详情"
     style="width: 85%; height: 1020px; padding: 10px; background: rgba(205, 242, 255, 0.19);"
     data-options="iconCls:'icon-filter',closable:true,
    collapsible:true,minimizable:true,maximizable:true">

    <div id="msg" class="unit">
        <img class="titleimg" src="title.png"> <span class="title">故障信息</span>
        <div class="msgfomat" id="firstmsg">
            <span class="content">故障ID:&nbsp;&nbsp;{{p.tid}}</span>
            <span class="content">故障类型:&nbsp;&nbsp;{{p.ttype}}</span>
            <span class="content">故障标题:&nbsp;&nbsp;{{p.ttitle}}</span>
        </div>
        <div class="msgfomat">
            <span class="content">故障描述:&nbsp;&nbsp;{{p.tdescribe}}</span>
            <span class="content">故障状态:&nbsp;&nbsp;{{tstatus}}</span>
            <span class="content">故障申报人:&nbsp;&nbsp;{{p.tdeclarant}}</span>
        </div>
        <div class="msgfomat">
            <span class="content">申报人手机号:&nbsp;&nbsp;{{p.declarantphone}}</span>
            <span class="content">备案时间:&nbsp;&nbsp;{{p.tdeclaretime}}</span>
        </div>

    </div>
    <div id="bed" class="unit">
        <img class="titleimg" src="title.png"> <span class="title">床位信息</span>
        <div class="msgfomat" id="firstbed">
            <span class="content">所在医院:&nbsp;&nbsp;{{b.hospital}}</span>
            <span class="content">所在科室:&nbsp;&nbsp;{{b.administrative}}</span>
            <span class="content">床位ID:&nbsp;&nbsp;{{p2}}</span>
        </div>
    </div>

    <div id="repair" class="unit">
        <img class="titleimg" src="title.png"> <span class="title">维修信息</span>
    </div>

    <a id="btn" href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-remove'">easyui</a>
</div>
</body>
<script>


    //填充信息
    window.onload = function () {

        $.ajaxSetup({
            async: false
        });

        var id = $('#id').val();
        var vm1 = new Vue({
            el: '#msg',
            data: {
                p: '',
                bid: '',
                tstatus: '',
            },
            mounted: function () {
                this.fillP();
            },
            methods: {
                fillP: function () {
                    this.$http({
                        method: 'post',
                        url: 'search?tid=' + id,
                        emulateJSON: true,
                        params: {},
                    }).then(function (res) {
                        this.p = res.body.rows[0];
                        this.bid = res.body.rows[0].bid;
                        if (p.tstatus) {
                            this.tstatus = '已申报'
                        } else {
                            this.tstatus = '正在处理'
                        }
                        this.fillPP(this.bid)
                    }, function () {
                        console.log('请求失败处理');
                    });
                },
                fillPP: function (bid) {
                    var vm2 = new Vue({
                        el: '#bed',
                        data: {
                            p2: '',
                            b: '',
                            beds: '',
                            tstatus: '',
                        },
                        mounted: function () {
                            this.fillP();
                        },
                        methods: {
                            fillP: function () {
                                this.$http({
                                    method: 'post',
                                    url: 'findBedMsg?bid=' + bid,
                                    emulateJSON: true,
                                    params: {},
                                }).then(function (res) {
                                    this.p2 = bid;
                                    this.b = res.body;
                                }, function () {
                                    console.log('请求失败处理');
                                });
                            },

                        }
                    });
                }
            }
        });


    }
</script>
</html>