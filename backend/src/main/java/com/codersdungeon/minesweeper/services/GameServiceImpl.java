package com.codersdungeon.minesweeper.services;

import com.codersdungeon.minesweeper.dtos.RequestGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseGameDTO;
import com.codersdungeon.minesweeper.dtos.ResponseLoadGameDTO;
import com.codersdungeon.minesweeper.entity.Board;
import com.codersdungeon.minesweeper.entity.Cell;
import com.codersdungeon.minesweeper.entity.Game;
import com.codersdungeon.minesweeper.exceptions.BoardNotFoundException;
import com.codersdungeon.minesweeper.exceptions.GameNotFoundException;
import com.codersdungeon.minesweeper.repository.BoardRepository;
import com.codersdungeon.minesweeper.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private BoardRepository boardRepository;

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
    public ResponseLoadGameDTO loadGame(Integer gameId) {

        Game gameToFind = gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException("Game not found"));
        Board boardToFind = boardRepository.findById(gameToFind.getBoard().getId()).orElseThrow(() -> new BoardNotFoundException("board not found"));

        ResponseLoadGameDTO dto = new ResponseLoadGameDTO();
        dto.setBoardId(gameToFind.getBoard().getId());
        dto.setRows(gameToFind.getRows());
        dto.setColumns(gameToFind.getColumns());
        dto.setTotalMines(gameToFind.getMines());
        dto.setPlayer(gameToFind.getPlayer());
        dto.setTime(0);
        dto.setStartDate(gameToFind.getStartDate());
        dto.setWon(gameToFind.isWon());
        dto.setLost(gameToFind.isLost());

        Cell[][] matrix = new Cell[gameToFind.getRows()][gameToFind.getColumns()];
        for (int i = 0, x = 0 ; i < gameToFind.getRows(); i++) {
            for (int j = 0; j < gameToFind.getColumns(); j++) {
                matrix[i][j] = boardToFind.getCellList().get(x++);
            }
        }
        dto.setCells(matrix);

        return dto;
    }

    @Override
    public void pauseGame(Integer gameId) {

    }

}
