package com.psych.game.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Players")
@Data
@EqualsAndHashCode(callSuper=false)
public class Player extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String alias;

	private String picUrl;
	
	private String psychFaceURL;

	@OneToOne(cascade=CascadeType.ALL)
	private Stats stats= new Stats();
	
	@ManyToMany(mappedBy="players")
	private Set<Game> games = new HashSet<Game>();
	
}
