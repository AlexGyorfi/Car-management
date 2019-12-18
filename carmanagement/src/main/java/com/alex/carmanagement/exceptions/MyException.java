package com.alex.carmanagement.exceptions;

public class MyException extends RuntimeException {
    public String exceptionMessage;
    public MyException(String exceptionMessage){
        super(exceptionMessage);
    }
}
