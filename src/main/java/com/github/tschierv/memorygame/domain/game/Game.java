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

    public boolean ismatchingCardPair(){
        if(getSelectedCards().isEmpty()) {
            return false;
        }
        UUID firstId = getSelectedCards().get(0).getCardId();
        UUID secondId = getSelectedCards().get(1).getCardId();
        return firstId.equals(secondId);
    }

    public void selectCard(Card selectedCard) {
        // Already face up
        if(selectedCard.isCardFaceSideUp()) {
            System.out.println("already face up : " + selectedCard.getCardId() + " " + selectedCard.isCardFaceSideUp());
            return;
        }
        // Not allow selecting card twice
        if(getSelectedCards().stream().anyMatch(x ->x.cardObjectId.equals(selectedCard.cardObjectId))) {
            return;
        }

        setSelectedCard(selectedCard);

        // Selected pair is not correct
        if(getSelectedCards().size() == 2 && !ismatchingCardPair()){
            System.out.println("not correct pair : " + getSelectedCards());
            incrementCounterbyOne();
            this.selectedCards.clear();
        }
        if(getSelectedCards().size() == 2 && ismatchingCardPair()){
            System.out.println("correct pair : " + getSelectedCards());
            selectedCard.setCardFaceSideUp(true);
            this.board.getCardDeck().stream().filter(x -> x.getCardId().equals(selectedCard.getCardId())).forEach(x -> x.setCardFaceSideUp(true));
            selectedCards.clear();
        }
    }
}
