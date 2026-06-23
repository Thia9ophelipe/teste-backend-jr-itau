package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionCamposEmBranco;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import org.springframework.stereotype.Component;

@Component
public class validaCamposPreenchidosImpl implements ValidarTransacao {

    @Override
    public void validar(TransacaoRequestDTO transacaoRequestDTO) {

        if (transacaoRequestDTO.valor() == null || transacaoRequestDTO.valor() == null) {
            throw new ExceptionCamposEmBranco("Os campos 'valor' e 'dataHora' devem ser preenchidos");
        }
    }
}
