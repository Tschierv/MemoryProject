package com.github.tschierv.memorygame.domain.Board;

import com.github.tschierv.memorygame.domain.Board.usecase.CreateBoard;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;

/**
 * Controller responsible for creating a board of the correct amount of cards.
 *
 */
public class BoardController {
    private CreateBoard createBoard;
    private CardController cardController;

    /**
     * Constructor of the BoardController class,
     * creates a new instance of the CreateBoard Usecase and stores it in a class variable.
     *
     * @param cardController the cardController that should be used,
     *                      to place cards onto the board.
     */
    public BoardController(CardController cardController){
        this.createBoard = new CreateBoard(cardController);
        this.cardController = cardController;
    }

    /**
     * Method which executs the CreateBoard usecase with the amount of cards wanted
     * @param card_slots    Amount of wanted cards as integer
     * @return              Returns a instance ot the Board class with the correct amount of cards
     */
    public Board createBoard(Integer card_slots){
        return createBoard.execute(card_slots);
    }
}
