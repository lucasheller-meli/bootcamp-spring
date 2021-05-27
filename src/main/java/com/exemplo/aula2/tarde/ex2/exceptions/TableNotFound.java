package com.exemplo.aula2.tarde.ex2.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TableNotFound extends Exception{
    public TableNotFound(Long id) {
        super(String.format("We could not find a table with id %s in our database.", id));
    }
}
