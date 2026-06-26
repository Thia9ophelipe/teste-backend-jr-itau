package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionValorNegativo;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidaValorImpl implements ValidarTransacao {

    @Override
    public void validar(TransacaoRequestDTO transacaoRequestDTO) {

        if (transacaoRequestDTO.valor() < 0) {
            log.info("valor inserido {}", transacaoRequestDTO.valor());
            throw new ExceptionValorNegativo();
        }
    }
}