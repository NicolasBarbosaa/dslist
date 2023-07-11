package com.devsuperior.DSLLIST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.DSLLIST.entites.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
