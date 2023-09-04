package com.project.quizapp2.DAO;

import com.project.quizapp2.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
