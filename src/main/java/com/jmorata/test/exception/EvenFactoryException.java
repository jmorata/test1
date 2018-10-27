package com.jmorata.test.exception;

public class EvenFactoryException extends Exception {

    public EvenFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public EvenFactoryException(String message) {
        super(message);
    }

}
