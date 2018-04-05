package com.dao;

import com.entity.Answer;

import java.util.List;

public interface AnswerDao {
    public boolean register(Answer answer);
    public List<Answer> getAnswerAll(int id);
    public boolean delete(int id);
}
