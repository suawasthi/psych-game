package com.psych.game.util;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.psych.game.models.GameMode;
import com.psych.game.models.Question;
import com.psych.game.repository.QuestionRepo;

@Component
public class QuestionUtil {

	@Autowired
	static QuestionRepo questRepo;

	public static Question getRandomQuestion(GameMode gameMode) {
		List<Question> ques = questRepo.findAll();
		return ques.get(0);
	}
}
