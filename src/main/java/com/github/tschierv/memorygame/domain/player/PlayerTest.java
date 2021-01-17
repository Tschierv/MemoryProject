package com.github.tschierv.memorygame.domain.player;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player testPlayer;

    @BeforeEach
    void setUp() {
        UUID testPlayerUuid = UUID.fromString("57f74060-975b-4e8c-aee9-a621750a97b8");
        String testPlayerName = "testplayer";
        testPlayer = new Player(testPlayerName, testPlayerUuid);
        testPlayer.setScore(10);
    }

    @AfterEach
    void tearDown() {
        testPlayer = null;
    }

    @Test
    void getAccountName() {
        Assert.assertTrue(this.testPlayer.getAccountName() == "testplayer");
    }

    @Test
    void getAccountId() {
        UUID testUuid =  UUID.fromString("57f74060-975b-4e8c-aee9-a621750a97b8");
        Assert.assertTrue(this.testPlayer.getAccountId().equals(testUuid));
    }

    @Test
    void getScore(){
        Assert.assertTrue(this.testPlayer.getScore() == 10);
    }

}