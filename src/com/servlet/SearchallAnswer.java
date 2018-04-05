package com.servlet;

import com.dao.AnswerDao;
import com.dao.AnswerDaoImpl;
import com.dao.QuestionDao;
import com.dao.QuestionDaoImpl;
import com.entity.Answer;
import com.entity.Question;
import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchallAnswer extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnswerDao ad = new AnswerDaoImpl();
        //QuestionDao qd = new QuestionDaoImpl();

        String id = req.getParameter("id");
        //String user = req.getParameter("user");
        //System.out.println(user);
        //System.out.println(id);
        int questionId = Integer.parseInt(id);
        List<Answer> answerAll = ad.getAnswerAll(questionId);
        //List<Question>questionAll = qd.getQuestionAll();
        req.setAttribute("answerAll", answerAll);
        req.setAttribute("theq", getSelf(questionId));
        req.getRequestDispatcher("/answers.jsp").forward(req, resp);
        //System.out.println(user);
        /*
        if(user.equals(null))
        {
            req.getRequestDispatcher("/answers.jsp").forward(req, resp);
        }
        else
        {
            req.setAttribute("user", user);
            if(user.equals("欢迎用户admin"))
                req.getRequestDispatcher("/adminAns.jsp").forward(req, resp);
            else
                req.getRequestDispatcher("/answers.jsp").forward(req, resp);
        }*/
    }
    public Question getSelf(int questionId) {
        List<Question>list = new ArrayList<Question>();
        try {
            DBconn.init();

            ResultSet rs = DBconn.selectSql("select * from question where id='"+questionId+"'");
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setCreatedTime(rs.getDate("createdTime"));
                question.setDescription(rs.getString("description"));
                question.setTitle(rs.getString("title"));
                list.add(question);
            }
            DBconn.closeConn();
            return list.get(0);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}