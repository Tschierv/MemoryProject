package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.SceneController;
import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimalPairController implements Initializable {

    @FXML private Text AnimalPairtextTitle;
    @FXML private Button AnimalPairbuttonOk;
    @FXML private Label AnimalPairLabel;
    @FXML private ImageView AnimalPairImageView;
    private CardViewModel cardViewModel;
    private GameController gameController;

    public AnimalPairController(GameController gameController, CardViewModel cardViewModel){
        this.cardViewModel = cardViewModel;
        this.gameController = gameController;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.AnimalPairImageView.setImage(this.cardViewModel.getCardImageView().getImage());
        this.AnimalPairLabel.setText(this.cardViewModel.getAnimalName().getText());
    }

    @FXML public void AnimalPairbuttonOkPushed(ActionEvent event){
        Scene scene =  ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        scene.getWindow().hide();
    }
}
