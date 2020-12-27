package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class LevelController10x10 implements Initializable {

    @FXML private Double Grid10x10Size;
    @FXML private GridPane LevelGridPane;
    @FXML final Text Username = new Text();
    @FXML private Text Counter = new Text("0");
    @FXML private Button Level10x10buttonExit;
    @FXML private Button Level10x10buttonHelp;
    private GameController gameController;
    private Game game;
    private SceneController sceneController;

    public void Level10x10buttonExitPushed(ActionEvent event) throws IOException {
        Scene scene = ((Node)event.getSource()).getScene();
        sceneController = new SceneController(scene);
        sceneController.displayMainScene(this.gameController, event);
    }


    public LevelController10x10(GameController gameController){
        this.gameController = gameController;
        this.Grid10x10Size = 115.0;
        this.game = gameController.createGameforPlayer(this.gameController.getCurrentPlayer().getAccountName(), 100);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.Username.setText(this.game.getPlayer());
        this.Counter.setText("0");
        LevelGridPane.setVgap(5);
        LevelGridPane.setHgap(5);
        List<Card> currentCarddeck = this.game.board.getCardDeck();
        Collections.shuffle(currentCarddeck);
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                Card card = currentCarddeck.get(0);
                CardViewModel cardViewModel = new CardViewModel(card);
                cardViewModel.setCardImageSize(this.Grid10x10Size);
                currentCarddeck.remove(0);
                StackPane cardPane = cardViewModel.getCards();
                LevelGridPane.add(cardPane, i, j);
            }
        }
    }
}