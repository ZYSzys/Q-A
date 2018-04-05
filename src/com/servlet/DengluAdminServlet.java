package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DengluAdminServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        //System.out.println(name);
        //System.out.println(pwd);
        UserDao ud = new UserDaoImpl();
        //System.out.println(ud.login(name,pwd));
        //if(name == "admin" && pwd == "admin") System.out.println(true);
        if(name.equals("admin") && pwd.equals("admin") && ud.login(name, pwd)) {
            System.out.println("admin login");
            req.setAttribute("user", "欢迎用户"+name);
            req.getRequestDispatcher("/Searchall").forward(req, resp);
            //req.getRequestDispatcher("/Searchallquestion").forward(req, resp);
        }else {
            System.out.println("failed");
            resp.sendRedirect("index.jsp");
        }
    }
}