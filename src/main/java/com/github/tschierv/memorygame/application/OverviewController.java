package com.github.tschierv.memorygame.application;

import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class OverviewController implements Initializable {

    @FXML private Button OverviewbuttonRemove;
    @FXML private Button OverviewbuttonAddUser;
    @FXML private Button OverviewbuttonSelect;
    @FXML private ListView<String> OverviewList;
    @FXML private Text OverviewtextTitle;

    private GameController gameController;
    private ObservableList<String> playerObservableList = FXCollections.observableArrayList();


    public OverviewController(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initializeData();
        System.out.println("initialize: " + this.OverviewList.getItems());
    }

    public void initializeData(){
        playerObservableList.removeAll(this.playerObservableList);
        playerObservableList.addAll(this.gameController.getAllPlayersName());
        OverviewList.getItems().addAll(playerObservableList);
        OverviewList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML public void OverviewbuttonAddUserPushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayRegScene(this.gameController, event);
    }

    @FXML public void OverviewbuttonRemovePushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        String playerName = OverviewList.getSelectionModel().getSelectedItem();
        this.gameController.setCurrentPlayer(playerName);
        sceneController.displayDeleteConfScene(this.gameController, event);
    }
    @FXML public void OverviewbuttonSelectPushed(ActionEvent event) throws IOException {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        String playerName = OverviewList.getSelectionModel().getSelectedItem();
        SceneController sceneController = new SceneController(scene);
        if (playerName != null) {
            this.gameController.setCurrentPlayer(playerName);
            sceneController.displayLevelScene(this.gameController, event);
        } else {
            this.gameController.unsetCurrentPlayer();
            sceneController.displayNoUserScene(this.gameController, event);
        }
    }



}
