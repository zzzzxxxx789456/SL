<%--
  Created by IntelliJ IDEA.
  User: 15219
  Date: 2019/10/23
  Time: 13:34
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
            <form class="layui-form" action="${ctx}/sys/r/add" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">角色编号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="roleCode"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">角色名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="roleName"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">角色状态：</label>
                    <div class="layui-input-block">
                        <input type="radio" name="isStart" id="isStart" value="1" title="启用">
                        <input type="radio" name="isStart" id="isStart" value="0" title="弃用">
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
                $("input[name=isStart][value=0]").attr("checked", data.isStart == 0 ? true : false);
                $("input[name=isStart][value=1]").attr("checked", data.isStart == 1 ? true : false);
                form.render(); //更新全部
            }
        })
    });
</script>
</body>
</html>
