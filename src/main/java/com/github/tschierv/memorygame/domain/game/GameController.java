package com.github.tschierv.memorygame.domain.game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.Board.BoardController;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.card.usecase.CompairCardPair;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;

import java.util.List;
import java.util.UUID;

/**
 * The GameController Class manges/handles all the UseCases related to the game mechanics.
 */
public class GameController {
    private final PlayerController playerController;
    private final BoardController boardController;
    private Player selectedPlayer = null;
    private Game currentGame;
    private volatile boolean gameEnded = false;

    /**
     * Constructor for GameController, receives the needed controllers for handling
     * game related state.
     *
     * @param playerController  handles Player state (CRUD)
     * @param boardController   handles Board state
     */
    public GameController(PlayerController playerController, BoardController boardController){
        this.playerController = playerController;
        this.boardController = boardController;

    }

    /**
     * Create a new Game in the correct size for the defined player
     * @param player_name  name of the current player
     * @param GameSize     size of the gameboard, amount of cards wanted
     */
    public void createGameforPlayer(String player_name, Integer GameSize){
        Board board = boardController.createBoard(GameSize);
        Player player = null;
        try {
            player = playerController.getPlayerbyName(player_name);
        } catch (PlayerNotExistException e) {
            e.printStackTrace();
        }
        this.currentGame = new Game(board, player);
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

    public List<Player> getAllPlayersName(){
        return this.playerController.getAllPlayerwithScores();
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

    public Integer getcurrentCounter(){
        return this.currentGame.getCounter();
    }

    public Game getCurrentGame(){
        return this.currentGame;
    }
    public void setCurrentCounter(){
        this.getCurrentGame().incrementCounterbyOne();
    }

    /**
     *
     * @param selectedCards a list of the two selected Card objects
     * @return boolean value
     */
    public boolean ismatchingCardPair(List<Card> selectedCards){
        if(selectedCards.isEmpty()){
            return false;
        }
        CompairCardPair compairCardPair =  new CompairCardPair();
        Card firstCard = selectedCards.get(0);
        Card secondCard = selectedCards.get(1);
        return compairCardPair.execute(firstCard, secondCard);
    }
    public PlayerController getPlayerController(){
        return this.playerController;
    }

    public Integer getScoreIncrementby(){
       return this.currentGame.calculateScoreIncrement();
    }

    public void setNewPlayerScore(){
        Integer currentPlayerScore = this.getCurrentPlayer().getScore();
        Integer incrementScoreBy = this.getScoreIncrementby();
        playerController.setPlayerScore(this.getCurrentPlayer().getAccountName(), currentPlayerScore+incrementScoreBy);
    }

        public void setGameEnded(){
            this.gameEnded = true;
        }
        public boolean isGameEnded(){
            return this.gameEnded;
        }
}
