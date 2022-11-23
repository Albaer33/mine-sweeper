package com.codersdungeon.minesweeper.controller;

import com.codersdungeon.minesweeper.dtos.ResponseDiscoverDTO;
import com.codersdungeon.minesweeper.dtos.ResponseFlagDTO;
import com.codersdungeon.minesweeper.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PutMapping("/board/{boardId}/cell/{row}/{column}/flag")
    public ResponseFlagDTO flagCell(@PathVariable Integer boardId, @PathVariable Integer row, @PathVariable Integer column) {

        ResponseFlagDTO dto = boardService.flagCell(boardId, row, column);

        return dto;

    }

    @PutMapping("/board/{boardId}/cell/{row}/{column}/discover")
    public ResponseDiscoverDTO discoverCell(@PathVariable Integer boardId, @PathVariable Integer row, @PathVariable Integer column) {

        ResponseDiscoverDTO dto = boardService.discoverCell(boardId, row, column);

        return dto;

    }

}
