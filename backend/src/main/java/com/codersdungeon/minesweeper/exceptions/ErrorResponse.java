package com.codersdungeon.minesweeper.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;
    private String timeStamp;

}
