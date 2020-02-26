package com.psych.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psych.game.models.EllenAnswer;
import com.psych.game.models.Question;

@Repository
public interface EllenRepo  extends JpaRepository<EllenAnswer, Long>{

	 @Query(value="select * from EllenAnswers where question:question", nativeQuery=true)
	static  EllenAnswer getRandomAnswer( Question question) {
		// TODO Auto-generated method stub
		return null;
	}
		

}
