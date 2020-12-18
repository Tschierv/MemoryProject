package com.github.tschierv.memorygame.persistence.repositories;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;

import java.util.HashMap;
import java.util.Map;

public class PlayerRepository implements PlayerRepositoryService {
    Map<String, Player> players = new HashMap<>();

    @Override
    public Map<String, Player> getAllPlayers() {
        return this.players;
    }

    @Override
    public void savePlayer(Player player) {
        this.players.put(player.getAccountName(),player);
    }

    @Override
    public Player getPlayer(String player_name) {
        return this.players.get(player_name);
    }

    @Override
    public Boolean doesPlayerNameExists(String player_name) {
        return this.players.containsKey(player_name);
    }
    @Override
    public void removePlayer(String player_name){
        this.players.remove(player_name);
    }
}
