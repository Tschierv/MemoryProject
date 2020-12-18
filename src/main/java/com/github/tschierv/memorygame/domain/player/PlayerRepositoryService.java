package com.github.tschierv.memorygame.domain.player;

import java.util.Map;

public interface PlayerRepositoryService {
    Map<String, Player> getAllPlayers();
    void savePlayer(Player player);
    Player getPlayer(String player_name);
    Boolean doesPlayerNameExists(String player_name);
    void removePlayer(String player_name);
}
