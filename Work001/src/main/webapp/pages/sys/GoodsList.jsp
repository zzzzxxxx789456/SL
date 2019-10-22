<%--
  Created by IntelliJ IDEA.
  User: 15219
  Date: 2019/10/17
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>商品管理</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <script src="${ctx}/layui/layui.js"></script>
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
    <jsp:include page="/pages/fragment/header.jsp"></jsp:include>
    <jsp:include page="/pages/fragment/left-nav.jsp"></jsp:include>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <a href="${ctx}/sys/g/to/add" class="layui-btn">新增</a>
            <form class="layui-form">
                <div class="layui-form-item" >
                    <div class="layui-input-block">
                        <input type="text" name="goodsName" required  lay-verify="required" placeholder="请输入关键字" autocomplete="off" class="layui-input">
                        <input type="button" value="查询" class="layui-btn" id="queryBtn">
                    </div>
                </div>
            </form>
            <table class="layui-hide" id="demo" lay-filter="test" ></table>
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
            <script type="text/html" id="toolbarDemo">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">删除选中项</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
                </div>
            </script>
            <script type="text/html" id="checkboxTpl">
                <input type="checkbox" name="state" id="state" value="{{d.state}}" {{ d.state == 1 ? 'checked' : '' }}>
            </script>
        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © layui.com - 底部固定区域
        </div>
    </div>

    <script>
        //JavaScript代码区域
        layui.use(['element','form','table','jquery','layer'], function(){
            var element = layui.element;
            var form = layui.form;
            var table = layui.table;
            var $ = layui.jquery;
            var layer = layui.layer;

            renderTable();
            //第一个实例
            function renderTable(){
                table.render({
                    elem: '#demo'
                    ,url: '${ctx}/sys/g/list' //数据接口
                    ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
                    ,page: true //开启分页
                    ,cols: [[ //表头
                        {type: 'checkbox', fixed: 'left'}
                        ,{field: 'goodsName', title: '商品名称', width:180, sort: true, fixed: 'left'}
                        ,{field: 'marketPrice', title: '市场价（元）', width:180, sort: true, fixed: 'left'}
                        ,{field: 'realPrice', title: '优惠价（元）', width:180, sort: true, fixed: 'left'}
                        ,{field: 'num', title: '库存', width:180, sort: true, fixed: 'left'}
                        ,{field: 'lastUpdateTime', title: '最后修改时间', width:280, sort: true, fixed: 'left'}
                        ,{field:'state', title:'状态(上架/下架)', width:150, templet: '#checkboxTpl', unresize: true}
                        ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
                    ]]
                });
            }
            var state = $("#state").val();
            if (state == "1") {
                $("#state").attr("checked",true);
            } else {
                $("#state").attr("checked",false);
            }

            //头工具栏事件
            table.on('toolbar(test)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                switch(obj.event){
                    case 'getCheckData':
                        var data = checkStatus.data;
                        var ids = [];
                        for(var i = 0 ; i < data.length ; i++) {
                            ids.push(data[i].id);
                        }
                        var data = {
                            "ids":ids
                        }
                        $.ajax({
                            url:'${ctx}/sys/g/delGroup',
                            type:'post',
                            contentType:'application/json',
                            data:JSON.stringify(data),
                            success:function (data) {
                                renderTable();
                                layer.msg(data.msg)
                            }
                        })

                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：'+ data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选': '未全选');
                        break;

                    //自定义头工具栏右侧图标 - 提示
                    case 'LAYTABLE_TIPS':
                        layer.alert('这是工具栏右侧自定义的一个图标按钮');
                        break;
                };
            });

            //监听行工具事件
            table.on('tool(test)', function(obj){
                var data = obj.data;
                //console.log(obj)
                if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        // 异步请求删除
                        $.ajax({
                            url: "${ctx}/sys/g/del",
                            type: "POST",
                            data:{id:data.id},
                            success: function (msg) {
                                if(data.id === "0"){
                                    layer.msg("删除失败")
                                } else {
                                    obj.del();
                                    renderTable();
                                    layer.msg("删除成功");
                                    layer.close(index);
                                }
                            }
                        });

                    });
                } else if(obj.event === 'edit'){

                }
            });


            // 添加查询事件
            $('#queryBtn').click(function () {
                var goodsName = $('input[name=goodsName]').val();
                table.render({
                    elem: '#demo'
                    ,url: '${ctx}/sys/g/list' //数据接口
                    ,page: true //开启分页
                    ,cols: [[ //表头
                        {type: 'checkbox', fixed: 'left'}
                        ,{field: 'goodsName', title: '商品名称', width:180, sort: true, fixed: 'left'}
                        ,{field: 'marketPrice', title: '市场价（元）', width:180, sort: true, fixed: 'left'}
                        ,{field: 'realPrice', title: '优惠价（元）', width:180, sort: true, fixed: 'left'}
                        ,{field: 'num', title: '库存', width:180, sort: true, fixed: 'left'}
                        ,{field: 'lastUpdateTime', title: '最后修改时间', width:280, sort: true, fixed: 'left'}
                        ,{field:'state', title:'状态(上架/下架)', width:150, templet: '#checkboxTpl', unresize: true}
                        ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
                    ]],
                    where:{
                        goodsName:goodsName
                    }
                });
            })
        });
    </script>
</body>
</html>
