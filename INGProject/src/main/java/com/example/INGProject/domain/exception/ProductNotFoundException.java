package com.example.INGProject.domain.exception;

public class ProductNotFoundException extends DomainException{

    public ProductNotFoundException(){
        super("This product is not present");
    }
}
