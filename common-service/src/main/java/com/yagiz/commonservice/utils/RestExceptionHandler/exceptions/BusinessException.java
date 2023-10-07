package com.yagiz.commonservice.utils.RestExceptionHandler.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
