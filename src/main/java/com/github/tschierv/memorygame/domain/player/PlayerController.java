package com.github.tschierv.memorygame.domain.player;

import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;
import com.github.tschierv.memorygame.domain.player.usecase.CreatePlayer;
import com.github.tschierv.memorygame.domain.player.usecase.GetPlayer;
import com.github.tschierv.memorygame.domain.player.usecase.GetPlayerImp;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;

public class PlayerController {
    private CreatePlayer createPlayer ;
    private GetPlayer getPlayer;

    public PlayerController(PlayerRepository playerRepository) {
        createPlayer = new CreatePlayer(playerRepository);
        getPlayer = new GetPlayerImp(playerRepository);
    }
    public void createPlayer(Player player) throws PlayerAlreadyExistException{
        createPlayer.execute(player);
    }
    public Player getPlayerbyName(String player_name) throws PlayerNotExistException {
        return getPlayer.execute(player_name);
    }
}
