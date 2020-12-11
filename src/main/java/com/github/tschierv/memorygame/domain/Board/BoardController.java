package com.github.tschierv.memorygame.domain.Board;

import com.github.tschierv.memorygame.domain.Board.usecase.CreateBoard;

public class BoardController {
    private CreateBoard createBoard;

    public BoardController(){
        this.createBoard = new CreateBoard();
    }

    public BoardController(CreateBoard createBoard){
        this.createBoard = createBoard;
    }

    public Board createBoard(Integer card_slots){
        return createBoard.execute(card_slots);
    }
}
