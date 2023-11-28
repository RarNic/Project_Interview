package com.example.INGProject.domain.exception;

public class ProductAlreadyExistsException extends DomainException{
    public ProductAlreadyExistsException(){
        super("This product is already in the list");
    }
}
