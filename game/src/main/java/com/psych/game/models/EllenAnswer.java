package com.psych.game.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EllenAnswers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EllenAnswer extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JsonBackReference
	private Question question;

	Long votes = 0L;
	@NotBlank
	private String answer;

	@NotNull
	private String name;

}
