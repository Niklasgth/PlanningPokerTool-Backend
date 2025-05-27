package com.timepoker_backend.timepoker_backend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("User with id " + id + " was not found");
    }
}
