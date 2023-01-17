package org.example.exception;

public class KeyWordsNotFoundException extends RuntimeException{

    public KeyWordsNotFoundException(String msg) {
        super(msg);
    }
}
