<%--
  Created by IntelliJ IDEA.
  User: qiudaozhang
  Date: 2019/10/7
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <%--                layui-nav-itemed--%>
            <li class="layui-nav-item">
                <a class="" href="javascript:;">系统管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/sys/u/to/list">用户管理</a></dd>
<<<<<<< HEAD
                    <dd><a href="${ctx}/role/to/list">角色管理</a></dd>

=======
                    <dd><a href="${ctx}/sys/r/to/list">角色管理</a></dd>
                    <dd><a href="${ctx}">权限管理</a></dd>
                    <dd><a href="${ctx}/sys/g/to/list">商品管理</a></dd>
                    <dd><a href="${ctx}/sys/gp/to/list">商品套餐管理</a></dd>
                    <dd><a href="${ctx}/sys/bp/to/list">基础数据</a></dd>
                    <dd><a href="${ctx}/sys/dd/to/list">数据字典</a></dd>
>>>>>>> 7c779a0df00b4ae94779cfa512cd1a61af9cb255
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">会员管理</a>
                <dl class="layui-nav-child">
<<<<<<< HEAD
                    <dd><a href="${ctx}/u/to/register">注册新会员</a></dd>
                    <dd><a href="${ctx}/u/to/list">新会员管理</a></dd>
                    <dd><a href="${ctx}/u/to/modify">修改本人资料</a></dd>
                    <dd><a href="${ctx}/u/to/modify/pwd">修改本人密码</a></dd>
=======
                    <dd><a href="${ctx}">注册新会员</a></dd>
                    <dd><a href="${ctx}">新会员管理</a></dd>
                    <dd><a href="${ctx}">修改本人资料</a></dd>
                    <dd><a href="${ctx}">修改本人密码</a></dd>
>>>>>>> 7c779a0df00b4ae94779cfa512cd1a61af9cb255
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">电子银行</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表一</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">购物管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表一</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">信息查询</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表一</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">资讯管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/pages/p/announcement.jsp">公告管理</a></dd>
                    <dd><a href="${ctx}/pages/p/downloadMV.jsp">资讯管理</a></dd>
                    <dd><a href="javascript:;">下载中心</a></dd>
                    <dd><a href="javascript:;">留言管理</a></dd>
                </dl>
            </li>

        </ul>
    </div>
</div>
