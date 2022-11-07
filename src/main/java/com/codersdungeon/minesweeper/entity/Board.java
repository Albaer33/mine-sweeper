package com.codersdungeon.minesweeper.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "boards")
@Data
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Cell> cellList;
    @OneToOne
    @JoinColumn(name = "gameId")
    private Game game;

}
