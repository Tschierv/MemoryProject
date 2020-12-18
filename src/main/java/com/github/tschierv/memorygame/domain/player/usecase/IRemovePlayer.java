package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;


public interface IRemovePlayer {
    void execute(String player_name) throws PlayerNotExistException;
}