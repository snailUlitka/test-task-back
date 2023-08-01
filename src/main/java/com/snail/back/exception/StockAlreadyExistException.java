package com.snail.back.exception;

public class StockAlreadyExistException extends Exception {
    public StockAlreadyExistException(String message) {
        super(message);
    }
}
