package com.github.tschierv.memorygame.domain.card.usecase;


import com.github.tschierv.memorygame.domain.card.Card;

import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public interface ICreateCardPair {
    ArrayList<Card> execute();
}