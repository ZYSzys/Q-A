package com.servlet;

import com.dao.QuestionDao;
import com.dao.QuestionDaoImpl;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.Question;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AskServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ques = request.getParameter("ques"); //获取jsp页面传过来的参数
        String desc = request.getParameter("desc");
        Question q = new Question();
        Date now = new Date();
        q.setCreatedTime(now); //实例化一个对象，组装属性
        q.setTitle(ques);
        q.setDescription(desc);
        //UserDao ud = new UserDaoImpl();
        QuestionDao qd = new QuestionDaoImpl();
        System.out.println("Reging....");
        if(qd.register(q)){
            System.out.println("Success");
            //request.setAttribute("question", ques);  //向request域中放置参数
//request.setAttribute("xiaoxi", "注册成功");
            request.getRequestDispatcher("/Searchallquestion").forward(request, response);  //转发到登录页面
        }else{
            response.sendRedirect("index.jsp");//重定向到首页
        }
    }
}