package com.github.tschierv.memorygame.presentation;

import com.github.tschierv.memorygame.domain.game.GameController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteConfController implements Initializable {

    @FXML private Text DeleteConftext;
    @FXML private Button DeleteConfbuttonYes;
    @FXML private Button DeleteConfbuttonNo;
    private final GameController gameController;

    public DeleteConfController(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    @FXML public void DeleteConfbuttonNoPushed(ActionEvent event) {
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayOverviewScene(this.gameController, event);
    }

    @FXML public void DeleteConfbuttonYesPushed(ActionEvent event) {
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        this.gameController.removePlayer(this.gameController.getCurrentPlayer().getAccountName());
        sceneController.displayOverviewScene(this.gameController, event);
    }

}
