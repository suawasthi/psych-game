package com.psych.game.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

	@Bean
	public static ApplicationContxtProvider contextProvider() {
		return new ApplicationContxtProvider();
	}
}
