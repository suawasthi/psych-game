package com.psych.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psych.game.models.Round;

@Repository
public interface RoundRepo extends JpaRepository<Round, Long> {

}
