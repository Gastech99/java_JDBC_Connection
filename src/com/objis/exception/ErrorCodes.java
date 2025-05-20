package com.objis.exception;

public enum ErrorCodes {
    EMPLOYE_NOT_FOUND(2000);

    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
