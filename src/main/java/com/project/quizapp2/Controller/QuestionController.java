package com.project.quizapp2.Controller;

import com.project.quizapp2.Model.Question;
import com.project.quizapp2.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService qs;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return qs.getAllQuestions();
    }


    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return qs.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question q){
        return qs.addQuestion(q);
    }
}
