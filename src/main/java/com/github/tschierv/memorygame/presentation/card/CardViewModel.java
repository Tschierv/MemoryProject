package com.github.tschierv.memorygame.presentation.card;

import com.github.tschierv.memorygame.domain.card.Card;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class CardViewModel {
    private ImageView cardBackView;
    private ImageView cardImageView;

    public CardViewModel(Card card) {
        Image cardImage = new Image(card.CardImage.toString());
        Image cardBack = new Image("/com/github/tschierv/memorygame/menue/leaves_background.jpg");
        this.cardBackView = new ImageView(cardBack);
        this.cardImageView = new ImageView(cardImage);
    }

    public void setCardImageSize(Double cardImageSize) {
        this.cardImageView.setFitHeight(cardImageSize);
        this.cardImageView.setFitWidth(cardImageSize);
        this.cardBackView.setFitWidth(cardImageSize);
        this.cardBackView.setFitHeight(cardImageSize);
    }

    public StackPane getCards() {
        StackPane cardPane = new StackPane();
        cardPane.getChildren().addAll(cardImageView, cardBackView);
        cardPane.setMaxHeight(cardImageView.getFitHeight());
        cardPane.setMaxWidth(cardImageView.getFitWidth());
        return this.addOnMousclicked(cardPane);
    }

    public StackPane addOnMousclicked(StackPane cardPane) {
        cardPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event);
                if (event.getClickCount() >= 0) {
                    System.out.println(event.getSource().toString());
                    System.out.println();
                    cardPane.getChildren().get(1).setVisible(false);
                }
            }
        });
        return cardPane;
    }
}
