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
import java.util.List;

public class Searchall extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao ud = new UserDaoImpl();
        List<User> userAll = ud.getUserAll();
        QuestionDao qd = new QuestionDaoImpl();
        List<Question> quesAll = qd.getQuestionAll();
        request.setAttribute("userAll", userAll);
        request.setAttribute("quesAll", quesAll);
        request.getRequestDispatcher("/showall.jsp").forward(request, response);
    }
}