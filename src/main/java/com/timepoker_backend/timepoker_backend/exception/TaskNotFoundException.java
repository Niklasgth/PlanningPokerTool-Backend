package com.timepoker_backend.timepoker_backend.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String id) {
        super("Task with id " + id + " was not found");
    }

}
