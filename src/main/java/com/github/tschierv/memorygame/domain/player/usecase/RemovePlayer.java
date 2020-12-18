package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;

public class RemovePlayer implements IRemovePlayer {

    private final PlayerRepositoryService playerRepositoryService;

    public RemovePlayer(PlayerRepositoryService playerRepositoryService) {
        this.playerRepositoryService = playerRepositoryService;
    }

    @Override
    public void execute(String player_name) throws PlayerNotExistException {
        if (!playerRepositoryService.doesPlayerNameExists(player_name)) {
            throw new PlayerNotExistException("Player : " + player_name + " not found");
        }
        playerRepositoryService.removePlayer(player_name);

    }
}