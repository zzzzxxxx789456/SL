<%--
  Created by IntelliJ IDEA.
  User: 61048
  Date: 2019/10/22
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载中心</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<div class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <jsp:include page="/pages/fragment/header.jsp"></jsp:include>
        <jsp:include page="/pages/fragment/left-nav.jsp"></jsp:include>
        <div class="layui-body">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>新世紀新品发布会花絮介绍</legend>
            </fieldset>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <a href="${ctx}/pages/images/南澳.jpg" download="南澳景色">
                        <span>下载</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</html>
