package com.psych.game.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import Execption.InvalidGameActionExecption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Rounds")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Round extends BaseModel {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JsonBackReference
	private Game game;

	@ManyToOne
	@JsonIdentityReference
	private Question questions;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	@Builder.Default
	private Map<Player, PlayerAnswer> submittedAnswer = new HashMap<Player, PlayerAnswer>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	@Builder.Default
	private Map<Player, PlayerAnswer> selectedAnswerMap = new HashMap<Player, PlayerAnswer>();

	@ManyToOne
	@JsonIdentityReference
	private EllenAnswer ellenAnswer;

	@NotNull
	private Integer roundNo;

	public boolean allAnswerSubmitted(int noOfPlayer) {
		return submittedAnswer.size() == noOfPlayer;
	}

	public void submitAnswer(Player player, String ans) throws InvalidGameActionExecption {
		if (submittedAnswer.containsKey(player))
			throw new InvalidGameActionExecption("Player has already submitted answer");
		for (PlayerAnswer existedSubmittedAnswer : submittedAnswer.values()) {
			if (ans.equals(existedSubmittedAnswer.getAnswer())) {
				throw new InvalidGameActionExecption("Dublicate Answer");
			}
		}
		submittedAnswer.put(player, new PlayerAnswer(player, ans, this));

	}

	public void selectAnswer(Player player, PlayerAnswer selectedAnser) throws InvalidGameActionExecption {
		if (selectedAnswerMap.containsKey(player))
			throw new InvalidGameActionExecption("Player has already selected answer");
		if (selectedAnser.getPlayer().equals(player))
			throw new InvalidGameActionExecption("Can't select your own answer");

		selectedAnswerMap.put(player, selectedAnser);
	}

	public boolean allAnswerSelected(int size) {
		return selectedAnswerMap.size() == size;
	}

	public Round(Game game, Question questions, @NotNull Integer roundNo) {
		super();
		this.game = game;
		this.questions = questions;
		this.roundNo = roundNo;
	}

	public Round(Game game, Question questions, EllenAnswer ellenAnswer, @NotNull Integer roundNo) {
		super();
		this.game = game;
		this.questions = questions;
		this.ellenAnswer = ellenAnswer;
		this.roundNo = roundNo;
	}

}
