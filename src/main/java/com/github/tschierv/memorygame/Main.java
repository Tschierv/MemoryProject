package com.github.tschierv.memorygame;

import com.github.tschierv.memorygame.domain.Board.BoardController;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;
import com.github.tschierv.memorygame.persistence.repositories.PlayerJSONRepository;
import com.github.tschierv.memorygame.presentation.MainController;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import static javafx.scene.media.MediaPlayer.INDEFINITE;


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws PlayerAlreadyExistException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getClassLoader().getResource("com/github/tschierv/memorygame/presentation/MainView.fxml"));
		MainController mainController = new MainController(this.createGameController());
		fxmlLoader.setController(mainController);
		Parent MainViewParent = null;
		try {
			MainViewParent = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene MainViewScene = new Scene(MainViewParent);
		MainViewScene.getStylesheets().add(Main.class.getClassLoader().getResource("com/github/tschierv/memorygame/application/application.css").toExternalForm());
		primaryStage.setResizable(false);
		primaryStage.setScene(MainViewScene);
		primaryStage.setTitle("Animal Memory");
		primaryStage.show();
		final Task task = new Task() {

			@Override
			protected Object call() throws Exception {
				MediaPlayer mediaPlayer = getMediaPlayer();
				mediaPlayer.play();
				return null;
			}
		};
		Thread thread = new Thread(task);
		thread.start();
	}
    private GameController createGameController(){
		PlayerController playerController = this.createPlayerController();
		CardController cardController = new CardController(new ImageRepository("com/github/tschierv/memorygame/presentation/picture"));
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

	private MediaPlayer getMediaPlayer() {
		URL mediaUrl = getClass().getClassLoader().getResource("com/github/tschierv/memorygame/sound/safari_loop.mp3");
		String mediaStringUrl = mediaUrl.toExternalForm();
		Media media = new Media(mediaStringUrl);
		MediaPlayer player = null;
		try {
			player = new MediaPlayer(media);
		} catch (MediaException e) {
			System.out.println("Can't Play sound!");
		}
		if (player != null) {
			MediaPlayer finalPlayer = player;
			player.setOnEndOfMedia(new Runnable() {
				public void run() {
					finalPlayer.seek(Duration.ZERO);
				}
			});
			player = finalPlayer;
		}

		return player;
	}
}

