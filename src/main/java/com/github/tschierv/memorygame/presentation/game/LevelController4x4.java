package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.GameController;

import com.github.tschierv.memorygame.presentation.SceneController;
import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LevelController4x4 implements Initializable {

    @FXML private Double Grid4x4Size;
    @FXML private GridPane LevelGridPane;
    @FXML private Text  Username;
    @FXML private Text Counter;
    @FXML private Button Level4x4buttonExit;
    @FXML private Button Level4x4buttonHelp;

    private GameController gameController;
    private SceneController sceneController;
    private GameViewModel gameViewModel;

    public void Level4x4buttonExitPushed(ActionEvent event) {
        Scene scene = ((Node)event.getSource()).getScene();
        sceneController = new SceneController(scene);
        sceneController.displayMainScene(this.gameController, event);
    }


    public LevelController4x4(GameController gameController){
        this.gameController = gameController;
        this.Grid4x4Size = 115.0;
        this.gameViewModel = new GameViewModel(this.gameController);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.gameController.createGameforPlayer(this.gameController.getCurrentPlayer().getAccountName(), 16);
        this.Username.setText(this.gameController.getCurrentPlayer().getAccountName());
        this.Counter.textProperty().bind(this.gameViewModel.getCounter().textProperty());
        LevelGridPane.setVgap(5);
        LevelGridPane.setHgap(5);
        LevelGridPane.getChildren().addAll(this.gameViewModel.createGrid(this.Grid4x4Size).getChildren());
    }


}
