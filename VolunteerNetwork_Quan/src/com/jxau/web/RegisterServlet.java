package com.jxau.web;

import com.jxau.entity.User;
import com.jxau.service.UserService;
import com.jxau.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegisterServlet extends HttpServlet {

    private UserService userService = (UserService) new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Map<String,String> map = new HashMap<>();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        if ("1".equals(gender)) {
            gender = "男";
        } else {
            gender = "女";
        }
        String email = req.getParameter("email");
        String profile = req.getParameter("profile");
        User user = new User(username,password,email,gender,profile);
        int i = userService.addUser(user);
        map.put("username",username);
        map.put("password",password);
        req.setAttribute("map",map);

        if (i > 0) {
            resp.getWriter().println("<script>alert('注册成功！');</script>");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } else {
            resp.getWriter().println("<script>alert('注册失败！');</script>");
            resp.sendRedirect("register.jsp");
        }

    }
}
