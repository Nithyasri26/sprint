package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Quiz;
import com.example.exception.QuizNotFoundException;
import com.example.repository.QuizRepository;
import com.example.service.QuizService;
import com.example.serviceImpl.QuizServiceImpl;


@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

   
    @Override
    public Quiz getQuizById(String quizId) throws QuizNotFoundException {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            return quiz.get();
        } else {
            throw new QuizNotFoundException("Quiz not found with ID: " + quizId);
        }
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz updateQuiz(String quizId, Quiz quiz) throws QuizNotFoundException {
        Optional<Quiz> existingQuiz = quizRepository.findById(quizId);
        if (existingQuiz.isPresent()) {
            quiz.setQuizId(quizId);
            return quizRepository.save(quiz);
        }
        else  throw new QuizNotFoundException("Quiz not found with ID: " + quizId);
    }


    @Override
    public void deleteQuiz(String quizId) throws  QuizNotFoundException {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            quizRepository.deleteById(quizId);
            return;
        }
        else   throw new QuizNotFoundException("Quiz not found with ID: " + quizId);
    }
}

