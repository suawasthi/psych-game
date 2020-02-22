package com.psych.game.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@Builder

public class Question extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Question() {
		// TODO Auto-generated constructor stub
	}

	@NotNull
	private String question;
	@NotNull
	private String correctAnswer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonManagedReference
	@Builder.Default
	private Set<EllenAnswer> ellenAnswer = new HashSet<EllenAnswer>();

	private GameMode gameMode;
}
