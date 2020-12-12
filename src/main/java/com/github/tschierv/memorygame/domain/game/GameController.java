package com.github.tschierv.memorygame.domain.game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.Board.BoardController;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.card.IImageRepositoryService;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

public class GameController {
    private PlayerController playerController;
    private BoardController boardController;
    private CardController cardController= new CardController(new ImageRepository("src/main/resources/com/github/tschierv/memorygame/presentation/picture"));

    public GameController(PlayerController playerController){
        this.playerController = playerController;
        boardController = new BoardController(this.cardController);
    }
    public Game createGameforPlayer16(String player_name){
        Board board = boardController.createBoard(16);
        Player player = null;
        try {
            player = playerController.getPlayerbyName(player_name);
        } catch (PlayerNotExistException e) {
            e.printStackTrace();
        }
        return new Game(board, player);
    }
    public Game createGameforPlayer(String player_name, Integer card_slots){
        Board board = boardController.createBoard(16);
        Player player = null;
        try {
            player = playerController.getPlayerbyName(player_name);
        } catch (PlayerNotExistException e) {
            e.printStackTrace();
        }
        return new Game(board, player);
    }
}
