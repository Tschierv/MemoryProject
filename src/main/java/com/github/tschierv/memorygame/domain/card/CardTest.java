package com.github.tschierv.memorygame.domain.card;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card testCard;
    Card wrongCard;
    Card wrightCard;

    @BeforeEach
    void setUp() {
        UUID testCardUuid = UUID.fromString("a7457dd1-e99e-4538-88aa-293c8f139de2");
        URL testCardImage = null;
        URL wrongCardImage = null;
        try {
            testCardImage = new URL("file://com/github/tschierv/memorygame/presentation/picture/Gnu.jpg");
            wrongCardImage = new URL("file://com/github/tschierv/memorygame/presentation/picture/Dragon.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        testCard = new Card(testCardImage, testCardUuid);
        wrongCard = new Card(wrongCardImage, UUID.randomUUID());
        wrightCard = new Card(testCardImage, testCardUuid);
    }

    @AfterEach
    void tearDown() {
        testCard = null;
    }

    @Test
    void getCardId() {
        UUID testUuid = UUID.fromString("a7457dd1-e99e-4538-88aa-293c8f139de2");
        Assert.assertTrue(testCard.getCardId().equals(testUuid));
    }

    @Test
    void isCardFaceSideUp() {
        assertTrue(testCard.isCardFaceSideUp() == false);
    }

    @Test
    void setCardFaceSideUp() {
        testCard.setCardFaceSideUp(true);
        assertTrue(testCard.isCardFaceSideUp() == true);
    }

    @Test
    void isequalCard() {
        UUID sameUuid = UUID.fromString("a7457dd1-e99e-4538-88aa-293c8f139de2");
        UUID wrongUuid = UUID.fromString("a8457dd1-e99e-4538-88aa-293c8f139de2");
        assertFalse(testCard.isequalCard(wrongCard));
        assertTrue(testCard.isequalCard(wrightCard));
    }
}