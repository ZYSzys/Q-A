package com.servlet;

import com.dao.AnswerDao;
import com.dao.AnswerDaoImpl;
import com.entity.Answer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AnswerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cont = request.getParameter("cont"); //获取jsp页面传过来的参数
        System.out.println("get all...."+cont);
        String id = request.getParameter("theid");
        int questionid = Integer.parseInt(id);
        System.out.println("get all...."+id);
        Answer ans = new Answer();
        Date now = new Date();
        ans.setContent(cont);
        ans.setCreatedTime(now); //实例化一个对象，组装属性
        ans.setQuestionId(questionid);
        AnswerDao ad = new AnswerDaoImpl();
        System.out.println("Reging....");
        if(ad.register(ans)){
            System.out.println("Success");
            //request.getSession().setAttribute("id", id);  //向request域中放置参数
            //System.out.println(id);
//request.setAttribute("xiaoxi", "注册成功");
            String nx = "/SearchallAnswer?id=" + questionid;
            request.getRequestDispatcher(nx).forward(request, response);  //转发到登录页面
        }else{
            response.sendRedirect("index.jsp");//重定向到首页
        }
    }
}
