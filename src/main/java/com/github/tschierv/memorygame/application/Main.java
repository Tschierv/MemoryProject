package com.github.tschierv.memorygame.application;

import java.io.IOException;
import java.util.UUID;

import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws PlayerAlreadyExistException {
		PlayerController playerController = this.createPlayerController();
		GameController gameController = this.createGameController(playerController);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainView.fxml"));
		MainController mainController = new MainController(gameController);
		fxmlLoader.setController(mainController);
		Parent MainViewParent = null;
		try {
			MainViewParent = (Parent)fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene MainViewScene = new Scene(MainViewParent);
	    primaryStage.setResizable(false);
	    primaryStage.setScene(MainViewScene);
	    primaryStage.setTitle ("Animal Memory");
		primaryStage.show();
	}
	private PlayerController createPlayerController() throws PlayerAlreadyExistException {
		Player player_d = new Player("Root", UUID.randomUUID());
		Player player_b = new Player("Rolf", UUID.randomUUID());
		PlayerRepository player_repo = new PlayerRepository();
		PlayerController playerController = new PlayerController(player_repo);
		playerController.createPlayer(player_d);
		playerController.createPlayer(player_b);
		return playerController;
	}

	private GameController createGameController(PlayerController playerController) {
	    return new GameController(playerController);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

