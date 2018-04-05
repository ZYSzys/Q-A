package com.servlet;

import com.dao.QuestionDao;
import com.dao.QuestionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateQuesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        int quesId = Integer.parseInt(id);
        String title = request.getParameter("title");
        String desc = request.getParameter("description");
        System.out.println("------------------------------------"+quesId);
        QuestionDao qd = new QuestionDaoImpl();
        if(qd.update(quesId, title, desc)){
            request.setAttribute("xiaoxi", "更新成功");
            request.getRequestDispatcher("/Searchall").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}