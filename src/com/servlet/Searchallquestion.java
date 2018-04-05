package com.servlet;

import com.dao.QuestionDao;
import com.dao.QuestionDaoImpl;
import com.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Searchallquestion extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao qd = new QuestionDaoImpl();
        List<Question> questionAll = qd.getQuestionAll();
        req.setAttribute("questionAll", questionAll);
        //String user = req.getParameter("user");
        //req.setAttribute("user", user);
        //req.setAttribute("");
        req.getRequestDispatcher("/questions.jsp").forward(req, resp);
    }
}
