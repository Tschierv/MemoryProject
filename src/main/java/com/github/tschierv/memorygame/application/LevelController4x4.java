package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.GameController;

import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import com.github.tschierv.memorygame.presentation.game.GameViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private Map<Card, ImageView> cardStackPaneMap = new HashMap<>();

    public void Level4x4buttonExitPushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        sceneController = new SceneController(scene);
        sceneController.displayMainScene(this.gameController, event);
    }


    public LevelController4x4(GameController gameController){
        this.gameController = gameController;
        this.Grid4x4Size = 115.0;
        this.gameViewModel = new GameViewModel(this.gameController);
    }

    public void createGrid(List<Card> currentCarddeck){
        Integer cardIndex = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                Card card = currentCarddeck.get(cardIndex);
                CardViewModel cardViewModel = new CardViewModel(card);
                cardViewModel.setCardImageSize(this.Grid4x4Size);
                cardStackPaneMap.put(card, cardViewModel.getCardImageView());
                cardViewModel.getCardImageView().addEventHandler(MouseEvent.MOUSE_CLICKED, selectedCardEventHandler(card, cardViewModel));
                this.LevelGridPane.add(cardViewModel.getCardImageView(), i, j);
                cardIndex++;
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.gameController.createGameforPlayer(this.gameController.getCurrentPlayer().getAccountName(), 16);
        this.Username.setText(this.gameController.getCurrentPlayer().getAccountName());
        this.Counter.textProperty().bind(this.gameViewModel.getCounter());
        LevelGridPane.setVgap(5);
        LevelGridPane.setHgap(5);
        this.createGrid(this.gameController.getallCards());
    }
    public Text getCounter() {
        return Counter;
    }
    public void setCounter(Text counter) {
        Counter = counter;
    }

    public EventHandler selectedCardEventHandler(Card selectedCard, CardViewModel cardImageView) {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event){
                gameController.selectCard(selectedCard);
                new Thread(() ->
                {
                    cardImageView.setCardfaceup();

                if(gameController.getCurrentGame().getSelectedCards().isEmpty()){
                    LevelGridPane.setDisable(true);
                    try {
                        Thread.sleep(600);

                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    for (Card cardinMap : cardStackPaneMap.keySet())
                        if(!cardinMap.isCardFaceSideUp()) {
                            cardImageView.setCardbackup();
                            cardStackPaneMap.get(cardinMap).setImage(cardImageView.getCardImageView().getImage());
                        }
                    LevelGridPane.setDisable(false);
                }

            }).start();
            }
        };
        return eventHandler;
    }

}