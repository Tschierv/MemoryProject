package com.github.tschierv.memorygame.domain.card.usecase;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class CreateCardPair implements ICreateCardPair {
    ImageRepository imageRepository;

    public CreateCardPair(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    @Override
    public ArrayList<Card> execute() {
        UUID card_id = UUID.randomUUID();
        ArrayList<Card> cards = new ArrayList<>();;
        URL card_image = this.imageRepository.getRandomImage();
        Card card = new Card(card_image, card_id);
        cards.add(card);
        cards.add(card);
        return  cards;
    }
}
