package com.github.tschierv.memorygame.domain.game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.player.Player;

import java.util.ArrayList;
import java.util.List;
/**
 *  Game entity holding all the important stats for a game being played
 */
public class Game {
    public Board board;
    private Player player;
    public Integer counter;
    private List<Card> selectedCards;

    /**
     * Constructor for the game class
     *
     * @param board the gameboard holding all the cards used for game round
     * @param player the player which has been selected to play game round
     */
    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
        this.counter = 0;
        this.selectedCards = new ArrayList<Card>();
    }

    public String getPlayer() {
        return this.player.getAccountName();
    }

    public Integer getCounter(){
        return this.counter;
    }

    public void setCounter(Integer counter){
       this.counter = counter;
    }

    public void incrementCounterbyOne(){
        this.counter = this.counter + 1;
    }

    public List<Card> getSelectedCards() {
        return selectedCards;
    }

    public void setSelectedCard(Card selectedCards) {
        this.selectedCards.add(selectedCards);
    }

    public List<Card> getCards(){
        return this.board.getCardDeck();
    }
    public void clearSelectedCards(){
        this.selectedCards.clear();
    }

    /**
     * The amount of pairs multiplied by 20 gives us the possible score,
     * the amount of tries multiplied by 10 subtacted from the possible score gives us score
     *
     * @return Integer value of how much the Score should increment by
     */
    public Integer calculateScoreIncrement() {
        Integer tries = this.getCounter();
        Integer score = ((this.getCards().size() / 2) * 20 ) - (tries * 10);
        if (score <= 0){
            score = 10;
        }
        return score;
    }

}
