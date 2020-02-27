package com.psych.game.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import Execption.InvalidGameActionExecption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Games")
@Getter
@Builder(toBuilder = true)
@Setter
@AllArgsConstructor
public class Game extends BaseModel {

	public Game(@NotNull GameMode gameMode, @NotNull Player leader, int round, Boolean hasEllen) {
		this.gameMode = gameMode;
		this.leader = leader;
		this.noOfGames = round;
		this.hasEallen = hasEllen;
		//leader.currentGame = this;
		this.players = new HashSet<Player>();
		this.players.add(leader);
		
	}

	private static final long serialVersionUID = 1L;

	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	@JsonIdentityReference
	@ManyToMany
	@Builder.Default
	Set<Player> players = new HashSet<Player>();

	@NotNull
	@Enumerated(EnumType.STRING)
	private GameMode gameMode;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Builder.Default
	List<Round> rounds = new ArrayList<Round>();

	@Builder.Default
	private Integer noOfGames = 10;

	@Builder.Default
	private boolean hasEallen = false;

	@ManyToOne
	@JsonIdentityReference
	private Player leader;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	@Builder.Default
	Map<Player, Stats> playerStats = new HashMap<Player, Stats>();

	@Enumerated(EnumType.STRING)
	private GameStatus gameStatus;

	@ManyToMany
	@JsonIdentityReference
	@Builder.Default
	private Set<Player> readyPlayers = new HashSet<Player>();

	public void addPlayer(Player player) throws InvalidGameActionExecption {
		if (!this.gameStatus.equals(GameStatus.PlAYER_JOINING))
			throw new InvalidGameActionExecption("Can't join the game after it has started");
		player.setCurrentGame(this);
		players.add(player);

	}

	public void remove(Player player) throws InvalidGameActionExecption {
		if (!players.contains(player))
			throw new InvalidGameActionExecption("No such player exist");
		players.remove(player);

		if (players.size() == 0 || (players.size() == 1 && !gameStatus.equals(GameStatus.PlAYER_JOINING))) {
			endGame();
		}

	}

	public void startGame(Player player) throws InvalidGameActionExecption {
		if (!player.equals(leader))
			throw new InvalidGameActionExecption("Only leader can start game");

		startNewRound();
	}

	private void startNewRound() {
		gameStatus = GameStatus.SUBMITING_ANSWER;
		Question question = new Question();
		Round round = new Round(this, question, rounds.size() + 1);
		rounds.add(round);
		if (hasEallen) {
			//round.setEllenAnswer(EllenUtil.getRandomAnswer(question));
		}

		rounds.add(round);

	}

	private void endGame() {
		gameStatus = GameStatus.ENDED;
		players.clear();
		// todo

	}

	public void submitAnswer(Player player, String ans) throws InvalidGameActionExecption {
		if (ans.length() == 0)
			throw new InvalidGameActionExecption("No answer");
		if (players.contains(player))
			throw new InvalidGameActionExecption("Player is not in this game");
		if (!gameStatus.equals(GameStatus.SUBMITING_ANSWER))
			throw new InvalidGameActionExecption("Game is not accepting answer currently");
		Round currentRound = getCurrentRound();
		currentRound.submitAnswer(player, ans);

		if (currentRound.allAnswerSubmitted(players.size())) {
			gameStatus = GameStatus.SELLECTING_ANSWER;
		}

	}

	public void selectAnswe(Player player, PlayerAnswer selectedAnser) throws InvalidGameActionExecption {
		if (players.contains(player))
			throw new InvalidGameActionExecption("Player is not in this game");
		if (!gameStatus.equals(GameStatus.SELLECTING_ANSWER))
			throw new InvalidGameActionExecption("Game is not accepting answer currently");

		Round currentRound = getCurrentRound();
		currentRound.selectAnswer(player, selectedAnser);
		if (currentRound.allAnswerSelected(players.size())) {
			if (rounds.size() < noOfGames) {
				gameStatus = GameStatus.WAITING_FOR_READY;
			} else {
				endGame();
			}
		}

	}

	public void isPlayerReady(Player player) throws InvalidGameActionExecption {
		if (players.contains(player))
			throw new InvalidGameActionExecption("Player is not in this game");
		if (!gameStatus.equals(GameStatus.WAITING_FOR_READY))
			throw new InvalidGameActionExecption("Game is not waiting for player");
		readyPlayers.add(player);
		if (readyPlayers.size() == players.size()) {
			startNewRound();
		}
	}

	public void playerNotReady(Player player) throws InvalidGameActionExecption {
		if (players.contains(player))
			throw new InvalidGameActionExecption("Player is not in this game");
		if (!gameStatus.equals(GameStatus.WAITING_FOR_READY))
			throw new InvalidGameActionExecption("Game is not waiting for player");
		readyPlayers.remove(player);

	}

	private Round getCurrentRound() throws InvalidGameActionExecption {
		if (rounds.size() == 0) {
			throw new InvalidGameActionExecption("Round not started");
		}
		return rounds.get(rounds.size() - 1);
	}

	public String getGameState() {
		return "game details";
	}

}
