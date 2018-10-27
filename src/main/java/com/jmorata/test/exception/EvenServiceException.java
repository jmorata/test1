package com.jmorata.test.exception;

public class EvenServiceException extends Exception {

    public EvenServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EvenServiceException(String message) {
        super(message);
    }

}
