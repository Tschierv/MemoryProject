package com.github.tschierv.memorygame.presentation.menu;

import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class NoUserController implements Initializable {

    @FXML private Text NoUsertextTitle;
    @FXML private Button NoUserbuttonOk;
    private final GameController gameController;

    public NoUserController(GameController gameController){
        this.gameController = gameController;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML public void NoUserbuttonOkPushed(ActionEvent event){
        Scene scene =  ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayOverviewScene(this.gameController, event);
    }
}
