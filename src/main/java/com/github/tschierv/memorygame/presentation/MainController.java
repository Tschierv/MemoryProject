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

public class MainController implements Initializable {

    @FXML private Button MainbuttonStart;
    @FXML private Button MainbuttonExit;
    @FXML private Text MaintextTitle;
    private SceneController sceneController;
    private final GameController gameController;

    public MainController(GameController gameController){
        this.gameController = gameController;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML public void MainbuttonStartPushed(ActionEvent event) {
        Scene scene =  ((Node)event.getSource()).getScene();
        sceneController = new SceneController(scene);
        sceneController.displayOverviewScene(gameController, event);
    }

    @FXML public void MainbuttonExitPushed(){
        System.exit(1);
    }
}
