package com.github.tschierv.memorygame.domain.game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.Board.BoardController;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.card.IImageRepositoryService;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

import java.util.List;
import java.util.UUID;

public class GameController {
    private PlayerController playerController;
    private BoardController boardController;
    private Player selectedPlayer = null;
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
    public Game createGameforPlayer36(String player_name){
        Board board = boardController.createBoard(36);
        Player player = null;
        try {
            player = playerController.getPlayerbyName(player_name);
        } catch (PlayerNotExistException e) {
            e.printStackTrace();
        }
        return new Game(board, player);
    }
    public Game createGameforPlayer100(String player_name){
        Board board = boardController.createBoard(100);
        this.cardController = new CardController(new ImageRepository("src/main/resources/com/github/tschierv/memorygame/presentation/picture10"));
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

    public List<Player> getAllPlayers(){
       return this.playerController.getAllPlayers();
    }

    public void setCurrentPlayer(String player){
        try {
            this.selectedPlayer = this.playerController.getPlayerbyName(player);
        } catch (PlayerNotExistException e) {
            e.printStackTrace();
        }
    }
    public Player getCurrentPlayer(){
        return this.selectedPlayer;
    }

    public void unsetCurrentPlayer(){
        this.selectedPlayer = null;
    }

    public List<String> getAllPlayersName(){
        return this.playerController.getAllPlayerNames();
    }

    public void addPlayer(String playerName){
        try {
            this.playerController.createPlayer(new Player(playerName, UUID.randomUUID()));
        } catch (PlayerAlreadyExistException e) {
            e.printStackTrace();
        }
    }
    public void removePlayer(String playerName){
        this.playerController.removePlayer(playerName);
    }

}
