package com.lakhan.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lakhan.DTO.QuizDTO;
import com.lakhan.model.Quiz;
import com.lakhan.service.QuizService;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

	
	 private  QuizService quizService;

	    public QuizController(QuizService quizService) {
	        this.quizService = quizService;
	    }

	    @PostMapping
	    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDTO quizDto) {
	        Quiz quiz = quizService.createQuiz(quizDto);
	        return ResponseEntity.ok(quiz);
	    }

	    @GetMapping("/active")
	    public ResponseEntity<Quiz> getActiveQuiz() {
	        Quiz quiz = quizService.getActiveQuiz();
	        return ResponseEntity.ok(quiz);
	    }

	    @GetMapping("/{id}/result")
	    public ResponseEntity<String> getQuizResult(@PathVariable("id") Long quizId) {
	        String result = quizService.getQuizResult(quizId);
	        return ResponseEntity.ok(result);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Quiz>> getAllQuizzes() {
	        List<Quiz> quizzes = quizService.getAllQuizzes();
	        return ResponseEntity.ok(quizzes);
	    }
}
