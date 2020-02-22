package com.psych.game;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("isAlive")
public class HeartBeat {
	

	@Autowired
	public HeartBeat() {
		
	}

	@GetMapping
	public String getBeat() {
		return "Server is alive at  our end " + new Date().toString();
	}
}
