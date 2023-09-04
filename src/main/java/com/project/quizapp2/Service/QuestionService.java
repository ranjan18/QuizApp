package com.project.quizapp2.Service;

import com.project.quizapp2.DAO.QuestionDao;
import com.project.quizapp2.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        List<Question> questions =questionDao.findByCategory(category);
        return questions;
    }

    public String addQuestion(Question q) {
        questionDao.save(q);
        return "Success";
    }
}
