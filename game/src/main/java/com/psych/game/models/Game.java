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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Games")
public class Game extends BaseModel {

	@ManyToMany
	Set<Player> players = new HashSet<Player>();

	@NotNull
	@Enumerated(EnumType.STRING)
	private GameMode gameMode;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	List<Round> rounds = new ArrayList<Round>();

	private Integer noOfGames = 10;

	private boolean hasEallen = false;

	@ManyToOne
	private Player leader;

	@ManyToMany(cascade = CascadeType.ALL)
	Map<Player, Stats> playerStats = new HashMap<Player, Stats>();
	
	@Enumerated(EnumType.STRING)
	private GameStatus gameStatus;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Player> readyPlayers = new HashSet<Player>();
}
