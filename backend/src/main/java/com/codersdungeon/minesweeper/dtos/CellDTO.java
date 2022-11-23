package com.codersdungeon.minesweeper.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CellDTO {

    private Integer row;
    private Integer column;
    private Integer nearBombs;
    private boolean flagged;
    private boolean marked;
    private boolean visited;
    private boolean bomb;

}
