package com.example.service;

import java.util.List;

import com.example.entities.Quiz;

public interface QuizService {
	
	  Quiz createQuiz(Quiz quiz);
	    Quiz getQuizById(String quizId);
	    List<Quiz> getAllQuizzes();
	    Quiz updateQuiz(String quizId, Quiz quiz);
	    void deleteQuiz(String quizId);
}
