package com.yaskovskyi.task5.model;

import lombok.Data;

@Data
public class GameInfo {

    private String gameId;
    private Player player1;
    private Player player2;
    private GameStatus status;
    private int[][] board;
    private Tic winner;

}
