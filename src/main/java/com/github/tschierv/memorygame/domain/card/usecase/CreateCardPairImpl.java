package com.github.tschierv.memorygame.domain.card.usecase;

import com.github.tschierv.memorygame.domain.card.Card;

import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class CreateCardPairImpl implements ICreateCardPair {
    @Override
    public ArrayList<Card> execute() {
        UUID card_id = UUID.randomUUID();
        ClassLoader cldr = this.getClass().getClassLoader();
        ArrayList<Card> cards = new ArrayList<>();;
        URL card_image = cldr.getResource("/memorygame/persistence/picture/Gazelle.jpg");
        Card card = new Card(card_image, card_id);
        cards.add(card);
        cards.add(card);
        return  cards;
    }
}
