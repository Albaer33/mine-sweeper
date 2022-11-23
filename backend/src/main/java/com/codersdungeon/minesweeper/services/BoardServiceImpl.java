package com.codersdungeon.minesweeper.services;

import com.codersdungeon.minesweeper.dtos.ResponseDiscoverDTO;
import com.codersdungeon.minesweeper.dtos.ResponseFlagDTO;
import com.codersdungeon.minesweeper.repository.BoardRepository;
import com.codersdungeon.minesweeper.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CellRepository cellRepository;

    @Override
    public ResponseFlagDTO flagCell(Integer boardId, Integer row, Integer column) {
        return null;
    }

    @Override
    public ResponseDiscoverDTO discoverCell(Integer boardId, Integer row, Integer column) {
        return null;
    }

}
