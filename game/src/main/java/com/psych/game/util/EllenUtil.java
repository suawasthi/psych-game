package com.psych.game.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.psych.game.models.EllenAnswer;
import com.psych.game.models.Question;
import com.psych.game.repository.EllenRepo;

@Service
public class EllenUtil {

	
	@Autowired
	EllenRepo ellenRepo;
	
	public static EllenAnswer getRandomAnswer(Question question) {
		return EllenRepo.getRandomAnswer(question);
	}

}
