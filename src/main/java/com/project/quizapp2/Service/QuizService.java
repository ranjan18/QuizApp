package com.project.quizapp2.Service;

import com.project.quizapp2.DAO.QuestionDao;
import com.project.quizapp2.DAO.QuizDao;
import com.project.quizapp2.Model.Question;
import com.project.quizapp2.Model.QuestionWrapper;
import com.project.quizapp2.Model.Quiz;
import com.project.quizapp2.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public String createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return "Success";
    }

    public List<QuestionWrapper> getQuiz(int id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser=new ArrayList<>();
        for(Question q:questionsFromDB){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }
        return questionsForUser;
    }

    public int CalculateScore(int id, List<Response> responses) {
        Quiz quiz=quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRight_answer()))
                right++;
            i++;
        }
        return right;
    }
}
