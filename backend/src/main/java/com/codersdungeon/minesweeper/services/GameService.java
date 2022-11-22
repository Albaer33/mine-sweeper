package com.codersdungeon.minesweeper.services;

import com.codersdungeon.minesweeper.dtos.RequestGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseLoadGameDTO;
import com.codersdungeon.minesweeper.entity.Game;

import java.util.List;

public interface GameService {
    List<Game> findAll();
    ResponseGameDTO newGame(RequestGameDTO dto);
    void deleteGame(Integer gameId);
    ResponseLoadGameDTO loadGame(Integer gameId);
    void pauseGame(Integer gameId);
}
