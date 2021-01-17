package com.github.tschierv.memorygame.domain.Board;

import com.github.tschierv.memorygame.domain.card.Card;

import java.util.ArrayList;
import java.util.UUID;

public class Board {
    public UUID BoardId;
    public Integer CardSlots;
    public ArrayList<Card> CardDeck;

    public Board(Integer CardSlots, ArrayList<Card> CardDeck) {
        this.BoardId =  UUID.randomUUID();
        this.CardSlots = CardSlots;
        this.CardDeck = CardDeck;
    }

    public Integer getCardSlots() {
        return this.CardSlots;
    }

    public void setCardSlots(Integer cardSlots) {
        this.CardSlots = cardSlots;
    }

    public ArrayList<Card> getCardDeck() {
        return this.CardDeck;
    }

    public void setCardDeck(ArrayList<Card> cardDeck) {
        this.CardDeck = cardDeck;
    }
}