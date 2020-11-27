package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;

public class CreatePlayerImp implements CreatePlayer{

    private final PlayerRepositoryService playerRepositoryService;

    public CreatePlayerImp(PlayerRepositoryService playerRepositoryService) {
        this.playerRepositoryService = playerRepositoryService;
    }

    @Override
    public void execute(Player player) throws PlayerAlreadyExistException {

        if(playerRepositoryService.doesPlayerNameExists(player.getAccountName())) {
            throw new PlayerAlreadyExistException("Player : " + player.getAccountName() + "already exists ");
        }

        playerRepositoryService.savePlayer(player);

    }
}
