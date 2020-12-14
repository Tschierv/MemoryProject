package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

public class MainController {

    @FXML private Button MainbuttonStart;
    @FXML private Button MainbuttonExit;
    @FXML private Text MaintextTitle;

    @FXML public void MainbuttonStartPushed(ActionEvent event) throws IOException, PlayerAlreadyExistException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LevelView4x4.fxml"));
        fxmlLoader.setController(new LevelController4x4(this.createPlayerController()));

        Parent MainViewParent = (Parent)fxmlLoader.load();
        Scene LevelView4x4Scene = new Scene(MainViewParent);

        // Get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(LevelView4x4Scene);
        window.show();
    }

    private PlayerController createPlayerController() throws PlayerAlreadyExistException {
        Player player_d = new Player("Root", UUID.randomUUID());
        PlayerRepository player_repo = new PlayerRepository();
        PlayerController player_controller = new PlayerController(player_repo);
        player_controller.createPlayer(player_d);
        return player_controller;
    }
    @FXML public void MainbuttonExitPushed(){
        System.exit(1);
    }
}
