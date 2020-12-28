package com.github.tschierv.memorygame.presentation.card;

import com.github.tschierv.memorygame.domain.card.Card;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardViewModel {
    private ImageView cardImageView;
    private Image cardImage;
    private Image cardBack;
    private Card card;

    public CardViewModel(Card card) {
        this.cardImage = new Image(card.CardImage.toString());
        this.cardBack = new Image("/com/github/tschierv/memorygame/menue/leaves_background.jpg");
        this.cardImageView = new ImageView(cardBack);
        this.card = card;
    }

    public void setCardImageSize(Double cardImageSize) {
        this.cardImageView.setFitHeight(cardImageSize);
        this.cardImageView.setFitWidth(cardImageSize);
    }

    public ImageView getCardImageView() {
        return this.cardImageView;
    }

    public void setCardfaceup(){
        this.card.setCardFaceSideUp(true);
        this.cardImageView.setImage(this.cardImage);
    }

    public void setCardbackup(){
        this.card.setCardFaceSideUp(false);
        this.cardImageView.setImage(this.cardBack);
    }

}
