package com.psych.game.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="EllenAnswers")
public class EllenAnswer extends BaseModel{

	@ManyToOne
	private Question question;
	
	Long votes =0L;
	@NotBlank
	private String answer;
	
	@NotNull
	private String name;
	
}
