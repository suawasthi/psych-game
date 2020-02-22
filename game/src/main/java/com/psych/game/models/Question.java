package com.psych.game.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Question extends BaseModel{
	@NotNull
	private String question;
	@NotNull
	private String correctAnswer;
	
	@OneToMany(cascade=CascadeType.ALL , mappedBy="question")
	private Set<EllenAnswer> ellenAnswer = new HashSet<EllenAnswer>();
	
	private GameMode gameMode;
}
