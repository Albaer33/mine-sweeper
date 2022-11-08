package com.codersdungeon.minesweeper.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="games")
@Data
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    @Column(name = "the_rows")
    private Integer rows;
    @Column(name = "the_columns")
    private Integer columns;
    @Column
    private Integer mines;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @Column
    private LocalDateTime startDate;
    @Column
    private Integer time;
    @Column
    private boolean won;
    @Column
    private boolean lost;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private Board board;

}
