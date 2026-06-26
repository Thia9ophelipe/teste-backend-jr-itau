package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionValorNegativo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ValidaValorImpltest {

    @Nested
    class validaValor {
        @Test
        void deveLancarExcecaoValorNegativo() {

            //ARRANGE
            TransacaoRequestDTO transacaoRequestDTO = new TransacaoRequestDTO(
                    -10.0, OffsetDateTime.now().minusSeconds(10));
            ValidaValorImpl validaValorImpl = new ValidaValorImpl();

            //ACT
            //ASSERT
            assertThrows(ExceptionValorNegativo.class,
                    () -> {
                        validaValorImpl.validar(transacaoRequestDTO);
                    }
            );
        }

        @Test
        void naoDeveLancarExcecaoValorNegativo() {

            //ARRANGE
            TransacaoRequestDTO transacaoRequestDTO = new TransacaoRequestDTO(10.0,
                    OffsetDateTime.now().minusSeconds(10));
            ValidaValorImpl validaValorImpl = new ValidaValorImpl();

            //ACT
            validaValorImpl.validar(transacaoRequestDTO);

            //ASSERT
            assertTrue(transacaoRequestDTO.valor() > 0, valueOf(transacaoRequestDTO));
            log.info("o valor informado ({}) é positivo", transacaoRequestDTO.valor());

        }
    }
}
