package com.dao;

import com.entity.Question;

import java.util.List;

public interface QuestionDao {
    public boolean register(Question question);
    public List<Question> getQuestionAll();
    public boolean delete(int id);
    public boolean update(int id, String title, String desc);
}
