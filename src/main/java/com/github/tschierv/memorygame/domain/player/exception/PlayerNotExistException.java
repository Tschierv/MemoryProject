package com.github.tschierv.memorygame.domain.player.exception;

public class PlayerNotExistException extends Exception {
    public PlayerNotExistException(String errorMessage) {
        super(errorMessage);
    }
}