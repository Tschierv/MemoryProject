package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.Game;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.List;

public class GameViewModel {
    private List<Card> selectedCards;
    private Game game;
    @FXML public SimpleStringProperty counter;

    public GameViewModel(Game game){
        this.game = game;
        this.selectedCards = new ArrayList<Card>();
        this.counter = new SimpleStringProperty();
        this.counter.bind(new SimpleStringProperty(this.game.getCounter().toString()));
    }

    public List<Card> getSelectedCards(){
        return this.selectedCards;
    }

    public EventHandler selectedCardEventHandler(Card selectedCard, StackPane cardPane) {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event){
                System.out.println(event);
                System.out.println("this card is selected: " + selectedCard);
                game.selectCard(selectedCard);
                if (event.getClickCount() >= 0){
                    cardPane.getChildren().get(1).setVisible(false);
                }
            event.consume();
            }

        };
        return eventHandler;
    }
}
