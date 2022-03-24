package com.kbe.storage.exceptions;

public class NoProductDataException extends RuntimeException{

    public NoProductDataException(){
        super("No Product Data found");
    }
}
