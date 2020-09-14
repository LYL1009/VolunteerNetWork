<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <%
        request.setAttribute("tcp",request.getContextPath());
    %>
</head>
<body>
<h1>志愿者注册</h1>
<form action="${tcp}/register.do" method="post">
    账户：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    性别：<input type="radio" checked="checked" name="gender" value="1">男
            <input type="radio" name="gender" value="0">女<br>
    Email：<input type="email" name="email"><br>
    个人简介：<textarea name="profile"></textarea><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
