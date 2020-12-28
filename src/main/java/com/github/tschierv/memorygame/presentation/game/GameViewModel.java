package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.game.GameController;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class GameViewModel {
    private GameController gameController;
    public SimpleStringProperty counter;

    public GameViewModel(GameController gameController){
        this.gameController = gameController;
        this.counter = new SimpleStringProperty();
        // this.counter.bind(new SimpleStringProperty(this.gameController.getcurrentCounter().toString()));
    }

    public SimpleStringProperty getCounter(){
        return new SimpleStringProperty(this.gameController.getcurrentCounter().toString());
    }

}
