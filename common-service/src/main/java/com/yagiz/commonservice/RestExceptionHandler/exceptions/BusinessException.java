package com.yagiz.commonservice.RestExceptionHandler.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
