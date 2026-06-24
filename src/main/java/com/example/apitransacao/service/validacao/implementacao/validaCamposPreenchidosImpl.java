package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionCamposEmBranco;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class validaCamposPreenchidosImpl implements ValidarTransacao {

    @Override
    public void validar(TransacaoRequestDTO transacaoRequestDTO) {

        if (transacaoRequestDTO.valor() == null || transacaoRequestDTO.valor() == null) {
            throw new ExceptionCamposEmBranco();
        }
    }
}
