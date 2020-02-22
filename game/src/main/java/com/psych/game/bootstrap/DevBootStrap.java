package com.psych.game.bootstrap;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.psych.game.models.Game;
import com.psych.game.models.GameMode;
import com.psych.game.models.GameStatus;
import com.psych.game.models.Player;
import com.psych.game.repository.GameRepo;
import com.psych.game.repository.PlayerRepo;
import com.psych.game.repository.QuestionRepo;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	public PlayerRepo playerRepo;

	@Autowired
	public QuestionRepo questionRepol;

	@Autowired
	public GameRepo gameRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Player suraj = new Player.Builder().setAlias("surajAwasthi").setEmail("suawasthi@gmail.com").setPicUrl(
				"https://www.google.com/url?sa=i&url=https%3A%2F%2Fpeople.ucsc.edu%2F~jyan102%2F&psig=AOvVaw27qp7OiToVaFDZNCA-8MHZ&ust=1582430039137000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPCxi7ah5OcCFQAAAAAdAAAAABAE")
				.setPsychFaceURL(
						"https://www.google.com/url?sa=i&url=https%3A%2F%2Fpeople.ucsc.edu%2F~jyan102%2F&psig=AOvVaw27qp7OiToVaFDZNCA-8MHZ&ust=1582430039137000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPCxi7ah5OcCFQAAAAAdAAAAABAE")
				.setSaltedPassword("salted").build();
		Player jitender = new Player.Builder().setAlias("jitender").setEmail("jitawasthi@gmail.com").setPicUrl(
				"https://www.google.com/url?sa=i&url=https%3A%2F%2Fpeople.ucsc.edu%2F~jyan102%2F&psig=AOvVaw27qp7OiToVaFDZNCA-8MHZ&ust=1582430039137000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPCxi7ah5OcCFQAAAAAdAAAAABAE")
				.setPsychFaceURL(
						"https://www.google.com/url?sa=i&url=https%3A%2F%2Fpeople.ucsc.edu%2F~jyan102%2F&psig=AOvVaw27qp7OiToVaFDZNCA-8MHZ&ust=1582430039137000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPCxi7ah5OcCFQAAAAAdAAAAABAE")
				.setSaltedPassword("xyz").build();
		playerRepo.save(suraj);
		playerRepo.save(jitender);
		Set<Player> pl = new HashSet<Player>();
		pl.add(suraj);
		pl.add(jitender);
		Game game = Game.builder().players(pl).leader(suraj).gameStatus(GameStatus.PlAYER_jOINING).gameMode(GameMode.MOVIE_BUFF).noOfGames(34).hasEallen(false).build();
		gameRepo.save(game);
	}

}
