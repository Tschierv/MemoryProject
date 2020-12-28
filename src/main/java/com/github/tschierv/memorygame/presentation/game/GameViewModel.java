package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.game.GameController;
import javafx.beans.property.SimpleStringProperty;

public class GameViewModel {
    private GameController gameController;
    public SimpleStringProperty counter;

    public GameViewModel(GameController gameController){
        this.gameController = gameController;
        this.counter = new SimpleStringProperty();
    }

    public SimpleStringProperty getCounter(){
        return new SimpleStringProperty(this.gameController.getcurrentCounter().toString());
    }

}
