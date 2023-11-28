package com.example.INGProject.domain.exception;

public class ProductIdDoesNotExistsException extends DomainException{
    public ProductIdDoesNotExistsException(){
        super("Product id does not exists");
    }
}
