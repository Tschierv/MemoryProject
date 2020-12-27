package com.github.tschierv.memorygame.domain.game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Board board;
    private Player player;
    public Integer counter;
    private long startTime = 0L;
    private long endTime = 0L;
    private List<Card> selectedCards;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
        this.counter = 0;
        this.selectedCards = new ArrayList<Card>();
    }

    public String getPlayer() {
        return this.player.getAccountName();
    }
    public void setStartTime(){
        this.startTime = System.currentTimeMillis();
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }
    public long getStarTime(){
        return this.startTime;
    }

    public long getEndTime(){
        return this.endTime;
    }
    public Integer getCounter(){
        return this.counter;
    }

    public void setCounter(Integer counter){
       this.counter = counter;
    }

    public void incrementCounterbyOne(){
        this.counter++;
    }

    public List<Card> getSelectedCards() {
        return selectedCards;
    }

    public void setSelectedCards(Card selectedCards) {
        this.selectedCards.add(selectedCards);
    }
}
