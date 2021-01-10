package com.github.tschierv.memorygame.domain.card;

import java.net.URL;
import java.util.UUID;

public class Card {
    public UUID CardId;
    public UUID cardObjectId;
    public URL CardImage;
    public boolean CardFaceSideUp;

    public Card(URL CardImage ) {
        this.CardId = UUID.randomUUID();
        this.CardImage = CardImage;
        this.CardFaceSideUp = false;
    }


    public Card(URL CardImage, UUID CardID){
        this.CardId = CardID;
        this.cardObjectId = UUID.randomUUID();
        this.CardImage = CardImage;
        this.CardFaceSideUp = false;
    }
    public URL getCardImage() {
        return this.CardImage;
    }

    public boolean isCardFaceSideUp() {
        return this.CardFaceSideUp;
    }

    public void setCardFaceSideUp(boolean cardFaceSideUp) {
        this.CardFaceSideUp = cardFaceSideUp;
    }

    public UUID getCardId() {
        return this.CardId;
    }
    public UUID getCardObjectId(){
        return this.cardObjectId;
    }
    public void setCardId(UUID cardId) {
        CardId = cardId;
    }

    public boolean isequalCard(Card selectedCard){
        return this.getCardId().equals(selectedCard.getCardId());
    }
}

