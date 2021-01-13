package com.github.tschierv.memorygame.presentation;

import com.github.tschierv.memorygame.domain.game.GameController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GameCompletedController implements Initializable {

    @FXML private Text GameCompletedtextTitle;
    @FXML private Button GameCompletedbuttonOk;
    private final GameController gameController;

    public GameCompletedController(GameController gameController){
        this.gameController = gameController;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML public void GameCompletedbuttonOkPushed(ActionEvent event){
        Scene scene =  ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayLevelScene(this.gameController, event);
    }
}
