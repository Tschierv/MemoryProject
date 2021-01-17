package com.github.tschierv.memorygame.domain.Board;

import com.github.tschierv.memorygame.domain.card.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Integer CardSlots;
    private ArrayList<Card> CardDeck;
    private Board testBoard;
    private UUID testCard1Uuid;
    private UUID testCard2Uuid;
    @BeforeEach
    void setUp() {
        CardSlots = 4;
        CardDeck = new ArrayList<>();
        testCard1Uuid = UUID.fromString("a7457dd1-e99e-4538-88aa-293c8f139de2");
        testCard2Uuid = UUID.fromString("b7457dd1-e99e-4538-88aa-293c8f139de2");
        URL testCardImage1 = null;
        URL testCardImage2 = null;
        try {
            testCardImage1 = new URL("file://com/github/tschierv/memorygame/presentation/picture/Gnu.jpg");
            testCardImage2 = new URL("file://com/github/tschierv/memorygame/presentation/picture/Hai.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // Adding two pairs of cards to Carddeck
        CardDeck.add(new Card(testCardImage1, testCard1Uuid));
        CardDeck.add(new Card(testCardImage1, testCard1Uuid));
        CardDeck.add(new Card(testCardImage2, testCard2Uuid));
        CardDeck.add(new Card(testCardImage2, testCard2Uuid));

        testBoard = new Board(CardSlots, CardDeck);
    }

    @AfterEach
    void tearDown() {
        CardDeck.clear();
    }

    @Test
    void getCardSlots() {
        assertTrue(testBoard.getCardSlots() == 4);
    }

    @Test
    void setCardSlots() {
        testBoard.setCardSlots(8);
        assertTrue(testBoard.getCardSlots() == 8);
    }

    @Test
    void getCardDeck() {
        assertTrue(testBoard.getCardDeck().size() == 4);
    }

}