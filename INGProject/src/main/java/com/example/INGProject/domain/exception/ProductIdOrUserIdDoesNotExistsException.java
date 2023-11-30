package com.example.INGProject.domain.exception;

public class ProductIdOrUserIdDoesNotExistsException extends DomainException{
    public ProductIdOrUserIdDoesNotExistsException(){
        super("Product id or user id does not exists");
    }
}
