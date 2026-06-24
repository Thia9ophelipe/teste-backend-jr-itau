package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionValorNegativo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.OffsetDateTime;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ValidaValorImpltest {

    @ParameterizedTest
    @ValueSource(doubles = {-10, 1})
    void deveValidarValor(Double valor) {

    ValidaValorImpl validacao = new ValidaValorImpl();
    TransacaoRequestDTO requestDTO = new TransacaoRequestDTO(valor, OffsetDateTime.now());

        if(valor < 0){
            assertThrows(ExceptionValorNegativo.class, () -> validacao.validar(requestDTO));
        } else{
            log.info("Campo 'valor' valido");
        }
    }
}
