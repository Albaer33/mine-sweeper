package com.codersdungeon.minesweeper.services;

import com.codersdungeon.minesweeper.dtos.RequestGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseGameDTO;
import com.codersdungeon.minesweeper.entity.Game;
import com.codersdungeon.minesweeper.exceptions.GameNotFoundException;
import com.codersdungeon.minesweeper.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public ResponseGameDTO newGame(RequestGameDTO dto) {

        Game game = new Game();
        game.setRows(dto.getRows());
        game.setColumns(dto.getColumns());
        game.setMines(dto.getMines());

        Game savedGame = gameRepository.save(game);

        ResponseGameDTO responseGameDTO = new ResponseGameDTO();
        responseGameDTO.setGameId(savedGame.getGameId());

        return responseGameDTO;
    }

    @Override
    public void deleteGame(Integer gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException("Game not found"));
        gameRepository.delete(game);
    }

    @Override
    public ResponseGameDTO findGameById(Integer gameId) {

        Game gameToFind = gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException("Game not found"));
        ResponseGameDTO dto = new ResponseGameDTO();
        BeanUtils.copyProperties(gameToFind, dto);

        return dto;
    }

}
