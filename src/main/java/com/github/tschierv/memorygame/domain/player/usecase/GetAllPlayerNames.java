package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;

import java.util.ArrayList;
import java.util.List;

public class GetAllPlayerNames implements IGetAllPlayerNames {

    private final PlayerRepositoryService playerRepositoryService;

    public GetAllPlayerNames(PlayerRepositoryService playerRepositoryService) {
        this.playerRepositoryService = playerRepositoryService;
    }

    @Override
    public List<String> execute() {
        return new ArrayList<String>(this.playerRepositoryService.getAllPlayers().keySet());
    }
}