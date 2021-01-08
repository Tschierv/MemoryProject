package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.game.GameController;

import com.github.tschierv.memorygame.presentation.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.*;

public class LevelController6x6 implements Initializable {

    @FXML private final Double Grid6x6Size;
    @FXML private GridPane LevelGridPane;
    @FXML private Text  Username;
    @FXML private Text Counter;
    @FXML private Button Level6x6buttonExit;
    @FXML private Button Level6x6buttonHelp;

    private final GameController gameController;
    private final GameViewModel gameViewModel;

    public void Level6x6buttonExitPushed(ActionEvent event) {
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayMainScene(this.gameController, event);
    }
    @FXML public void Level6x6buttonHelpPushed(ActionEvent event){
        this.gameViewModel.flipAllCardsForHelp(LevelGridPane);
    }

    public LevelController6x6(GameController gameController){
        this.gameController = gameController;
        this.Grid6x6Size = 115.0;
        this.gameViewModel = new GameViewModel(this.gameController);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.gameController.createGameforPlayer(this.gameController.getCurrentPlayer().getAccountName(), 36);
        this.Username.setText(this.gameController.getCurrentPlayer().getAccountName());
        this.Counter.textProperty().bind(this.gameViewModel.getCounter().textProperty());
        LevelGridPane.setVgap(5);
        LevelGridPane.setHgap(5);
        LevelGridPane.getChildren().addAll(this.gameViewModel.createGrid(this.Grid6x6Size).getChildren());
    }

}