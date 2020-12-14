package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class LevelController4x4 implements Initializable {

    @FXML private ColumnConstraints Grid4x4Column;
    @FXML private RowConstraints Grid4x4Row;
    @FXML private Text Username = new Text();
    @FXML private Text Counter = new Text("0");
    @FXML private Button Exit;
    @FXML private Button Help;
    private GameController gameController;
    private Game game;
    public void ExitPushed(ActionEvent event){
        System.exit(1);
    }

    public LevelController4x4(PlayerController playerController){
        this.gameController = new GameController(playerController);
        this.game = gameController.createGameforPlayer16("Root");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setUsername(){
        System.out.println("username is: " + this.game.getPlayer());
        this.Username.setText(this.game.getPlayer());
        this.Username.setFill(Color.BLUEVIOLET);
    }
}