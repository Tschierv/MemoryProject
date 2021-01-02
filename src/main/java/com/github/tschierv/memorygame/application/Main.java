package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.Board.BoardController;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;
import com.github.tschierv.memorygame.persistence.repositories.PlayerJSONRepository;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;
import com.github.tschierv.memorygame.presentation.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws PlayerAlreadyExistException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../presentation/MainView.fxml"));
		MainController mainController = new MainController(this.createGameController());
		fxmlLoader.setController(mainController);
		Parent MainViewParent = null;
		try {
			MainViewParent = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene MainViewScene = new Scene(MainViewParent);
		primaryStage.setResizable(false);
		primaryStage.setScene(MainViewScene);
		primaryStage.setTitle("Animal Memory");
		primaryStage.show();
	}
    private GameController createGameController(){
		PlayerController playerController = this.createPlayerController();
		CardController cardController = new CardController(new ImageRepository("src/main/resources/com/github/tschierv/memorygame/presentation/picture"));
		BoardController boardController = new BoardController(cardController);
		return new GameController(playerController, boardController);
	}
	private PlayerController createPlayerController()  {
		Player player_d = new Player("Root", UUID.randomUUID());
		Player player_b = new Player("Rolf", UUID.randomUUID());
		PlayerRepositoryService player_repo = new PlayerJSONRepository();
		PlayerController playerController = new PlayerController(player_repo);
		try {
			playerController.createPlayer(player_d);
			playerController.createPlayer(player_b);
		} catch (PlayerAlreadyExistException e) {
			e.printStackTrace();
		}
		return playerController;
	}

}

