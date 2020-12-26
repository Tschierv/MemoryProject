package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.game.GameController;

import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class LevelController4x4 implements Initializable {

    @FXML private Double Grid4x4Size;
    @FXML private GridPane LevelGridPane;
    @FXML private Text Username = new Text();
    @FXML private Text Counter = new Text("0");
    @FXML private Button Level4x4buttonExit;
    @FXML private Button Level4x4buttonHelp;
    private GameController gameController;
    private Game game;
    private SceneController sceneController;

    public void Level4x4buttonExitPushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        sceneController = new SceneController(scene);
        sceneController.displayMainScene(this.gameController, event);
    }


    public LevelController4x4(GameController gameController){
        this.gameController = gameController;
        this.Grid4x4Size = 115.0;
        this.game = gameController.createGameforPlayer16(this.gameController.getCurrentPlayer().getAccountName());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.Username.setText(this.game.getPlayer());
        this.Counter.setText("0");
        LevelGridPane.setVgap(5);
        LevelGridPane.setHgap(5);
        List<Card> currentCarddeck = this.game.board.getCardDeck();
        Collections.shuffle(currentCarddeck);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                Card card = currentCarddeck.get(0);
                CardViewModel cardViewModel = new CardViewModel(card);
                cardViewModel.setCardImageSize(this.Grid4x4Size);
                currentCarddeck.remove(0);
                StackPane cardPane = cardViewModel.getCards();
                LevelGridPane.add(cardPane, i, j);
            }
        }
    }
}