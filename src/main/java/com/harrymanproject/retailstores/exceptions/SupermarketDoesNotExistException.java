package com.harrymanproject.retailstores.exceptions;

public class SupermarketDoesNotExistException extends Exception{

    public SupermarketDoesNotExistException(){
    }

    public SupermarketDoesNotExistException(String message){
        super(message);
    }
}
