package com.objis.exception;

public class EntityNotFoundException extends RuntimeException{

    private ErrorCodes errorCode;

    public EntityNotFoundException(ErrorCodes errorCode) {
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(Throwable cause, ErrorCodes errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCodes errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

}
