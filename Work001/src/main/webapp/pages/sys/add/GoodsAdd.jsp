<%--
  Created by IntelliJ IDEA.
  User: 15219
  Date: 2019/10/23
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>新增商品</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/pages/fragment/header.jsp"></jsp:include>
    <jsp:include page="/pages/fragment/left-nav.jsp"></jsp:include>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="${ctx}/sys/g/add" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">商品名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="goodsName"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">商品编号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="goodsSn"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">市场价：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="marketPrice"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">优惠价：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="realPrice"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">库存：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="num"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">单位：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="unit"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">状态：</label>
                    <div class="layui-input-block">
                        <input type="radio" name="state" id="state" value="1" title="上架">
                        <input type="radio" name="state" id="state" value="2" title="下架">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">商品规格：</label>
                    <div class="layui-input-block">
                        <textarea name="goodsFormat" placeholder="请输入内容" class="layui-textarea"></textarea>
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
    layui.use(['element','form'], function(){
        var element = layui.element;
        var form = layui.form;
        $.ajax({
            dataType: "json",
            success: function (data) {
                $("input[name=state][value=1]").attr("checked", data.state == 1 ? true : false);
                $("input[name=state][value=2]").attr("checked", data.state == 2 ? true : false);
                form.render(); //更新全部
            }
        })
    });
</script>
</body>
</html>
