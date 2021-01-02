package com.github.tschierv.memorygame.domain.player;

import java.util.UUID;

public class Player {

    public String accountName;
    private UUID accountId;
    public UUID accountAvatar;
    public Integer score = 0;
    public Integer playedGames = 0;

    public Player(String AccountName, UUID AccountAvatar) {
        this.accountName = AccountName;
        this.accountId = UUID.randomUUID();
        this.accountAvatar = AccountAvatar;
    }
    public Player()
    {
        super();
    }
    public Player(String AccountName, UUID AccountId, UUID AccountAvatar) {
        this.accountName = AccountName;
        this.accountId = AccountId;
        this.accountAvatar = AccountAvatar;
    }

    public Player(String AccountName, UUID AccountId, UUID AccountAvatar, Integer Score, Integer PlayedGames) {
        this.accountName = AccountName;
        this.accountId = AccountId;
        this.accountAvatar = AccountAvatar;
        this.score = Score;
        this.playedGames = PlayedGames;
    }

    public String getAccountName (){
        return this.accountName;
    }
    public  UUID getAccountId () {
        return this.accountId;
    }
    public UUID getAvatar () {
        return this.accountAvatar;
    }
    public Integer getScore() {
        return this.score;
    }

    public Integer getPlayedGames() {
        return this.playedGames;
    }

    public void setScore(Integer Score) {
        Score = Score;
    }

    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
