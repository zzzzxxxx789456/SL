<%--
  Created by IntelliJ IDEA.
  User: 15219
  Date: 2019/10/23
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>新增角色</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/pages/fragment/header.jsp"></jsp:include>
    <jsp:include page="/pages/fragment/left-nav.jsp"></jsp:include>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="${ctx}/sys/gp/add" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">套餐名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="goodsPackName"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">编号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="goodsPackCode"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">套餐类型：</label>
                    <div class="layui-input-inline">
                        <select name="typeId" lay-verify="">
                            <option value="0">请选择</option>
                            <c:forEach items="${packTypes}" var="obj">
                                <option value="${obj.id}">${obj.typeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">状态：</label>
                    <div class="layui-input-block">
                        <input type="radio" name="isStart" id="state" value="1" title="启用">
                        <input type="radio" name="isStart" id="state" value="2" title="弃用">
                    </div>
                </div>
                <div class="layui-form-item">
                <form class="layui-form">
                    <div class="layui-form-item" >
                        <div class="layui-input-block">
                            <input type="text" name="goodsName" required  lay-verify="required" placeholder="请输入关键字" autocomplete="off" class="layui-input">
                            <input type="button" value="查询" class="layui-btn" id="queryBtn">
                        </div>
                    </div>
                </form>
                <table class="layui-hide" id="demo" lay-filter="test" ></table>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">总价：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="totalPrice" id="total_price"  lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">库存数量：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="num" lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">商品说明：</label>
                    <div class="layui-input-block">
                        <textarea name="note" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="${ctx}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','form','table','jquery','layer'], function(){
        var element = layui.element;
        var form = layui.form;
        var table = layui.table;
        var $ = layui.jquery;
        var layer = layui.layer;
        $.ajax({
            dataType: "json",
            success: function (data) {
                $("input[name=isStart][value=0]").attr("checked", data.isStart == 0 ? true : false);
                $("input[name=isStart][value=1]").attr("checked", data.isStart == 1 ? true : false);
                form.render(); //更新全部
            }
        })
        renderTable();
        //第一个实例
        function renderTable(){
            table.render({
                elem: '#demo'
                ,url: '${ctx}/sys/g/gpList' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {type: 'checkbox', fixed: 'left'}
                    ,{field: 'goodsName', title: '商品名称', width:180, sort: true, fixed: 'left'}
                    ,{field: 'marketPrice', title: '市场价（元）', width:180, sort: true, fixed: 'left'}
                    ,{field: 'realPrice', title: '优惠价（元）', width:180, sort: true, fixed: 'left'}
                    ,{field: 'num', title: '库存', width:180, sort: true, fixed: 'left'}
                    ,{field: 'amount', title: '数量', width:180, sort: true, fixed: 'left', edit: 'text'}
                    ,{field:'orderPrice',width:135 , title:'订单价格' ,templet: function(d){
                            return  parseInt(d.realPrice)*parseInt(d.amount)}}
                ]]
                ,done: function(res, curr, count){
                    //如果是异步请求数据方式，res即为你接口返回的信息。
                    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                    var total_price = 0;
                    for( i=0;i<count;i++){
                        total_price = parseInt(res.data[i].goods_price)*parseInt(res.data[i].amount)+total_price;
                    }
                    layer.msg(total_price);
                    $("#total_price").val(total_price);
                    //得到当前页码
                    console.log(curr);
                }
            });
        }
        //监听单元格编辑
        table.on('edit(test3)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
        });
    });
</script>
</body>
</html>
