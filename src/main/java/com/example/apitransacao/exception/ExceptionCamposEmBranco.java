package com.example.apitransacao.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionCamposEmBranco extends RuntimeException{

    public ExceptionCamposEmBranco() {
        log.error("Erro ao salvar a transação: Os campos 'valor' e 'dataHora' devem ser preenchidos");
    }
}
