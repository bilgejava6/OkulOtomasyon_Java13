package com.muhammet.exception;

import lombok.Getter;

@Getter
public class OkulOtomasyonuException extends RuntimeException{

    private final ErrorType errorType;
    public OkulOtomasyonuException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public OkulOtomasyonuException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
