package com.lakhan.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lakhan.DTO.QuizDTO;
import com.lakhan.Repo.QuizRepository;
import com.lakhan.model.Quiz;

@Service
public class QuizService {
	
	private  QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(QuizDTO quizRequest) {
        Quiz quiz = new Quiz();
        return quizRepository.save(quiz);
    }

    public Quiz getActiveQuiz() {
        LocalDateTime currentTime = LocalDateTime.now();
        return quizRepository.findActiveQuiz(currentTime);
    }

    public String getQuizResult(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow();

        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(quiz.getEndDate().plusMinutes(5))) {
            throw new IllegalStateException("Quiz result is not available yet");
        }

        return quiz.getOptions().get(quiz.getRightAnswer());
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

}
