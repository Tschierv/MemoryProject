package com.github.tschierv.memorygame.domain.card.usecase;


import com.github.tschierv.memorygame.domain.card.Card;

public interface ICompareCardPair {
    Boolean execute(Card firstSelectedCard, Card secondSelectedCard);
}