package com.github.tschierv.memorygame.domain.Game;

import com.github.tschierv.memorygame.domain.Board.Board;
import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.player.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Integer CardSlots;
    private ArrayList<Card> CardDeck;
    private Board testBoard;
    private UUID testCard1Uuid;
    private UUID testCard2Uuid;
    private Player testPlayer;
    private Game testGame;

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
        UUID testPlayerUuid = UUID.fromString("57f74060-975b-4e8c-aee9-a621750a97b8");
        String testPlayerName = "testplayer";
        testPlayer = new Player(testPlayerName, testPlayerUuid);
        testGame = new Game(testBoard, testPlayer);
    }

    @AfterEach
    void tearDown() {
        testGame = null;
    }

    @Test
    void getPlayer() {
        Assert.assertTrue(testGame.getPlayer() == "testplayer");
    }

    @Test
    void getCounter() {
        Assert.assertTrue(testGame.getCounter() == 0);
    }

    @Test
    void setCounter() {
        testGame.setCounter(6);
        Assert.assertTrue(testGame.getCounter() == 6);
    }

    @Test
    void incrementCounterbyOne() {
        testGame.setCounter(6);
        testGame.incrementCounterbyOne();
        System.out.println(testGame.getCounter());
        Assert.assertTrue(testGame.getCounter() == 7);
    }

    @Test
    void getSelectedCards() {
        Assert.assertTrue(testGame.getSelectedCards().size() == 0);
    }

    @Test
    void setSelectedCard() {
        Card selectedCard = testBoard.getCardDeck().get(1);
        testGame.setSelectedCard(selectedCard);
        Assert.assertTrue(testGame.getSelectedCards().size() == 1);
    }

    @Test
    void getCards() {
        Assert.assertTrue(testGame.getCards().size() == 4);
    }

    @Test
    void clearSelectedCards() {
        Card selectedCard = testBoard.getCardDeck().get(1);
        testGame.setSelectedCard(selectedCard);
        Assert.assertTrue(testGame.getSelectedCards().size() == 1);
        testGame.clearSelectedCards();
        Assert.assertTrue(testGame.getSelectedCards().size() == 0);
    }

}