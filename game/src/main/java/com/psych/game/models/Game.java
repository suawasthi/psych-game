package com.psych.game.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Games")
@Getter
@Builder(toBuilder = true)
@Setter
@AllArgsConstructor
public class Game extends BaseModel {

	private static final long serialVersionUID = 1L;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	@JsonIdentityReference
	@ManyToMany
	@Builder.Default
	Set<Player> players = new HashSet<Player>();

	@NotNull
	@Enumerated(EnumType.STRING)
	private GameMode gameMode;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Builder.Default
	List<Round> rounds = new ArrayList<Round>();

	@Builder.Default
	private Integer noOfGames = 10;

	@Builder.Default
	private boolean hasEallen = false;

	@ManyToOne
	@JsonIdentityReference
	private Player leader;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	@Builder.Default
	Map<Player, Stats> playerStats = new HashMap<Player, Stats>();

	@Enumerated(EnumType.STRING)
	private GameStatus gameStatus;

	@ManyToMany
	@JsonIdentityReference
	@Builder.Default
	private Set<Player> readyPlayers = new HashSet<Player>();
}
