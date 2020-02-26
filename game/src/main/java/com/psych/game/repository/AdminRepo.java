package com.psych.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psych.game.models.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

}
