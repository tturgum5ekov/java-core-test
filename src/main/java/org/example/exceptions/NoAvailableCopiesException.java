package org.example.exceptions;

public class NoAvailableCopiesException extends Exception {
    public NoAvailableCopiesException(String message) {
        super("Нет доступных копий книги: " + message);
    }
}
