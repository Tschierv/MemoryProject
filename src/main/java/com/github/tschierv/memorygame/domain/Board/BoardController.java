package com.github.tschierv.memorygame.domain.Board;

import com.github.tschierv.memorygame.domain.Board.usecase.CreateBoard;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

public class BoardController {
    private CreateBoard createBoard;
    private CardController cardController;

    public BoardController(CardController cardController){
        this.createBoard = new CreateBoard(cardController);
        this.cardController = cardController;
    }

    public BoardController(CreateBoard createBoard){
        this.createBoard = createBoard;
    }

    public BoardController(ImageRepository imageRepository) {
    }

    public Board createBoard(Integer card_slots){
        return createBoard.execute(card_slots);
    }
}
