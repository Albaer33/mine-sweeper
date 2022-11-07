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
    @Column
    private Integer row;
    @Column
    private Integer column;
    @Column
    private Boolean flagged;
    @Column
    private Boolean marked;
    @Column
    private Boolean visited;
    @Column
    private Boolean bomb;
    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

}
