package com.github.tschierv.memorygame;

import com.github.tschierv.memorygame.domain.Board.BoardController;
import com.github.tschierv.memorygame.domain.card.CardController;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.PlayerRepositoryService;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.persistence.repositories.ImageRepository;
import com.github.tschierv.memorygame.persistence.repositories.PlayerJSONRepository;
import com.github.tschierv.memorygame.presentation.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;


public class Main extends Application {
	MediaPlayer player = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws PlayerAlreadyExistException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/github/tschierv/memorygame/presentation/MainView.fxml"));
		MainController mainController = new MainController(this.createGameController());
		fxmlLoader.setController(mainController);
		Parent MainViewParent = null;
		try {
			MainViewParent = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene MainViewScene = new Scene(MainViewParent);
		MainViewScene.getStylesheets().add(getClass().getClassLoader().getResource("com/github/tschierv/memorygame/application/application.css").toExternalForm());
		primaryStage.setResizable(false);
		primaryStage.setScene(MainViewScene);
		primaryStage.setTitle("Animal Memory");
		primaryStage.show();
		MediaPlayer mediaPlayer = getMediaPlayer();
		mediaPlayer.play();
	}
    private GameController createGameController(){
		PlayerController playerController = this.createPlayerController();
		CardController cardController = new CardController(new ImageRepository("com/github/tschierv/memorygame/presentation/picture/**"));
		BoardController boardController = new BoardController(cardController);
		return new GameController(playerController, boardController);
	}
	private PlayerController createPlayerController()  {
		PlayerRepositoryService player_repo = new PlayerJSONRepository();
		PlayerController playerController = new PlayerController(player_repo);
		return playerController;
	}

	private MediaPlayer getMediaPlayer() {
		URL mediaUrl = getClass().getClassLoader().getResource("com/github/tschierv/memorygame/sound/safari_loop.wav");
		String mediaStringUrl = mediaUrl.toExternalForm();
		Media media = new Media(mediaStringUrl);
		try {
			player = new MediaPlayer(media);
		} catch (MediaException e) {
			System.out.println("Can't Play sound!");
		}
		if (player != null) {
			player.setOnEndOfMedia(new Runnable() {
				public void run() {
					player.seek(Duration.ZERO);
				}
			});
		}

		return player;
	}
}

