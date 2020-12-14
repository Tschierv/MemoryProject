package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.game.Game;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import com.github.tschierv.memorygame.domain.player.PlayerController;
import com.github.tschierv.memorygame.persistence.repositories.PlayerRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class LevelController4x4 implements Initializable {

    @FXML private ColumnConstraints Grid4x4Column;
    @FXML private RowConstraints Grid4x4Row;
    @FXML private GridPane LevelGridPane;
    @FXML private Text Username = new Text();
    @FXML private Text Counter = new Text("0");
    @FXML private Button Exit;
    @FXML private Button Help;
    private GameController gameController;
    private Game game;

    public void ExitPushed(ActionEvent event) throws IOException {
        Parent MainView = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene tableViewScene = new Scene(MainView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public LevelController4x4(PlayerController playerController){
        this.gameController = new GameController(playerController);
        this.game = gameController.createGameforPlayer16("Root");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.Username.setText(this.game.getPlayer());
        this.Counter.setText("0");
        this.LevelGridPane = new GridPane();

    }

    public void setUsername(){
        System.out.println("username is: " + this.game.getPlayer());
        this.Username.setText(this.game.getPlayer());
    }
}