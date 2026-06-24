package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionCamposEmBranco;
import com.example.apitransacao.exception.ExceptionValorNegativo;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import org.springframework.stereotype.Component;

@Component
public class validaValorImpl implements ValidarTransacao {

    @Override
    public void validar(TransacaoRequestDTO transacaoRequestDTO) {

        if (transacaoRequestDTO.valor() < 0) {
            throw new ExceptionValorNegativo();
        }
    }
}