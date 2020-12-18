package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;

import java.util.List;


public interface IGetAllPlayers {
    List<Player> execute();
}