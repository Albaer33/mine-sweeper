package com.codersdungeon.minesweeper.repository;

import com.codersdungeon.minesweeper.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}
