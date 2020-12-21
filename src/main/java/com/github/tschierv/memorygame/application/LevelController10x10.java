package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LevelController10x10 implements Initializable {

    @FXML private ColumnConstraints Grid10x10Column;
    @FXML private RowConstraints Grid10x10Row;
    @FXML private GridPane LevelGridPane;
    @FXML private Text Username = new Text();
    @FXML private Text Counter = new Text("0");
    @FXML private Button Level10x10buttonExit;
    @FXML private Button Level10x10buttonHelp;
    private GameController gameController;
    private Game game;
    private SceneController sceneController;

    public void Level10x10buttonExitPushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        sceneController = new SceneController(scene);
        sceneController.displayMainScene(this.gameController, event);
    }


    public LevelController10x10(GameController gameController){
        this.gameController = gameController;
        this.game = gameController.createGameforPlayer100("Root");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.Username.setText(this.game.getPlayer());
        this.Counter.setText("0");
        LevelGridPane.setVgap(3);
        LevelGridPane.setHgap(3);
        List<Card> currentCarddeck = this.game.board.getCardDeck();
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                Card card = currentCarddeck.get(0);
                Image cardImage = new Image(card.CardImage.toString());
                ImageView cardImageView = new ImageView(cardImage);
                cardImageView.setFitHeight(100.0);
                cardImageView.setFitWidth(100.0);
                currentCarddeck.remove(0);
                LevelGridPane.add(cardImageView, i, j);
            }
        }
    }

    public void setUsername(){
        System.out.println("username is: " + this.game.getPlayer());
        this.Username.setText(this.game.getPlayer());
    }
}