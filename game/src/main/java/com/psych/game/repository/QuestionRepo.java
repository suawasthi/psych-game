package com.psych.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psych.game.models.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>  {

}
