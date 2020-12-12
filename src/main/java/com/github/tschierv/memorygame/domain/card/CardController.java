package com.github.tschierv.memorygame.domain.card;

import com.github.tschierv.memorygame.domain.card.usecase.CreateCardPair;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

import java.util.ArrayList;

public class CardController {
    private CreateCardPair createCardPair;

    public CardController(ImageRepository imageRepository){
        createCardPair = new CreateCardPair(imageRepository);
    }

    public ArrayList<Card> createPair(){
        return createCardPair.execute();
    }
}
