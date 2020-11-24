package com.github.tschierv.memorygame.domain.enteties;

import java.util.UUID;

public class Card {
    public UUID CardId;
    public UUID CardImage;
    public boolean CardFaceSideUp;

    public Card(UUID CardImage) {
        this.CardId = UUID.randomUUID();
        this.CardImage = CardImage;
        this.CardFaceSideUp = false;
    }

    public UUID getCardImage() {
        return CardImage;
    }

    public boolean isCardFaceSideUp() {
        return CardFaceSideUp;
    }

    public void setCardFaceSideUp(boolean cardFaceSideUp) {
        CardFaceSideUp = cardFaceSideUp;
    }
}

