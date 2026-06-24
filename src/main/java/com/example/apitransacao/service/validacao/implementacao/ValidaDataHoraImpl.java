package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionDataHoraFutura;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ValidaDataHoraImpl implements ValidarTransacao {

    @Override
    public void validar(TransacaoRequestDTO requestDTO) {

        if(requestDTO.dataHora().isAfter(OffsetDateTime.now())){
            throw new ExceptionDataHoraFutura();
        }
    }
}