package com.example.apitransacao.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionValorNegativo extends RuntimeException{

    public ExceptionValorNegativo() {
        log.error("Erro ao salvar a transação: O campo 'valor' não pode conter um número negativo");
    }
}
