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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Rounds")
@Builder
@Getter @Setter
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

	@ManyToMany(cascade=CascadeType.ALL)
	@JsonManagedReference
	@Builder.Default
	private Map<Player, PlayerAnswer> submittedAnswer = new HashMap<Player, PlayerAnswer>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonManagedReference
	@Builder.Default
	private Map<Player, PlayerAnswer> selectedAnswerMap = new HashMap<Player, PlayerAnswer>();
	
	@ManyToOne
	@JsonIdentityReference
	private EllenAnswer ellenAnswer;
	
	@NotNull
	private Integer roundNo;
}
