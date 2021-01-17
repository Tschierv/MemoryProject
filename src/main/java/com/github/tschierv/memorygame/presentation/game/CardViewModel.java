package com.github.tschierv.memorygame.presentation.game;

import com.github.tschierv.memorygame.domain.card.Card;
import javafx.scene.control.Label;
import org.apache.commons.io.FilenameUtils;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;


public class CardViewModel extends StackPane {
    private final ImageView cardImageView;
    private final ImageView cardBackView;
    private final Card card;

    public CardViewModel(Card card)  {
        Image cardImage = new Image(card.CardImage.toString());
        Image cardBack = new Image("/com/github/tschierv/memorygame/presentation/menue/leaves_background.jpg");
        this.cardBackView = new ImageView(cardBack);
        this.cardImageView = new ImageView(cardImage);
        this.card = card;

        Text animalNameAsText = new Text();
        animalNameAsText.setText(FilenameUtils.getBaseName(card.getCardImage().getPath()));
        getChildren().addAll(cardBackView, cardImageView);
        this.setCardToBackUp();
    }

    public void setCardImageSize(Double cardImageSize) {
        this.cardImageView.setFitHeight(cardImageSize);
        this.cardImageView.setFitWidth(cardImageSize);
        this.cardBackView.setFitHeight(cardImageSize);
        this.cardBackView.setFitWidth(cardImageSize);
    }

    public Label getAnimalName() {
        Label animalName = new Label();
        animalName.setWrapText(true);
        String encodedName = FilenameUtils.getBaseName(this.card.getCardImage().toString());
        try {
            animalName.setText(URLDecoder.decode(encodedName, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        animalName.setPrefSize(this.cardImageView.getFitWidth(), this.cardBackView.getFitHeight());
        return animalName;
    }

    public void setCardToFaceUp(Runnable action){
        FadeTransition fadeToFaceUp = new FadeTransition(Duration.seconds(2), cardImageView);
        fadeToFaceUp.setToValue(1);
        fadeToFaceUp.setOnFinished(e -> action.run());
        fadeToFaceUp.play();
        this.card.setCardFaceSideUp(true);
    }

    public void setCardToBackUp(){
        FadeTransition fadeToBackUp = new FadeTransition(Duration.seconds(1), cardImageView);
        fadeToBackUp.setToValue(0);
        fadeToBackUp.play();
        this.card.setCardFaceSideUp(false);
    }

    public Boolean isCardfaceup(){
        return this.card.isCardFaceSideUp();
    }

    public Card getCard(){
        return this.card;
    }

    public ImageView getCardImageView(){
        return this.cardImageView;
    }

}
