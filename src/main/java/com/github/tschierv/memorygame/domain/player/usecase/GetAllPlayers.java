package com.github.tschierv.memorygame.domain.player.usecase;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;

import java.util.ArrayList;
import java.util.List;

public class GetAllPlayers implements IGetAllPlayers {

    private final PlayerRepositoryService playerRepositoryService;

    public GetAllPlayers(PlayerRepositoryService playerRepositoryService) {
        this.playerRepositoryService = playerRepositoryService;
    }

    @Override
    public List<Player> execute() {
        System.out.println("Player getplayer: "+ this.playerRepositoryService.getAllPlayers());
        return new ArrayList<Player>(this.playerRepositoryService.getAllPlayers().values());
    }
}