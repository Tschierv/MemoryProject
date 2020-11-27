package com.github.tschierv.memorygame.domain.player;

import java.time.LocalDate;
import java.util.UUID;

public class Player {

    public String AccountName;
    public UUID AccountId;
    public UUID AccountAvatar;
    public Integer Score;
    public Integer PlayedGames;

    public Player(String AccountName, UUID AccountId, UUID AccountAvatar) {
        this.AccountName = AccountName;
        this.AccountId = UUID.randomUUID();
        this.AccountAvatar = AccountAvatar;
    }

    public String getAccountName (){
        return this.AccountName;
    }
    public  UUID getAccountId () {
        return this.AccountId;
    }
    public UUID getAvatar () {
        return this.AccountAvatar;
    }
    public Integer getScore() {
        return this.Score;
    }

    public Integer getPlayedGames() {
        return this.PlayedGames;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    public void setPlayedGames(Integer playedGames) {
        PlayedGames = playedGames;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }
}
