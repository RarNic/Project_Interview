package com.example.INGProject.domain.exception;

public class NoProductsOrUsersExistsException extends DomainException{

    public NoProductsOrUsersExistsException(){
        super("The list of products or users is empty");
    }
}
