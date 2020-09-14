package com.jxau.web;

import com.jxau.entity.User;
import com.jxau.service.UserService;
import com.jxau.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private UserService userService = (UserService) new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        List<User> users = userService.findAllUser();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if ("1".equals(role)) {
            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getName()) && password.equals(users.get(i).getPassword())) {
                    req.getSession().setAttribute("users",users);
                    req.getSession().setAttribute("username",username);
                    req.getSession().setAttribute("password",password);
                    req.getRequestDispatcher("welcome.jsp").forward(req,resp);
                    return;
                }
            }
        }

        resp.getWriter().println("<script>alert('用户名或密码错误，请重新输入');</script>");
        resp.sendRedirect("index.jsp");
    }
}
