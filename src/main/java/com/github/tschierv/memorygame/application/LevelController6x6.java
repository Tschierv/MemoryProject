/*package com.github.tschierv.memorygame.application;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LevelController6x6 implements Initializable {

        @FXML private Double Grid6x6Size;
        @FXML private GridPane LevelGridPane;
        @FXML private Text  Username = new Text();
        @FXML private Text Counter = new Text();
        @FXML private Button Level6x6buttonExit;
        @FXML private Button Level6x6buttonHelp;

        private GameController gameController;
        private SceneController sceneController;
        private GameViewModel gameViewModel;
        private Map<Card, StackPane> cardStackPaneMap = new HashMap<>();

        public void Level6x6buttonExitPushed(ActionEvent event) throws IOException {
                Scene scene = (Scene) ((Node)event.getSource()).getScene();
                sceneController = new SceneController(scene);
                sceneController.displayMainScene(this.gameController, event);
        }


        public LevelController6x6(GameController gameController){
                this.gameController = gameController;
                this.Grid6x6Size = 115.0;
                this.gameViewModel = new GameViewModel(this.gameController);
        }

        public void createGrid(List<Card> currentCarddeck){
                Integer cardIndex = 0;
                for(int i=0;i<4;i++){
                        for(int j=0;j<4;j++){
                                Card card = currentCarddeck.get(cardIndex);
                                CardViewModel cardViewModel = new CardViewModel(card);
                                cardViewModel.setCardImageSize(this.Grid6x6Size);
                                StackPane cardPane = cardViewModel.getStackPaneCards();
                                cardStackPaneMap.put(currentCarddeck.get(cardIndex), cardPane);
                                cardPane.addEventHandler(MouseEvent.MOUSE_CLICKED, selectedCardEventHandler(card, cardPane));
                                LevelGridPane.add(cardPane, i, j);
                                cardIndex++;
                        }
                }
        }
        @Override
        public void initialize(URL location, ResourceBundle resources) {
                this.gameController.createGameforPlayer(this.gameController.getCurrentPlayer().getAccountName(), 36);
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

        public EventHandler selectedCardEventHandler(Card selectedCard, StackPane cardPane) {
                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event){
                                gameController.selectCard(selectedCard);
                                new Thread(() ->
                                {
                                        cardPane.getChildren().get(1).setVisible(false);
                                        if(gameController.getCurrentGame().getSelectedCards().isEmpty()){
                                                LevelGridPane.setDisable(true);
                                                try {
                                                        Thread.sleep(600);

                                                } catch (InterruptedException e){
                                                        e.printStackTrace();
                                                }
                                                for (Card cardinMap : cardStackPaneMap.keySet())
                                                        if(!cardinMap.isCardFaceSideUp()) {
                                                                System.out.println("card is not face up" + cardinMap);
                                                                cardStackPaneMap.get(cardinMap).getChildren().get(1).setVisible(true);
                                                        }
                                                LevelGridPane.setDisable(false);
                                        }

                                }).start();
                        }
                };
                return eventHandler;
        }

}
*/