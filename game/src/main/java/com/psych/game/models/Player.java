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

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Players")
public class Player extends User {

	private static final long serialVersionUID = 1L;

	public Player() {
		// TODO Auto-generated constructor stub
	}

	@NotBlank
	@Getter
	@Setter
	private String alias;

	@OneToOne(cascade=CascadeType.ALL)
	@JsonIdentityReference
	private Game currentGame;

	@URL
	@Getter
	@Setter
	private String picUrl;

	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}

	@URL
	@Getter
	@Setter
	private String psychFaceURL;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@Getter
	@Setter
	private Stats stats = new Stats();

	@JsonIdentityReference
	@ManyToMany(mappedBy = "players")
	@Getter
	@Setter
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

	public Game getCurrentGame() {
		return currentGame;

	}
}