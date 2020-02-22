package com.psych.game.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Rounds")
public class Round extends BaseModel {

	@ManyToOne
	private Game game;

	@ManyToOne
	private Question questions;

	@ManyToMany(cascade=CascadeType.ALL)
	private Map<Player, PlayerAnswer> fakeAnswerMap = new HashMap<Player, PlayerAnswer>();
	@ManyToMany(cascade=CascadeType.ALL)
	private Map<Player, PlayerAnswer> selectedAnswerMap = new HashMap<Player, PlayerAnswer>();
	
	@ManyToOne
	private EllenAnswer ellenAnswer;
	
	@NotNull
	private Integer roundNo;
}
