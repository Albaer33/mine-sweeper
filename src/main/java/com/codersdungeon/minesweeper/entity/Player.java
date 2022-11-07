package com.codersdungeon.minesweeper.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;
    @Column
    private String username;
    @Column
    private String password;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Game> games;

}
