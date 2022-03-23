package com.kbe.storage.exceptions;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(Integer id){
        super(String.format("Data with Id %d not found", id));
    }
}
