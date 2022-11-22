package com.codersdungeon.minesweeper.services;

import com.codersdungeon.minesweeper.dtos.RequestGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseLoadGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseStartDTO;
import com.codersdungeon.minesweeper.entity.Game;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GameService {
    List<Game> findAll();
    ResponseGameDTO newGame(RequestGameDTO dto);
    void deleteGame(Integer gameId);
    ResponseLoadGameDTO loadGame(Integer gameId);
    ResponseStartDTO startGame(Integer gameId);
    void pauseGame(Integer gameId);
}
