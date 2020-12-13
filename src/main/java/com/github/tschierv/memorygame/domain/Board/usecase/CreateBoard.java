package com.github.tschierv.memorygame.domain.Board.usecase;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.card.usecase.CreateCardPair;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class CreateBoard implements  ICreateBoard {
    private CardController cardController;

    public CreateBoard(CardController cardController) {
        this.cardController = cardController;
    }

    @Override
    public Board execute(Integer card_slots) {
        ArrayList<Card> card_deck = new ArrayList<Card>();
        for (card_deck.size(); card_deck.size() < card_slots;) {
            ArrayList<Card> pair = this.cardController.createPair();
            if (card_deck.stream().anyMatch(o -> o.getCardImage().equals(pair.get(0).getCardImage()))) {
                continue;
            }
            card_deck.addAll(pair);

        }
        return new Board(card_slots, card_deck);
    }
}