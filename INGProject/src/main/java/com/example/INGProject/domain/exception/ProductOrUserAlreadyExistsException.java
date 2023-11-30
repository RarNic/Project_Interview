package com.example.INGProject.domain.exception;

public class ProductOrUserAlreadyExistsException extends DomainException{
    public ProductOrUserAlreadyExistsException(){
        super("This product or the user is already in the list");
    }
}
