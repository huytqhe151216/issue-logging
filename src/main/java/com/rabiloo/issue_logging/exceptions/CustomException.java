package com.rabiloo.issue_logging.exceptions;

public class CustomException extends RuntimeException {
    private int status;

    public CustomException(int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
