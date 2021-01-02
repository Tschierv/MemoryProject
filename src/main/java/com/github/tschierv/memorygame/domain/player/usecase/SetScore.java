package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;

import java.util.ArrayList;
import java.util.List;

public class SetScore {

    private final PlayerRepositoryService playerRepositoryService;

    public SetScore(PlayerRepositoryService playerRepositoryService) {
        this.playerRepositoryService = playerRepositoryService;
    }

    public void execute(String player_name, Integer score) {
        this.playerRepositoryService.setScore(player_name, score);
    }
}