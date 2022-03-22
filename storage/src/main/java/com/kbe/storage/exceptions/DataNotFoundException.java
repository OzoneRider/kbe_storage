package com.kbe.storage.exceptions;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(){
        super("No Product Data found ");
    }
}
