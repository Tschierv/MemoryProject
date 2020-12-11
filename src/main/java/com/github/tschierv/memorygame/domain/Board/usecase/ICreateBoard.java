package com.github.tschierv.memorygame.domain.Board.usecase;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.card.usecase.ICreateCardPair;

import java.util.ArrayList;

public interface ICreateBoard {
        Board execute(Integer card_slots);
    }

