package com.github.tschierv.memorygame.domain.Board.usecase;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.card.usecase.CreateCardPair;

import java.util.ArrayList;

public class CreateBoard implements  ICreateBoard {
    private CardController cardController;
    public CreateBoard(CardController cardController){
        this.cardController = cardController;
    }
    @Override
    public Board execute(Integer card_slots) {
        ArrayList<Card> card_deck = new ArrayList<Card>();
        for (int i = 0; i < card_slots / 2; i++) {
            ArrayList<Card> pair = this.cardController.createPair();
            card_deck.addAll(pair);
        }
        Board game_board = new Board(card_slots, card_deck);
        return game_board;
    }
}