package com.rabiloo.issue_logging.common.models;

public class ResponseResult<T> {
    private int status;
    private String message;
    private T data;

    // Constructors
    public ResponseResult() {
    }

    public ResponseResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Utility Methods for Success and Error Responses
    public static <T> ResponseResult<T> success(String message, T data) {
        return new ResponseResult<>(200, message, data);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(200, "Success", data);
    }

    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult<>(400, message, null);
    }

    public static <T> ResponseResult<T> error(int status, String message) {
        return new ResponseResult<>(status, message, null);
    }
}
