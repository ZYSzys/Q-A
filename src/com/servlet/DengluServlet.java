package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DengluServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        UserDao ud = new UserDaoImpl();
        if(ud.login(name, pwd)) {
            req.setAttribute("user", "欢迎用户"+name);
            req.getRequestDispatcher("/Searchallquestion").forward(req, resp);
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
