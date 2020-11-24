package com.github.tschierv.memorygame.domain.enteties;

import java.util.List;
import java.util.UUID;

public class Board {
    public UUID BoardId;
    public Integer CardSlots;
    public List<Card> CardDeck;
    public Board(Integer CardSlots, List<Card> CardDeck) {
        this.BoardId =  UUID.randomUUID();
        this.CardSlots = CardSlots;
        this.CardDeck = CardDeck;
    }

    public Integer getCardSlots() {
        return CardSlots;
    }

    public void setCardSlots(Integer cardSlots) {
        CardSlots = cardSlots;
    }

    public List<Card> getCardDeck() {
        return CardDeck;
    }

    public void setCardDeck(List<Card> cardDeck) {
        CardDeck = cardDeck;
    }
}