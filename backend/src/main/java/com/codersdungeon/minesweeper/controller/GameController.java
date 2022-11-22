package com.codersdungeon.minesweeper.controller;

import com.codersdungeon.minesweeper.dtos.RequestGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseLoadGameDTO;
import com.codersdungeon.minesweeper.entity.Game;
import com.codersdungeon.minesweeper.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/game/{gameId}")
    public ResponseLoadGameDTO loadGame(@PathVariable Integer gameId) {

        ResponseLoadGameDTO dto = gameService.loadGame(gameId);

        return dto;
    }

    @PostMapping("/game")
    public ResponseGameDTO newGame(@RequestBody RequestGameDTO dto) {
        return gameService.newGame(dto);
    }

    @DeleteMapping("/game/{gameId}")
    public void deleteGame(@PathVariable Integer gameId) {
        gameService.deleteGame(gameId);
    }

    @PutMapping("/game/{gameId}/pause")
    public void pauseGame(@PathVariable Integer gameId) {
        gameService.pauseGame(gameId);
    }

}
