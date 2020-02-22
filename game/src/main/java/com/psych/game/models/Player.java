package com.psych.game.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.Data;

@Entity
@Table(name = "Players")
@Data
public class Player extends User {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String alias;

	@URL
	private String picUrl;

	@URL
	private String psychFaceURL;

	@OneToOne(cascade = CascadeType.ALL)
	private Stats stats = new Stats();

	@ManyToMany(mappedBy = "players")
	private Set<Game> games = new HashSet<Game>();

	private Player(Builder builder) {
		setAlias(builder.alias);
		setEmail(builder.email);
		setPicUrl(builder.picUrl);
		setPsychFaceURL(builder.psychFaceURL);
		setSaltedPassword(builder.saltedPassword);
	}

	public static class Builder {
		private @NotBlank String alias;
		private @NotBlank @Email String email;
		private @NotBlank String saltedPassword;
		private String picUrl;
		private String psychFaceURL;

		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder setAlias(@NotBlank String val) {
			alias = val;
			return this;
		}

		public Builder setEmail(@Email @NotBlank String val) {
			email = val;
			return this;
		}

		public Builder setSaltedPassword(@NotBlank String val) {
			saltedPassword = val;
			return this;
		}

		public Builder setPicUrl(String val) {
			picUrl = val;
			return this;
		}

		public Builder setPsychFaceURL(String val) {
			psychFaceURL = val;
			return this;
		}

		public Player build() {
			return new Player(this);

		}

	}
}