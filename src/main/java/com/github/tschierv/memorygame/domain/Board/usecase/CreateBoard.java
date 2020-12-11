package com.github.tschierv.memorygame.domain.Board.usecase;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.card.usecase.CreateCardPairImpl;
import com.github.tschierv.memorygame.domain.card.usecase.ICreateCardPair;

import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class CreateBoard implements  ICreateBoard {
    @Override
    public Board execute(Integer card_slots) {
        ArrayList<Card> card_deck = new ArrayList<Card>();
        for (int i = 0; i < card_slots / 2; i++) {
            ArrayList<Card> pair = new CreateCardPairImpl().execute();
            card_deck.addAll(pair);
        }
        Board game_board = new Board(card_slots, card_deck);
        return game_board;
    }
}