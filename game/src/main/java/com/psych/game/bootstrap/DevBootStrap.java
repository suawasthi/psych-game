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
import com.psych.game.models.Question;
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
		Game game = Game.builder().players(pl).leader(suraj).gameStatus(GameStatus.PlAYER_JOINING)
				.gameMode(GameMode.MOVIE_BUFF).noOfGames(34).hasEallen(false).build();
		gameRepo.save(game);
		Question question1 = new Question("What are the dying words of Charles Foster Kane in Citizen Kane?", "Rosebud",
				null, GameMode.IS_A_FACT);
		Question question2 = new Question("Who played Mrs. Robinson in The Graduate?", "Anne Bancroft", null,
				GameMode.IS_A_FACT);

		Question question3 = new Question("What was the first feature-length animated movie ever released?",
				"Snow White and the Seven Dwarfs", null, GameMode.IS_A_FACT);

		Question question4 = new Question("In The Matrix, does Neo take the blue pill or the red pill?", "Red", null,
				GameMode.IS_A_FACT);

		Question question5 = new Question("For what movie did Tom Hanks score his first Academy Award nomination?",
				"Big", null, GameMode.IS_A_FACT);

		Question question6 = new Question("What 1927 musical was the first “talkie”?", "The Jazz Singer", null,
				GameMode.IS_A_FACT);

		Question question7 = new Question("What’s the name of the skyscraper in Die Hard?", "Nakatomi Plaza", null,
				GameMode.IS_A_FACT);

		Question question8 = new Question("What flavor of Pop Tarts does Buddy the Elf use in his spaghetti in Elf? ",
				"Chocolate", null, GameMode.IS_A_FACT);

		Question question9 = new Question(
				"What shocking Wes Craven horror movie carried the marketing tagline, “To avoid fainting, keep repeating, ‘It’s only a movie…'”?",
				"The Last House on the Left", null, GameMode.IS_A_FACT);

		Question question10 = new Question("What pop vocal group performs at the wedding in Bridesmaids?",
				"Wilson Phillips", null, GameMode.IS_A_FACT);

		Question question11 = new Question(
				"What real-life on-again off-again Hollywood power couple starred in the film Who’s Afraid of Virginia Woolf?",
				"Elizabeth Taylor and Richard Burton", null, GameMode.IS_A_FACT);

		questionRepol.save(question1);
		questionRepol.save(question2);
		questionRepol.save(question3);
		questionRepol.save(question4);
		questionRepol.save(question5);
		questionRepol.save(question6);
		questionRepol.save(question7);
		questionRepol.save(question8);
		questionRepol.save(question9);
		questionRepol.save(question10);
		questionRepol.save(question11);

	}

}
