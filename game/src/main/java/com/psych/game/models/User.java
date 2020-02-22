package com.psych.game.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class User extends BaseModel {
	
	public User(User user) {
		this.email=user.email;
		this.saltedPassword= user.saltedPassword;
		this.roles=user.roles;
	}
	
	public User() {}
	
	@Email
	@NotBlank
	@Column(unique=true)
	private String email;

	@NotBlank
	private String saltedPassword;
	
	@ManyToMany(fetch=FetchType.EAGER)
	Set<Role> roles = new HashSet<Role>();
}
