package com.psych.game.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name="PlayerAnswers")
public class PlayerAnswer extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PlayerAnswer(){}
	
	@NotNull
	private String answer;
	
	@ManyToOne
	@NotNull
	@JsonBackReference
	private Round round;
	
	@ManyToOne	
	@NotNull
	@JsonIdentityReference
	private Player player;
}
