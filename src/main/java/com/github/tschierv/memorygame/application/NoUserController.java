package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.game.GameController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class NoUserController implements Initializable {

    @FXML private Text NoUsertextTitle;
    @FXML private Button NoUserbuttonOk;
    private GameController gameController;

    public NoUserController(GameController gameController){
        this.gameController = gameController;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML public void NoUserbuttonOkPushed(){

    }
}
