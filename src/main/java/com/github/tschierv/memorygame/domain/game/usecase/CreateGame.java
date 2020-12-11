package com.github.tschierv.memorygame.domain.game.usecase;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.player.Player;

public class CreateGame implements ICreateGame{
    @Override
    public Game execute(Board game_board, Player player) {
        return new Game(game_board, player);
    }
}
