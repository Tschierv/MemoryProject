package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class GameViewModel {
    private GameController gameController;
    public Text counter = new Text();
    public int remainingClickCount = 2;

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
    }

    public Text getCounter(){
        return this.counter;
    }

    public void increaseCounter(){
        this.gameController.setCurrentCounter();
        this.counter.setText(this.gameController.getcurrentCounter().toString());
    }
    public Boolean isMatchedPair(){
        List<Card> checkMatching = new ArrayList<>();
        checkMatching.add(this.getSelectedCards().get(0).getCard());
        checkMatching.add(this.getSelectedCards().get(1).getCard());
        return this.gameController.ismatchingCardPair(checkMatching);
    }

}
