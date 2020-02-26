package com.psych.game.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psych.game.models.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>  {

	
	
	@Query(value="select * from Questions order by rand() limit 1", nativeQuery=true)
	Question getRandomQuestion();
}
