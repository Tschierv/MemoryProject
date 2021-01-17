package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.SceneController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimalPairController implements Initializable {

    private final GameViewModel gameViewModel;
    @FXML private Text AnimalPairtextTitle;
    @FXML private Button AnimalPairbuttonOk;
    @FXML private Label AnimalPairLabel;
    @FXML private ImageView AnimalPairImageView;
    private CardViewModel cardViewModel;
    private GameController gameController;
    private MouseEvent currentEvent;
    private Scene currentScene;

    public ImageView getAnimalPairImageView() {
        return AnimalPairImageView;
    }

    private SimpleBooleanProperty gameIsFinished;


    public AnimalPairController(GameController gameController, CardViewModel cardViewModel, GameViewModel gameViewModel){
        this.cardViewModel = cardViewModel;
        this.gameController = gameController;
        this.gameViewModel = gameViewModel;
        this.currentEvent = gameViewModel.getCurrentEvent();
        this.currentScene = ((Node)currentEvent.getSource()).getScene();
        this.gameIsFinished = new SimpleBooleanProperty(false);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.AnimalPairImageView.setImage(this.cardViewModel.getCardImageView().getImage());
        this.AnimalPairLabel.setText(this.cardViewModel.getAnimalName().getText());
    }

    @FXML public void AnimalPairbuttonOkPushed(ActionEvent event){
        Scene scene =  ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        if(!this.gameController.getCurrentGame().getCards().stream().allMatch(Card::isCardFaceSideUp)) {
            scene.getWindow().hide();
            return;
        }
        this.gameController.setGameEnded();
        scene.getWindow().hide();
        this.gameViewModel.currentGameCompleted(currentEvent);
    }
}
