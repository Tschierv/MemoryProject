package com.github.tschierv.memorygame.domain.card.usecase;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class CompairCardPair implements ICompareCardPair {

    public CompairCardPair() {}
    @Override
    public Boolean execute(Card firstSelectedCard, Card secondSelectedCard) {
        return firstSelectedCard.isequalCard(secondSelectedCard);
    }
}
