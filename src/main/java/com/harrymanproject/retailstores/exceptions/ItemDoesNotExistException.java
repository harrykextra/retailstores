package com.harrymanproject.retailstores.exceptions;

public class ItemDoesNotExistException extends Exception{

    public ItemDoesNotExistException(){

    }

    public ItemDoesNotExistException(String message){
        super(message);
    }
}
