package com.github.tschierv.memorygame;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;

public class Application {
    public static void main(String[] args) throws PlayerAlreadyExistException {
        System.out.println("Create PlayerRepository");
        Player player_a = new Player("Alf", UUID.randomUUID(), UUID.randomUUID());
        Player player_b = new Player("Rolf", UUID.randomUUID(), UUID.randomUUID());
        Player player_c = new Player("Gandalf", UUID.randomUUID(), UUID.randomUUID());
        Player player_d = new Player("Root", UUID.randomUUID(), UUID.randomUUID());

        PlayerRepository player_repo = new PlayerRepository();
        PlayerController player_controller = new PlayerController(player_repo);

        player_controller.createPlayer(player_a);
        player_controller.createPlayer(player_b);
        player_controller.createPlayer(player_c);
        player_controller.createPlayer(player_d);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = null;
        try {
            json = mapper.writeValueAsString(player_controller.getPlayerbyName("Root"));
        } catch (JsonProcessingException | PlayerNotExistException e) {
            e.printStackTrace();
        }
        System.out.println("this is " + json);
    }
}

