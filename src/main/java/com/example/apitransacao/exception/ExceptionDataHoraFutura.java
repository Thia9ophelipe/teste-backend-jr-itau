package com.example.apitransacao.exception;

public class ExceptionDataHoraFutura extends RuntimeException {

    public ExceptionDataHoraFutura(String mensagem) {
        super(mensagem);
    }

}
