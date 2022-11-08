package com.codersdungeon.minesweeper.services;

import com.codersdungeon.minesweeper.entity.Game;

import java.util.List;

public interface GameService {
    List<Game> findAll();
}
