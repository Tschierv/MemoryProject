package com.github.tschierv.memorygame.presentation;

import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.domain.player.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.*;

public class OverviewController implements Initializable {

    @FXML private Button OverviewbuttonRemove;
    @FXML private Button OverviewbuttonAddUser;
    @FXML private Button OverviewbuttonSelect;
    @FXML private TableView<Player> playerOverviewTable;
    @FXML private Text OverviewtextTitle;

    private final GameController gameController;
    private ObservableList<Player> playerObservableList = FXCollections.observableArrayList();


    public OverviewController(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initializeData();
        this.createTableViewfromObservableList();
    }

    public void initializeData(){
        this.playerObservableList.addAll(this.gameController.getAllPlayersName());
    }

    public void createTableViewfromObservableList(){
        TableColumn<Player, String> playerName = new TableColumn<>("Player");
        TableColumn<Player, Integer> playerScore = new TableColumn<>("Score");
        playerName.setCellValueFactory(new PropertyValueFactory<>("AccountName"));
        playerScore.setCellValueFactory(new PropertyValueFactory<>("Score"));
        playerScore.setSortType(TableColumn.SortType.DESCENDING);
        this.playerOverviewTable.getColumns().addAll(playerName, playerScore);
        this.playerOverviewTable.setItems(playerObservableList);
        this.playerOverviewTable.getSortOrder().addAll(playerScore, playerName);
    }
    @FXML public void OverviewbuttonAddUserPushed(ActionEvent event) {
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayRegScene(this.gameController, event);
    }

    @FXML public void OverviewbuttonRemovePushed(ActionEvent event) {
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        Player playerName = playerOverviewTable.getSelectionModel().getSelectedItem();
        if (playerName != null) {
            this.gameController.setCurrentPlayer(playerName.getAccountName());
            sceneController.displayDeleteConfScene(this.gameController, event);
        } else {
            sceneController.displayNoUserScene(this.gameController, event);
        }
    }
    @FXML public void OverviewbuttonSelectPushed(ActionEvent event) {
        Scene scene =  ((Node)event.getSource()).getScene();
        Player playerName = playerOverviewTable.getSelectionModel().getSelectedItem();
        SceneController sceneController = new SceneController(scene);
        if (playerName != null) {
            this.gameController.setCurrentPlayer(playerName.getAccountName());
            sceneController.displayLevelScene(this.gameController, event);
        } else {
            sceneController.displayNoUserScene(this.gameController, event);
        }
    }



}
