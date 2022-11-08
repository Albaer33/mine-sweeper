package com.codersdungeon.minesweeper.dtos;

import com.codersdungeon.minesweeper.entity.Board;
import com.codersdungeon.minesweeper.entity.Cell;
import com.codersdungeon.minesweeper.entity.Player;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseGameDTO {

    private Integer gameId;
    private Integer rows;
    private Integer columns;
    private Integer mines;
    private Player player;
    private LocalDateTime startDate;
    private Integer time;
    private boolean won;
    private boolean lost;
    private Board board;
    private List<Cell> cellList;

}
