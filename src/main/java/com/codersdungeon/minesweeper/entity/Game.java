package com.codersdungeon.minesweeper.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer rows;
    @Column
    private Integer columns;
    @Column
    private Integer mines;
    @Column
    private Integer time;
    @Column
    private Boolean win;
    @Column
    private Boolean lost;
    @ManyToOne
    @JoinColumn(name = "playerId")
    private Player player;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "boardId")
    private Board board;

}
