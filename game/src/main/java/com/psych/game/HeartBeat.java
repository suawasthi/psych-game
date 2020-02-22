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
		Player player = new Player.Builder().setAlias("suraj").setEmail("suawasthi@gmail.com").setPicUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fpeople.ucsc.edu%2F~jyan102%2F&psig=AOvVaw27qp7OiToVaFDZNCA-8MHZ&ust=1582430039137000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPCxi7ah5OcCFQAAAAAdAAAAABAE").setPsychFaceURL("https://www.google.com/url?sa=i&url=https%3A%2F%2Fpeople.ucsc.edu%2F~jyan102%2F&psig=AOvVaw27qp7OiToVaFDZNCA-8MHZ&ust=1582430039137000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPCxi7ah5OcCFQAAAAAdAAAAABAE").setSaltedPassword("salted").build();
		playerRepo.save(player);
		return "Server is alive at  our end " + new Date().toString();
	}
}
