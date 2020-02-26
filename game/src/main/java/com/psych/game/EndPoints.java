package com.psych.game;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psych.game.models.Game;
import com.psych.game.models.Player;
import com.psych.game.models.Question;
import com.psych.game.models.Round;
import com.psych.game.models.User;
import com.psych.game.repository.GameRepo;
import com.psych.game.repository.PlayerRepo;
import com.psych.game.repository.QuestionRepo;
import com.psych.game.repository.RoundRepo;
import com.psych.game.repository.UserRepo;

@RestController
public class EndPoints {
	@Autowired
	public PlayerRepo playerRepo;

	@Autowired
	public QuestionRepo questionRepol;

	@Autowired
	public GameRepo gameRepo;

	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public RoundRepo roundRepo;

	
	
	@GetMapping("allPlayers")
	public List<Player> getAllPlayer() {
		return playerRepo.findAll();
	}

	@GetMapping("allQuestion")
	public List<Question> getQuestion() {
		return questionRepol.findAll();
	}

	@GetMapping("allGames")
	public List<Game> getGames() {
		return gameRepo.findAll();
	}

	@GetMapping("allUser")
	public List<User> getRepo() {
		return userRepo.findAll();
	}
	@GetMapping("allRound")
	public List<Round> getRound() {
		return roundRepo.findAll();
	}

	@GetMapping("getQuestion/{id}")
	public Optional<Question> getQuestion(@PathVariable("id") Long id) {
		return questionRepol.findById(id);
	}

	@GetMapping("getGame/{id}")
	public Optional<Game> getGameByID(@PathVariable("id") Long id) {
		return gameRepo.findById(id);
	}

	@GetMapping("getPlayer/{id}")
	public Optional<Player> getPlayerByID(@PathVariable("id") Long id) {
		return playerRepo.findById(id);
	}

	@GetMapping("getUser/{id}")
	public Optional<User> getUser(@PathVariable("id") Long id) {
		return userRepo.findById(id);
	}
	@GetMapping("getRound/{id}")
	public Optional<Round> getRound(@PathVariable("id") Long id) {
		return roundRepo.findById(id);
	}
	
	
	
	
	
	
	// start game
	
	// joint game 
}
