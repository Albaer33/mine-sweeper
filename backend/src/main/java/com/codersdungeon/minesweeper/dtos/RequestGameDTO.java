package com.codersdungeon.minesweeper.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGameDTO {

    private Integer rows;
    private Integer columns;
    private Integer mines;

}
