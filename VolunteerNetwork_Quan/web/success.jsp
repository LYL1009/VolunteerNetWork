<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        tr {
            text-align: center;
        }

        td {
            padding: 10px;
        }
    </style>
    <%
        request.setAttribute("tcp",request.getContextPath());
    %>
</head>
<body>
<h1>欢迎来到管理员界面</h1>
<table border="1" cellspacing="0" cellpadding="0">
    <tbody>
    <tr>
        <th colspan="9">管理员列表</th>
    </tr>
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>注册时间</th>
        <th>简介</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${sessionScope.users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.gender}</td>
            <td>${user.email}</td>
            <td>${user.date}</td>
            <td>${user.profile}</td>
            <td><a href="${tcp}/toUpdatePage.do?id=${user.id}&username=${user.name}&password=${user.password}">修改</a></td>
            <td><a href="${tcp}/delete.do?id=${user.id}">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="3"><a href="${tcp}/add.do">添加管理员</a></th>
        <th colspan="6" align="center">
            <form action="${tcp}/get.do" method="post">
                <input type="text" name="id">
                <input type="submit" value="搜索">
            </form>
        </th>
    </tr>
    <c:if test="${sessionScope.user.id > 0}">
        <tr>
            <td>${sessionScope.user.id}</td>
            <td>${sessionScope.user.name}</td>
            <td>${sessionScope.user.password}</td>
            <td>${sessionScope.user.gender}</td>
            <td>${sessionScope.user.email}</td>
            <td>${sessionScope.user.profile}</td>
            <td colspan="3">搜索结果</td>
        </tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
