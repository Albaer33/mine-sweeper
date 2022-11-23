package com.codersdungeon.minesweeper.dtos;

import com.codersdungeon.minesweeper.entity.Cell;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseDiscoverDTO {

    private boolean lost;
    private boolean won;
    private List<CellDTO> cellList;

}
