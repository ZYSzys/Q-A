package com.dao;

import com.entity.Question;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    @Override
    public boolean register(Question question) {
        boolean flag = false;
        DBconn.init();

        Date dt = question.getCreatedTime();
        String formatDate = null;
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        formatDate = dFormat.format(dt);
        System.out.println(formatDate);
        String sql = "insert into question(createdTime,description,title)"+"values('"+formatDate+"','"+question.getDescription()+"','"+question.getTitle()+"')";
        System.out.println(sql);
        int i = DBconn.addUpdDel(sql);
        if(i > 0)
            flag = true;
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<Question> getQuestionAll() {
        List<Question>list = new ArrayList<Question>();
        try {
            DBconn.init();

            ResultSet rs = DBconn.selectSql("select * from question order by id desc");
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setCreatedTime(rs.getDate("createdTime"));
                question.setDescription(rs.getString("description"));
                question.setTitle(rs.getString("title"));
                list.add(question);
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
        String sql = "delete from question where id="+id;
        int i = DBconn.addUpdDel(sql);
        if(i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(int id, String title, String desc) {
        boolean flag = false;
        DBconn.init();
        String sql = "update question set title ='"+title+
                "', description='"+desc+
                "' where id="+id;
        int i = DBconn.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return  flag;
    }
}
