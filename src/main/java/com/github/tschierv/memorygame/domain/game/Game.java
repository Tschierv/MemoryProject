package com.github.tschierv.memorygame.domain.game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        this.counter = this.counter + 1;
    }

    public List<Card> getSelectedCards() {
        return selectedCards;
    }

    public void setSelectedCard(Card selectedCards) {
        this.selectedCards.add(selectedCards);
    }
    public boolean ismatchingCardPair(){
        if(selectedCards.isEmpty())
            return false;
        UUID firstId = getSelectedCards().get(0).getCardId();
        System.out.println("firstId is : "+ firstId);
        System.out.println("second id is : "+ getSelectedCards().stream().allMatch(x -> x.getCardId() == firstId));
        return getSelectedCards().stream().allMatch(x -> x.getCardId() == firstId);
    }
    public void selectCard(Card selectedCard) {
        if(getSelectedCards().stream().anyMatch(x -> x.getCardId().equals(selectedCard.getCardId())))
            return;
        System.out.println("currently selected : " + getSelectedCards().size());
        System.out.println("You selected : " + selectedCard);
        setSelectedCard(selectedCard);
        System.out.println("now selected : " + getSelectedCards().size());
        if(getSelectedCards().size() == 2 && !ismatchingCardPair()){
            System.out.println("counter befor: " + getCounter());
            incrementCounterbyOne();
            System.out.println("counter after: " + getCounter());
            selectedCards.clear();
            System.out.println("cleared selectedCards " + selectedCards.size());
        }
        System.out.println("counter : " + getCounter());
    }
}
