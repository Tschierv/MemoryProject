package com.github.tschierv.memorygame.presentation;

import com.github.tschierv.memorygame.domain.game.GameController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegController implements Initializable {

    @FXML private TextField RegtextUsername;
    @FXML private Button RegbuttonCancel;
    @FXML private Button RegbuttonAdd;
    private final GameController gameController;

    public RegController(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    @FXML public void RegbuttonAddPushed(ActionEvent event) {
        this.gameController.addPlayer(RegtextUsername.getText());
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayOverviewScene(this.gameController, event);
    }
    @FXML public void RegbuttonCancelPushed(ActionEvent event) {
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayOverviewScene(this.gameController, event);
    }
}
