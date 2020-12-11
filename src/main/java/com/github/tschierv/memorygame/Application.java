package com.github.tschierv.memorygame;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.Board.usecase.CreateBoard;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.card.usecase.CreateCardPairImpl;
import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Application {
    public static void main(String[] args) throws PlayerAlreadyExistException {
        System.out.println("Create PlayerRepository");
        Player player_a = new Player("Alf", UUID.randomUUID());
        Player player_b = new Player("Rolf", UUID.randomUUID());
        Player player_c = new Player("Gandalf", UUID.randomUUID());
        Player player_d = new Player("Root", UUID.randomUUID());

        PlayerRepository player_repo = new PlayerRepository();
        PlayerController player_controller = new PlayerController(player_repo);

        player_controller.createPlayer(player_a);
        player_controller.createPlayer(player_b);
        player_controller.createPlayer(player_c);
        player_controller.createPlayer(player_d);


        GameController gameController = new GameController(player_controller);
        Game game = gameController.createGameforPlayer16("Root");
        Card card_one = game.board.getCardDeck().get(1);
        System.out.println(game);
        System.out.println(game.getPlayer());
        System.out.println("There are " + game.board.getCardSlots() +" slots in this board");
        System.out.println(game.board.getCardDeck().size());
    }
}

