<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        request.setAttribute("tcp",request.getContextPath());
    %>
</head>
<body>
<h1>修改管理员信息</h1>
<table border="1" cellpadding="0" cellspacing="0">
    <tbody>
    <tr>
        <td>id</td>
        <td>${sessionScope.id}</td>
    </tr>
    <form action="${tcp}/update.do" method="post">
        <tr>
            <td>账户</td>
            <td><input type="text" name="username" value="${requestScope.username}"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" value="${requestScope.password}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="修改">
                <input type="reset" value="重置">
            </td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
