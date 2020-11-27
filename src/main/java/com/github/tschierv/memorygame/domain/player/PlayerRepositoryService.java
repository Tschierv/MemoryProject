package com.github.tschierv.memorygame.domain.player;

import java.util.Collection;

import com.github.tschierv.memorygame.domain.player.Player;

public interface PlayerRepositoryService {
    Collection<Player> getAllPlayers();
    void savePlayer(Player player);
    Player getPlayer();
    Boolean doesPlayerNameExists(String name);
}
