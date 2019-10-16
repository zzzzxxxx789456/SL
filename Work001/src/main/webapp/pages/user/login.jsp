<%--
  Created by IntelliJ IDEA.
  User: 61048
  Date: 2019/10/15
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    < <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
        <input type="password" name="password" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <div class="layui-input-block">
        <input  type="submit" class="layui-btn" id="savePwd" lay-submit lay-filter="formDemo" value="登录">
    </div>
</div>
</form>
</div>

<div class="layui-footer">

    <%--<jsp:include page="/pages/fragment/header.jsp"></jsp:include>--%>
    <jsp:include page="/pages/fragment/left-nav.jsp"></jsp:include>



    <div class="layui-body">
        <!-- 内容主体区域 -->
    <div style="padding: 15px;">
        <form class="layui-form" action="${ctx}/u/login" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">登录账号</label>
                <div class="layui-input-block">
                    <input type="text" name="loginCode" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                -->
                © layui.com - 底部固定区域
            </div>
    </div>
    <script src="${ctx}/layui/layui.js"></script>
    <script>
        //JavaScript代码区域
        layui.use(['element','form','jquery'], function(){
            var element = layui.element;
            var form = layui.form;
            var $ = layui.jquery;

            $('#savePwd').click(function () {
                alert(12)
            })

        });
    </script>
</body>
</html>