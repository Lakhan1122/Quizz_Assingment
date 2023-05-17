package com.lakhan.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class QuizDTO {
	
		private String question;
	    private List<String> options;
	    private int rightAnswer;
	    private LocalDateTime startDate;
	    private LocalDateTime endDate;
	    
	    
	    
	    
	    
		public QuizDTO() {
			
			// TODO Auto-generated constructor stub
		}

		public QuizDTO(String question, List<String> options, int rightAnswer, LocalDateTime startDate,
				LocalDateTime endDate) {
			super();
			this.question = question;
			this.options = options;
			this.rightAnswer = rightAnswer;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public List<String> getOptions() {
			return options;
		}
		public void setOptions(List<String> options) {
			this.options = options;
		}
		public int getRightAnswer() {
			return rightAnswer;
		}
		public void setRightAnswer(int rightAnswer) {
			this.rightAnswer = rightAnswer;
		}
		public LocalDateTime getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDateTime startDate) {
			this.startDate = startDate;
		}
		public LocalDateTime getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDateTime endDate) {
			this.endDate = endDate;
		}
	    
	    
	    

}
