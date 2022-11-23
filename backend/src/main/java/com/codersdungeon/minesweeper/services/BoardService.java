package com.codersdungeon.minesweeper.services;

import com.codersdungeon.minesweeper.dtos.ResponseDiscoverDTO;
import com.codersdungeon.minesweeper.dtos.ResponseFlagDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface BoardService {

    ResponseFlagDTO flagCell(Integer boardId, Integer row, Integer column);
    ResponseDiscoverDTO discoverCell(@PathVariable Integer boardId, @PathVariable Integer row, @PathVariable Integer column);

}
