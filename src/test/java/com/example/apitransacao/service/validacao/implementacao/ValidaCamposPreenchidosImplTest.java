package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionCamposEmBranco;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ValidaCamposPreenchidosImplTest {

    @Nested
    class validaCampos {
        static Stream<Arguments> preenchimentoDeCampos() {
            OffsetDateTime dataHora = OffsetDateTime.parse("2026-06-23T23:11:00-03:00");
            return Stream.of(
                    Arguments.of(null, dataHora),
                    Arguments.of(10.0, null),
                    Arguments.of(null, null)
            );
        }

        @ParameterizedTest
        @MethodSource("preenchimentoDeCampos")
        void develancarExcecaoCamposEmBranco(Double valor, OffsetDateTime dataHora) {

            ValidaCamposPreenchidosImpl validaCamposPreenchidos = new ValidaCamposPreenchidosImpl();
            TransacaoRequestDTO requestDTO = new TransacaoRequestDTO(valor, dataHora);

            ExceptionCamposEmBranco exception = assertThrows(ExceptionCamposEmBranco.class,
                    () -> validaCamposPreenchidos.validar(requestDTO));
        }

        @Test
        void naoDeveLancarExcecaoDataHoraForFutura() {

            //ARRANGE
            ValidaCamposPreenchidosImpl validaCamposPreenchidos = new ValidaCamposPreenchidosImpl();
            TransacaoRequestDTO requestDTO = new TransacaoRequestDTO(10.0,
                    OffsetDateTime.now().minusSeconds(10));

            //ACT
            validaCamposPreenchidos.validar(requestDTO);

            //ASSERT
            assertNotNull(requestDTO.valor(), String.valueOf(requestDTO.dataHora()));

            log.info("Valor informado: {}, dataHora registrada: {}", requestDTO.valor(), requestDTO.dataHora());
        }
    }
}