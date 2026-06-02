package com.ucsal.exception;

public class HttpRequestException extends RuntimeException {
    public HttpRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}