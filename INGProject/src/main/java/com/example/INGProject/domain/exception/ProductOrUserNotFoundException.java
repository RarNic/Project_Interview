package com.example.INGProject.domain.exception;

public class ProductOrUserNotFoundException extends DomainException{

    public ProductOrUserNotFoundException(){
        super("This product or this user is not present");
    }
}
