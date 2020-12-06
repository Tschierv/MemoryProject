package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;


public interface ICreatePlayer {
  void execute(Player player) throws PlayerAlreadyExistException;
}
