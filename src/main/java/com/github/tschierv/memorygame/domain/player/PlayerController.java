package com.github.tschierv.memorygame.domain.player;

import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;
import com.github.tschierv.memorygame.domain.player.usecase.*;

import java.util.List;

public class PlayerController {
    private final CreatePlayer createPlayer;
    private final IGetPlayer getPlayer;
    private GetAllPlayers getAllPlayers;
    private GetAllPlayerNames getAllPlayerNames;
    private RemovePlayer removePlayer;
    private SetScore setScore;

    public PlayerController(PlayerRepositoryService playerRepository) {
        createPlayer = new CreatePlayer(playerRepository);
        getPlayer = new GetPlayerImp(playerRepository);
        getAllPlayers = new GetAllPlayers(playerRepository);
        getAllPlayerNames = new GetAllPlayerNames(playerRepository);
        removePlayer = new RemovePlayer(playerRepository);
        setScore = new SetScore(playerRepository);
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

    public List<Player> getAllPlayerwithScores(){
        return getAllPlayers.execute();
    }

    public void setPlayerScore(String player_name, Integer score){
        this.setScore.execute(player_name, score);
    }

    public void removePlayer(String player_name){
        try {
            removePlayer.execute(player_name);
        } catch (PlayerNotExistException e) {
            e.printStackTrace();
        }
    }
}
