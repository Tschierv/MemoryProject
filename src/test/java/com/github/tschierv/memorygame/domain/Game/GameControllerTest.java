package com.github.tschierv.memorygame.domain.Game;

import com.github.tschierv.memorygame.domain.Board.BoardController;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;
import com.github.tschierv.memorygame.persistence.repositories.PlayerJSONRepository;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    GameController testGameController;

    @BeforeEach
    void setUp() {
        PlayerRepositoryService player_repo = new PlayerRepository();
        PlayerController testPlayerController = new PlayerController(player_repo);
        CardController testCardController = new CardController(new ImageRepository("com/github/tschierv/memorygame/presentation/picture/**"));
        BoardController testBoardController = new BoardController(testCardController);
        UUID testPlayerUuid = UUID.fromString("57f74060-975b-4e8c-aee9-a621750a97b8");
        String testPlayerName = "testplayer";
        Player testPlayer = new Player(testPlayerName, testPlayerUuid);
        player_repo.savePlayer(testPlayer);
        testGameController = new GameController(testPlayerController, testBoardController);
    }

    @AfterEach
    void tearDown() {
        testGameController = null;
    }

    @Test
    void createGameforPlayer() {
    }

    @Test
    void getAllPlayers() {
    }

    @Test
    void setCurrentPlayer() {
        testGameController.setCurrentPlayer("testplayer");
        assertTrue(testGameController.getCurrentPlayer().getAccountName() == "testplayer");
    }

    @Test
    void getCurrentPlayer() {

    }

    @Test
    void unsetCurrentPlayer() {
    }

    @Test
    void getAllPlayersName() {
    }

    @Test
    void addPlayer() {
    }

    @Test
    void removePlayer() {
    }

    @Test
    void getcurrentCounter() {
    }

    @Test
    void getCurrentGame() {
    }

    @Test
    void setCurrentCounter() {
    }

    @Test
    void ismatchingCardPair() {
    }

    @Test
    void getPlayerController() {
    }

    @Test
    void getScoreIncrementby() {
    }

    @Test
    void setNewPlayerScore() {
    }

    @Test
    void setGameEnded() {
    }

    @Test
    void isGameEnded() {
    }
}