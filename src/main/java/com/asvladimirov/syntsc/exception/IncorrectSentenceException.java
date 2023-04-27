package com.asvladimirov.syntsc.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IncorrectSentenceException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Bad sentence to scan: %s";
    private String badSentence;


    @Override
    public String getMessage() {
        return String.format(ERROR_MESSAGE,badSentence);
    }
}
