package com.psych.game.models;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Stats extends BaseModel{
	private Integer gotPsychedCount=0;
	private Integer psychedOtherCount=0;
	private Integer correctAnswerCount=0;
}
