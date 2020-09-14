package com.jxau.web;

import com.lyl.entity.User;
import com.lyl.service.UserService;
import com.lyl.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CRUDServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();

        if (uri.contains("add")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        } else if (uri.contains("toUpdatePage")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.getSession().setAttribute("id",id);
            String username = req.getParameter("username");
            req.setAttribute("username",username);
            String password = req.getParameter("password");
            req.setAttribute("password",password);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        } else if (uri.contains("update")) {
            int id = (int) req.getSession().getAttribute("id");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            int i = userService.editUser(id, username, password);
            if (i > 0) {
                List<User> users = userService.findAllUser();
                req.getSession().setAttribute("users",users);
                resp.sendRedirect("welcome.jsp");
                return;
            }
        } else if (uri.contains("get")) {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = userService.findUserById(id);
            req.getSession().setAttribute("user",user);
        } else if (uri.contains("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            int i = userService.removeUser(id);
            if (i > 0) {
                List<User> users = userService.findAllUser();
                req.getSession().setAttribute("users",users);
                resp.sendRedirect("welcome.jsp");
                return;
            }
        } else if (uri.contains("show")) {
            List<User> users = userService.findAllUser();
            req.getSession().setAttribute("users",users);
            resp.sendRedirect("welcome.jsp");
            return;
        }

        resp.sendRedirect("welcome.jsp");
    }
}
