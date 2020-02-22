package com.psych.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psych.game.models.Game;
@Repository
public interface GameRepo extends JpaRepository<Game, Long> {

}
