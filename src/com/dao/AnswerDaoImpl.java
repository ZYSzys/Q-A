package com.dao;

import com.entity.Answer;
import com.entity.Question;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswerDaoImpl implements AnswerDao {
    @Override
    public boolean register(Answer answer) {
        boolean flag = false;
        DBconn.init();

        Date dt = answer.getCreatedTime();
        String formatDate = null;
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        formatDate = dFormat.format(dt);
        System.out.println(formatDate);
        String sql = "insert into answer(content,createdTime,questionId)"+"values('"+answer.getContent()+"','"+formatDate+"','"+answer.getQuestionId()+"')";
        System.out.println(sql);
        int i = DBconn.addUpdDel(sql);
        if(i > 0)
            flag = true;
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<Answer> getAnswerAll(int id) {
        List<Answer>list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from answer where questionId='"+id+"'");
            ResultSet qt = DBconn.selectSql("select * from question where id='"+id+"'");
            Question ques = null;
            while (qt.next()) {
                ques = new Question();
                ques.setId(qt.getInt("id"));
                ques.setTitle(qt.getString("title"));
                ques.setDescription(qt.getString("description"));
                ques.setCreatedTime(qt.getDate("createdTime"));
            }
            while (rs.next()) {
                Answer answer = new Answer();
                answer.setId(rs.getInt("id"));
                answer.setContent(rs.getString("content"));
                answer.setCreatedTime(rs.getDate("createdTime"));
                answer.setEmail(rs.getString("email"));
                answer.setQuestionId(rs.getInt("questionId"));

                answer.setQuestion(ques);
                list.add(answer);
            }
            DBconn.closeConn();
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete from answer where id="+id;
        int i = DBconn.addUpdDel(sql);
        if(i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
}
