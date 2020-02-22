package com.psych.game.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PlayerAnswers")
public class PlayerAnswer extends BaseModel {

	@NotNull
	private String answer;
	
	@ManyToOne
	@NotNull
	private Round round;
	
	@ManyToOne	
	@NotNull
	private Player player;
}
