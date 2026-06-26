package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionDataHoraFutura;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Slf4j
@Component
public class ValidaDataHoraImpl implements ValidarTransacao {

    @Override
    public void validar(TransacaoRequestDTO requestDTO) {

        if(requestDTO.dataHora().isAfter(OffsetDateTime.now())){
            log.info("dataHora atual {}, dataHora inseridos {}", OffsetDateTime.now(), requestDTO.dataHora());
            throw new ExceptionDataHoraFutura();
        }
    }
}