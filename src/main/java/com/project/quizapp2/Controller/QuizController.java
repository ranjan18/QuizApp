package com.project.quizapp2.Controller;

import com.project.quizapp2.Model.Question;
import com.project.quizapp2.Model.QuestionWrapper;
import com.project.quizapp2.Model.Response;
import com.project.quizapp2.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
        @Autowired
        QuizService quizService;
        @PostMapping("create")
        public String createQuiz(@RequestParam String category,int numQ,String title){
            return quizService.createQuiz(category,numQ,title);

        }

        @GetMapping("get/{id}")
        public List<QuestionWrapper> getQuiz(@PathVariable int id){
                return quizService.getQuiz(id);
        }

        @PostMapping("submit/{id}")
        public int submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
                return quizService.CalculateScore(id,responses);
        }
}
