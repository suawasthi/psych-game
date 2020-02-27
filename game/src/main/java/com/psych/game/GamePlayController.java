package com.psych.game;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psych.game.models.Game;
import com.psych.game.models.GameMode;
import com.psych.game.models.GameStatus;
import com.psych.game.models.Player;
import com.psych.game.models.Question;
import com.psych.game.repository.GameRepo;
import com.psych.game.repository.PlayerRepo;
import com.psych.game.repository.QuestionRepo;

@RestController
public class GamePlayController {

	@Autowired
	PlayerRepo playerRepo;
	
	
	
	@Autowired
	QuestionRepo questionRepo;
	
	@Autowired
	GameRepo gameRepo;

	@GetMapping("/username")
	public String play(Authentication authentication) {
		return authentication.getName();

	}

	@GetMapping("submitAnswer/{ans}")
	public void submitAnswer(Authentication authentication, @PathVariable(name = "ans") String ans)
			throws Exception {
		Optional<Player> player = playerRepo.findByEmail(authentication.getName());
		if (player.get() == null) {
			throw new Exception("Player not register");
		}

		Player currentPlayer = player.get();
		currentPlayer.getCurrentGame().submitAnswer(currentPlayer, ans);

	}

	@GetMapping("/nextQuestion")
	public String getQuestion12() {
		return  questionRepo.getRandomQuestion().getQuestion();
	}
	
	@GetMapping("/startGame")
	public void startGame(Authentication authentication ) throws Exception {
		Optional<Player> leader = playerRepo.findByEmail(authentication.getName());
		
		if (!leader.isPresent() ) {
			throw new Exception("Player not register");
		}
		Player pl = leader.get();
		
		Game game = new Game(GameMode.IS_A_FACT,pl, 10, false);
		GameStatus gameStatus = GameStatus.PlAYER_JOINING;
		game.setGameStatus(gameStatus);
		leader.get().setCurrentGame(game);
		gameRepo.save(game);
	}
}
