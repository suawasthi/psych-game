package com.psych.game.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psych.game.config.ApplicationContxtProvider;
import com.psych.game.config.SpringConfiguration;
import com.psych.game.models.Question;
import com.psych.game.repository.QuestionRepo;

public class QuestionUtil {

	static QuestionRepo questionRepo;

	static {
		
		questionRepo = (QuestionRepo) SpringConfiguration.contextProvider().getApplicationContext()
				.getBean( "questionRepo");
	}

	public static Question getRandomQuestion() {
		return questionRepo.getRandomQuestion();
	}

}
