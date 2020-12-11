package com.github.tschierv.memorygame.domain.game.usecase;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.player.Player;

public interface ICreateGame {
    Game execute(Board game_board, Player player);
}
