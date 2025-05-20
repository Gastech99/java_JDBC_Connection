package com.objis.exception;

import java.util.List;

public class InvalidException extends RuntimeException{

    private ErrorCodes errorCode;
    private List<String> errors;

    public InvalidException(ErrorCodes errorCode, List<String> errors) {
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidException(String message, Throwable cause, ErrorCodes errorCode, List<String> errors) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidException(Throwable cause, ErrorCodes errorCode, List<String> errors) {
        super(cause);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCodes errorCode, List<String> errors) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
