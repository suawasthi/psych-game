package com.psych.game.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ContentWritters")
@AllArgsConstructor
@Getter @Setter
public class ContentWriter extends User {

	private static final long serialVersionUID = 1L;

	ContentWriter() {
	}

	@JsonIdentityReference
	@ManyToMany(cascade = CascadeType.PERSIST)
	Set<Question> editedQuestions = new HashSet<Question>();
}
