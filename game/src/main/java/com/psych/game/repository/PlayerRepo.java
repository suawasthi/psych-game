package com.psych.game.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psych.game.models.Player;
@Repository
public interface PlayerRepo  extends JpaRepository<Player, Long>{

	Optional<Player>  findByEmail(String name);
	

}
