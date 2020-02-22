package com.psych.game.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="Roles")
@Data
public class Role extends BaseModel {

	@NotBlank
	String name;
	
	@NotBlank
	String description;
}
