package com.codersdungeon.minesweeper.controller;

import com.codersdungeon.minesweeper.entity.Game;
import com.codersdungeon.minesweeper.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
