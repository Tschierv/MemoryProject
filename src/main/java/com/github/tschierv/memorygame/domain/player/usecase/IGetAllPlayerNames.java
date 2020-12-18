package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;

import java.util.List;


public interface IGetAllPlayerNames {
    List<String> execute();
}