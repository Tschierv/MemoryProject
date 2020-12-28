package com.github.tschierv.memorygame.domain.card;

import com.github.tschierv.memorygame.domain.card.usecase.CompairCardPair;
import com.github.tschierv.memorygame.domain.card.usecase.CreateCardPair;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

import java.util.ArrayList;

public class CardController {
    private CreateCardPair createCardPair;
    private CompairCardPair compairCardPair;

    public CardController(ImageRepository imageRepository){
        createCardPair = new CreateCardPair(imageRepository);
        compairCardPair = new CompairCardPair();
    }

    public ArrayList<Card> createPair(){
        return createCardPair.execute();
    }

    public Boolean compairSelectedCards(Card firstSelectedCard, Card secondSelectedCard){
       return compairCardPair.execute(firstSelectedCard, secondSelectedCard);
    }
}
