package com.lakhan.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;


@Entity
public class Quiz {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String question;
	    private List<String> options;
	    private int rightAnswer;
	    private LocalDateTime startDate;
	    private LocalDateTime endDate;
	    private String status;

	    
	    
	    

	    public Quiz() {
			
		}


		public Quiz(Long id, String question, List<String> options, int rightAnswer, LocalDateTime startDate,
				LocalDateTime endDate, String status) {
			super();
			this.id = id;
			this.question = question;
			this.options = options;
			this.rightAnswer = rightAnswer;
			this.startDate = startDate;
			this.endDate = endDate;
			this.status = status;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
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

		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		@Override
		public String toString() {
			return "Quiz [id=" + id + ", question=" + question + ", options=" + options + ", rightAnswer=" + rightAnswer
					+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
		}


		@PrePersist
	    public void updateStatus() {
	        LocalDateTime currentTime = LocalDateTime.now();
	        if (currentTime.isBefore(startDate)) {
	            status = "inactive";
	        } else if (currentTime.isAfter(endDate)) {
	            status = "finished";
	        } else {
	            status = "active";
	        }
	    }

}
