package com.github.tschierv.memorygame.domain.player.exception;

public class PlayerAlreadyExistException extends Exception {
    public PlayerAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}