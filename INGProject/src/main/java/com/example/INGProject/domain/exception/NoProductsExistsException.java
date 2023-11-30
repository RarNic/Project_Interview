package com.example.INGProject.domain.exception;

public class NoProductsExistsException extends DomainException{

    public NoProductsExistsException(){
        super("The list of products is empty");
    }
}
