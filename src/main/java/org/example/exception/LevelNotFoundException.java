package org.example.exception;

public class LevelNotFoundException extends RuntimeException {

    public LevelNotFoundException(String msg) {
        super(msg);
    }
}
