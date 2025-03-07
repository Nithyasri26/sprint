package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Quiz;
import com.example.service.QuizService;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Create Quiz
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
//        Quiz newQuiz = quizService.createQuiz(quiz);
//        return ResponseEntity.ok(newQuiz);
    	return new  ResponseEntity<Quiz>(quizService.createQuiz(quiz),HttpStatus.OK);
    }

    // Get Quiz by ID
    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable String quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        }
        return ResponseEntity.notFound().build();
    }

    // Get All Quizzes
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    // Update Quiz
    @PutMapping("/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable String quizId, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuiz(quizId, quiz);
        if (updatedQuiz != null) {
            return ResponseEntity.ok(updatedQuiz);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Quiz
    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable String quizId) {
        quizService.deleteQuiz(quizId);
        return ResponseEntity.noContent().build();
    }
}
