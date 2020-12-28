package com.github.tschierv.memorygame.presentation.card;

import com.github.tschierv.memorygame.domain.card.Card;
import com.github.tschierv.memorygame.presentation.game.GameViewModel;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class CardViewModel {
    private ImageView cardBackView;
    private ImageView cardImageView;
    private StackPane cardPane;
    private Card card;

    public CardViewModel(Card card) {
        Image cardImage = new Image(card.CardImage.toString());
        Image cardBack = new Image("/com/github/tschierv/memorygame/menue/leaves_background.jpg");
        this.cardBackView = new ImageView(cardBack);
        this.cardImageView = new ImageView(cardImage);
        this.card = card;
        this.cardPane = new StackPane();
    }

    public void setCardImageSize(Double cardImageSize) {
        this.cardImageView.setFitHeight(cardImageSize);
        this.cardImageView.setFitWidth(cardImageSize);
        this.cardBackView.setFitWidth(cardImageSize);
        this.cardBackView.setFitHeight(cardImageSize);
    }

    public StackPane getCards() {
        cardPane.getChildren().addAll(cardImageView, cardBackView);
        cardPane.setMaxHeight(cardImageView.getFitHeight());
        cardPane.setMaxWidth(cardImageView.getFitWidth());
        return cardPane;
    }

}
