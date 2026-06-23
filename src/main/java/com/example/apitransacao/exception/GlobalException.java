package com.example.apitransacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(value = ExceptionCamposEmBranco.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void excpetionCampoEmBranco(){
    }

    @ExceptionHandler(value = ExceptionValorNegativo.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void excpetionValorNegativo(){
    }


    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void httpMessageNotReadbleException(){
    }
}
