package com.psych.game;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psych.game.models.Player;
import com.psych.game.repository.PlayerRepo;

@RestController
@RequestMapping("isAlive")
public class HeartBeat {
	private PlayerRepo playerRepo;

	@Autowired
	public HeartBeat(PlayerRepo playerRepo) {
		this.playerRepo = playerRepo;
	}

	@GetMapping
	public String getBeat() {
		Player player = new Player();
		player.setAlias("suraj");
		player.setPicUrl("sdasda");
		playerRepo.save(player);
		return "Server is alive at  our end " + new Date().toString();
	}
}
