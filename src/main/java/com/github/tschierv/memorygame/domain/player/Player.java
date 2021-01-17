package com.github.tschierv.memorygame.domain.player;

import java.util.UUID;

public class Player {

    public String accountName;
    private UUID accountId;
    public Integer score = 0;

    public Player(String AccountName) {
        this.accountName = AccountName;
        this.accountId = UUID.randomUUID();
    }
    public Player()
    {
        super();
    }
    public Player(String AccountName, UUID AccountId) {
        this.accountName = AccountName;
        this.accountId = AccountId;
    }

    public Player(String AccountName, UUID AccountId, Integer Score) {
        this.accountName = AccountName;
        this.accountId = AccountId;
        this.score = Score;
    }

    public String getAccountName (){
        return this.accountName;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer Score) {
        this.score = Score;
    }

    public UUID getAccountId(){
        return this.accountId;
    }

}
