package com.psych.game.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User extends BaseModel {
	
	@Email
	@NotBlank
	@Column(unique=true)
	private String email;

	@NotBlank
	private String saltedPassword;
	
	@ManyToMany
	Set<Role> roles = new HashSet<Role>();
}
