package com.servlet;

import com.dao.AnswerDao;
import com.dao.AnswerDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAnsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        int ansId = Integer.parseInt(id);
        AnswerDao ad = new AnswerDaoImpl();
        if(ad.delete(ansId)){
            request.setAttribute("xiaoxi", "删除成功");
            request.getRequestDispatcher("/Searchall").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}