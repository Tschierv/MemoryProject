package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.exception.PlayerAlreadyExistException;
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

public class LevelController implements Initializable {

    @FXML private Text Leveltext;
    @FXML private Button LevelbuttonEasy;
    @FXML private Button LevelbuttonNormal;
    @FXML private Button LevelbuttonHard;
    private GameController gameController;

    public LevelController(GameController gameController){
        this.gameController = gameController;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML public void LevelbuttonEasyPushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayLevel4x4Scene(this.gameController, event);
    }

    @FXML public void LevelbuttonNormalPushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        System.out.println("LevelbuttonNormalPushed");
        sceneController.displayLevel6x6Scene(this.gameController, event);
    }

    @FXML public void LevelbuttonHardPushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayLevel10x10Scene(this.gameController, event);
    }
}
