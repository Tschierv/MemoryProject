package com.github.tschierv.memorygame;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;

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

        ImageRepository image_repo = new ImageRepository("src/main/resources/com/github/tschierv/memorygame/presentation/picture");

        GameController gameController = new GameController(player_controller);
        Game game = gameController.createGameforPlayer16("Root");
        Card card_one = game.board.getCardDeck().get(1);
        for (int i = 0; i < game.board.getCardDeck().size(); i++) {
            System.out.println("card image is: " + game.board.getCardDeck().get(i).getCardImage());
        }
    }
}

