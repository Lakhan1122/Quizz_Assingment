package com.lakhan.Repo;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lakhan.model.Quiz;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	 	@Query("SELECT q FROM Quiz q WHERE q.startDate <= :currentTime AND q.endDate >= :currentTime")
	    Quiz findActiveQuiz(@Param("currentTime") LocalDateTime currentTime);

}
