package com.github.tschierv.memorygame.domain.player;

import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;
import com.github.tschierv.memorygame.domain.player.usecase.*;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;

import java.util.List;

public class PlayerController {
    private CreatePlayer createPlayer ;
    private GetPlayer getPlayer;
    private GetAllPlayers getAllPlayers;
    private GetAllPlayerNames getAllPlayerNames;

    public PlayerController(PlayerRepository playerRepository) {
        createPlayer = new CreatePlayer(playerRepository);
        getPlayer = new GetPlayerImp(playerRepository);
        getAllPlayers = new GetAllPlayers(playerRepository);
        getAllPlayerNames = new GetAllPlayerNames(playerRepository);
    }
    public void createPlayer(Player player) throws PlayerAlreadyExistException{
        createPlayer.execute(player);
    }
    public Player getPlayerbyName(String player_name) throws PlayerNotExistException {
        return getPlayer.execute(player_name);
    }

    public List<Player> getAllPlayers(){
        return getAllPlayers.execute();
    }

    public List<String> getAllPlayerNames(){
        return getAllPlayerNames.execute();
    }
}
