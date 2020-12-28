package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class GameViewModel {
    private GameController gameController;
    public SimpleStringProperty counter;
    public int clickCount = 0;

    public List<CardViewModel> getSelectedCards() {
        return selectedCards;
    }

    public void setSelectedCards(List<CardViewModel> selectedCards) {
        this.selectedCards = selectedCards;
    }

    public void setSelectedCard(CardViewModel selectedCard) {
        this.selectedCards.add(selectedCard);
    }

    public void clearSelectedCards(){
        this.selectedCards.clear();
    }

    private List<CardViewModel> selectedCards = new ArrayList<>();

    public GameViewModel(GameController gameController){
        this.gameController = gameController;
        this.counter = new SimpleStringProperty();
    }

    public SimpleStringProperty getCounter(){
        return new SimpleStringProperty(this.gameController.getcurrentCounter().toString());
    }

    public Boolean isMatchedPair(){
        List<Card> checkMatching = new ArrayList<>();
        System.out.println("isMatchedPair selectedCards: " + getSelectedCards());
        System.out.println(this.getSelectedCards().get(0));
        System.out.println(this.getSelectedCards().get(0).getCard());
        checkMatching.add(this.getSelectedCards().get(0).getCard());
        checkMatching.add(this.getSelectedCards().get(1).getCard());
        return this.gameController.ismatchingCardPair(checkMatching);
    }

}
