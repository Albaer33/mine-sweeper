package com.codersdungeon.minesweeper.dtos;

import com.codersdungeon.minesweeper.entity.Board;
import com.codersdungeon.minesweeper.entity.Cell;
import com.codersdungeon.minesweeper.entity.Player;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseLoadGameDTO {
    private Integer boardId;
    private Integer rows;
    private Integer columns;
    private Integer totalMines;
    private Player player;
    private Integer time;
    private LocalDateTime startDate;
    private boolean won;
    private boolean lost;
    private Cell[][] cells;
}
