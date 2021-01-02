package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;

public class GetPlayerImp implements IGetPlayer {

    private final PlayerRepositoryService playerRepositoryService;

    public GetPlayerImp(PlayerRepositoryService playerRepositoryService) {
        this.playerRepositoryService = playerRepositoryService;
    }

    @Override
    public Player execute(String player_name) throws PlayerNotExistException {
        if (!playerRepositoryService.doesPlayerNameExists(player_name)) {
            throw new PlayerNotExistException("Player : " + player_name + " not found");
        }
        return playerRepositoryService.getPlayer(player_name);

    }
}