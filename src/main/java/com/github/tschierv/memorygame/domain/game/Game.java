package com.github.tschierv.memorygame.domain.game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.player.Player;

public class Game {
    public Board board;
    public Player player;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public String getPlayer() {
        return this.player.getAccountName();
    }
}
