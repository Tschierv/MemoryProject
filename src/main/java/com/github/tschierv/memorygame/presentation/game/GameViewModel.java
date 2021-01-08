package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.SceneController;
import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.apache.commons.io.FilenameUtils;
import java.util.ArrayList;
import java.util.List;

public class GameViewModel {
    private final GameController gameController;
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

    public void handleMouseSelection(MouseEvent event, CardViewModel cardViewModel){
        if (this.remainingClickCount == 0)
            return;

        this.remainingClickCount--;

        if (this.getSelectedCards().size() == 0) {
            this.setSelectedCard(cardViewModel);
            cardViewModel.setCardfaceup(() -> {});
        } else {
            this.setSelectedCard(cardViewModel);
            cardViewModel.setCardfaceup(() -> {
                if (!this.isMatchedPair()) {
                    this.getSelectedCards().get(0).setCardbackup();
                    this.getSelectedCards().get(1).setCardbackup();
                    this.increaseCounter();
                }
                this.clearSelectedCards();
                this.remainingClickCount = 2;
            });
        }

        if (!this.gameController.getCurrentGame().getCards().stream().allMatch(x -> x.CardFaceSideUp == true)) {
            return;
        }
        this.gameController.setNewPlayerScore();
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayOverviewScene(this.gameController, event);
    }

    public GridPane createGrid(Double gridSize ){
        List<Card> currentCarddeck = this.gameController.getCurrentGame().getCards();
        int cardIndex = 0;
        GridPane gameGrid = new GridPane();
        for(int i=0;i<Math.sqrt(currentCarddeck.size());i++){
            for(int j=0;j<Math.sqrt(currentCarddeck.size());j++){
                Card card = currentCarddeck.get(cardIndex);
                CardViewModel cardViewModel = new CardViewModel(card);
                cardViewModel.setCardImageSize(gridSize);
                cardViewModel.setOnMouseClicked(event -> this.handleMouseSelection(event, cardViewModel));
                gameGrid.add(cardViewModel, i, j);
                cardIndex++;
            }
        }
        return gameGrid;
    }

}
