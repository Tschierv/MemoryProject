package com.github.tschierv.memorygame.application;

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

public class MainController implements Initializable {

    @FXML private Button MainbuttonStart;
    @FXML private Button MainbuttonExit;
    @FXML private Text MaintextTitle;
    private SceneController sceneController;
    private GameController gameController;

    public MainController(GameController gameController){
        this.gameController = gameController;
        System.out.println("MainController is called");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML public void MainbuttonStartPushed(ActionEvent event) throws IOException {
        System.out.println("MainbuttonStartPushed");
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        sceneController = new SceneController(scene);
        sceneController.displayLevelScene(gameController, event);
    }

    @FXML public void MainbuttonExitPushed(){
        System.exit(1);
    }
}
