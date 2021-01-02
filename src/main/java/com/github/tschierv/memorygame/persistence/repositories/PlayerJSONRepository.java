package com.github.tschierv.memorygame.persistence.repositories;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PlayerJSONRepository implements PlayerRepositoryService {
    @Override
    public Map<String, Player> getAllPlayers() {
        System.out.println("this was called...oh yes");
        ObjectMapper objectreaderMapper = new ObjectMapper();
        Map<String, Player> players = null;
        File jsonFile = new File("./player.json");
        try {
            System.out.println("in try ");
            HashMap<String, Player> map = new HashMap<String, Player>();
            System.out.println("map created ");
            players = objectreaderMapper.readValue(jsonFile, new TypeReference<Map<String, Player>>(){});
            System.out.println("this was read from file: " + players);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public void savePlayer(Player player) {
        Map<String, Player> players = this.getAllPlayers();
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.writer(new DefaultPrettyPrinter());
        jsonMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        jsonMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        players.put(player.getAccountName(), player);
        try {
            jsonMapper.writeValue(Paths.get("player.json").toFile(), players);
            players.clear();
        } catch (IOException e) {
            players.clear();
            e.printStackTrace();
        }
    }

    @Override
    public Player getPlayer(String player_name) {
        Map<String, Player> players = this.getAllPlayers();
        return players.get(player_name);
    }

    @Override
    public Boolean doesPlayerNameExists(String player_name) {
        Map<String, Player> players = this.getAllPlayers();
        return players.containsKey(player_name);
    }
    @Override
    public void removePlayer(String player_name){
        Map<String, Player> players = this.getAllPlayers();
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.writer(new DefaultPrettyPrinter());
        jsonMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        jsonMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        players.remove(player_name);
        try {
            jsonMapper.writeValue(Paths.get("player.json").toFile(), players);
            players.clear();
        } catch (IOException e) {
            players.clear();
            e.printStackTrace();
        }

    }
}
