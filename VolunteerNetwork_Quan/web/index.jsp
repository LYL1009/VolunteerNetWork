<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jxau.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        tr {
            text-align: center;
        }
    </style>
    <%
      request.setAttribute("tcp",request.getContextPath());
    %>
</head>
<body>
<%
    List<User> users = (List<User>) session.getAttribute("users");
    if (users != null) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getName()) && password.equals(users.get(i).getPassword())) {
                response.sendRedirect("show.do");
                return;
            }
        }
    }
%>
<table border="1" cellpadding="0" cellspacing="0">
    <tbody>
    <form action="${tcp}/login.do" method="post">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="${requestScope.map.get("username")}"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value="${requestScope.map.get("password")}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="radio" value="0" name="role">用户
                <input type="radio" checked="checked" value="1" name="role">管理员
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置">
            </td>
        </tr>
    </form>
    <tr>
        <td colspan="2">
            <a href="${tcp}/register.jsp" style="text-decoration: none">没有账户？去注册</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
