package com.example.apitransacao.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionDataHoraFutura extends RuntimeException {

    public ExceptionDataHoraFutura() {
        log.error("Erro ao salvar a transação: O campo 'dataHora' não pode ser posterior a dataHora atual");
    }
}
