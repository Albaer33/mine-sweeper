package com.codersdungeon.minesweeper.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "cells")
@Data
@NoArgsConstructor
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "the_row")
    private Integer row;
    @Column(name = "the_column")
    private Integer column;
    @Column
    private Integer nearBombs;
    @Column
    private boolean flagged;
    @Column
    private boolean marked;
    @Column
    private boolean visited;
    @Column
    private boolean bomb;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

}
