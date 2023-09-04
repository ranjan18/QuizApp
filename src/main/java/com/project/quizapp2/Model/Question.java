package com.project.quizapp2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    private int id;
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question_title;
    private String right_answer;
}
