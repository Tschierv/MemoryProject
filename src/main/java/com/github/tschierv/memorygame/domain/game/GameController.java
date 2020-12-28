package com.github.tschierv.memorygame.domain.game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.Board.BoardController;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.card.IImageRepositoryService;
import com.github.tschierv.memorygame.domain.card.usecase.CompairCardPair;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.domain.player.exception.PlayerNotExistException;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

import java.util.List;
import java.util.UUID;

public class GameController {
    private final PlayerController playerController;
    private final BoardController boardController;
    private Player selectedPlayer = null;
    private Game currentGame;

    public GameController(PlayerController playerController, BoardController boardController){
        this.playerController = playerController;
        this.boardController = boardController;

    }
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

    public List<Card> getallCards(){
        return this.currentGame.getCards();
    }

    public Integer getcurrentCounter(){
        System.out.println("get counter : " + this.currentGame.getCounter());
        return this.currentGame.getCounter();
    }

    public Game getCurrentGame(){
        return this.currentGame;
    }

    public boolean ismatchingCardPair(){
        if(this.getCurrentGame().getSelectedCards().isEmpty()){
            return false;
        }
        CompairCardPair compairCardPair =  new CompairCardPair();
        Card firstCard = this.getCurrentGame().getSelectedCards().get(0);
        Card secondCard = this.getCurrentGame().getSelectedCards().get(1);
        return compairCardPair.execute(firstCard, secondCard);
    }

    public void selectCard(Card selectedCard) {
        // Already face up
        List<Card> currentlySelectedCards = this.getCurrentGame().getSelectedCards();
        if(selectedCard.isCardFaceSideUp()) {
            System.out.println("already face up : " + selectedCard.getCardId() + " " + selectedCard.isCardFaceSideUp());
            return;
        }
        // Not allow selecting card twice
        if(currentlySelectedCards.stream().anyMatch(x ->x.cardObjectId.equals(selectedCard.cardObjectId))) {
            return;
        }
        System.out.println("this is the bevor sel size: " + this.getCurrentGame().getSelectedCards().size());
        this.getCurrentGame().setSelectedCard(selectedCard);
        System.out.println("this is the current sel size: " + this.getCurrentGame().getSelectedCards().size());
        // Selected pair is not correct
        if(currentlySelectedCards.size() == 2 && !ismatchingCardPair()){
            System.out.println("not correct pair : " + currentlySelectedCards);
            this.getCurrentGame().incrementCounterbyOne();
            currentlySelectedCards.clear();
            this.getCurrentGame().clearSelectedCards();
        }
        if(currentlySelectedCards.size() == 2 && ismatchingCardPair()){
            System.out.println("correct pair : " + currentlySelectedCards);
            selectedCard.setCardFaceSideUp(true);
            this.getallCards().stream().filter(x -> x.getCardId().equals(selectedCard.getCardId())).forEach(x -> x.setCardFaceSideUp(true));
            currentlySelectedCards.clear();
            this.getCurrentGame().clearSelectedCards();
        }
    }
}
