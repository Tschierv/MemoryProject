package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.SceneController;
import com.github.tschierv.memorygame.presentation.card.CardViewModel;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
/**
 * Handles all the UI logic related to the Gameboard like the creation of a game-grid,
 * or the selection of cards, mouse-clicks.
 * <p>
 * This Class can be re-used for all the different board sizes (4x4, 6x6, 10x10) therefore
 * reducing duplicated code-
 *
 */
public class GameViewModel {
    private final GameController gameController;
    public Text counter = new Text();
    public int remainingClickCount = 2;
    /**
     * Constructor for GameViewModel class
     *
     * @param gameController Constructor takes the current instance of a gameController
     */
    public GameViewModel(GameController gameController){
        this.gameController = gameController;
    }

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

    /**
     * Handles all the actions behind a card selection
     * Always returns void
     * @param event MouseEvent mouse clicked
     * @param cardViewModel passing in the cardViewModel of the selected card
     */
    public void handleMouseSelection(MouseEvent event, CardViewModel cardViewModel){
        if (this.remainingClickCount == 0) {
            return;
        }
        if (cardViewModel.isCardfaceup()){
            return;
        }

        this.remainingClickCount--;

        if (this.getSelectedCards().size() == 0) {
            this.setSelectedCard(cardViewModel);
            cardViewModel.setCardToFaceUp(() -> {});
        } else {
            this.setSelectedCard(cardViewModel);
            cardViewModel.setCardToFaceUp(() -> {
                if (!this.isMatchedPair()) {
                    this.getSelectedCards().get(0).setCardToBackUp();
                    this.getSelectedCards().get(1).setCardToBackUp();
                    this.increaseCounter();
                }
                if (this.isMatchedPair()) {
                    Scene scene = ((Node)event.getSource()).getScene();
                    SceneController sceneController = new SceneController(scene);
                    sceneController.displayAnimalPairScene(this.gameController,cardViewModel, event);
                }
                this.clearSelectedCards();
                this.remainingClickCount = 2;

            });
        }
        if (!this.gameController.getCurrentGame().getCards().stream().allMatch(Card::isCardFaceSideUp)) {
            return;
        }

        this.gameController.setNewPlayerScore();
        Scene scene = ((Node)event.getSource()).getScene();
        SceneController sceneController = new SceneController(scene);
        sceneController.displayGameCompletedScene(this.gameController, event);
        sceneController.displayLevelScene(this.gameController, event);
    }

    /**
     * Method shows all pictures on the grid to help the player
     *
     * @param currentGameGride GridPanel of the current Game
     */
    public void flipAllCardsForHelp(GridPane currentGameGride){
        ObservableList<Node> gridPaneChildrens = currentGameGride.getChildren();
        for ( Node node : gridPaneChildrens) {
            CardViewModel cardViewModel = ((CardViewModel) node);
            cardViewModel.setCardToFaceUp(cardViewModel::setCardToBackUp);
        }
    }

    private void displayCelebrationDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game completed");
        alert.setHeaderText(null);
        alert.setContentText("You won the game, you are great!");
        alert.showAndWait();
    }

    /**
     * Class method responsible for creating a squared grid and populating it with CardviewModels.
     * Every CardviewModel get equipped with a Mouse Clicked events.
     *
     * @param gridSize  Size used for width and length of every node in grid
     * @return gameGrid
     */
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
