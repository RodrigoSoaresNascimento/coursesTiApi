package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AplicationAdviceController {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException (RecordNotFoundException ex){
        return "Error: "+ ex.getMessage();
    }

}
