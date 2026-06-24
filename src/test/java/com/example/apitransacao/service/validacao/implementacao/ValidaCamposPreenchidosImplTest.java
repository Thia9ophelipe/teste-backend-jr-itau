package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionCamposEmBranco;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ValidaCamposPreenchidosImplTest {

    static Stream<Arguments> preenchimentoDeCampos(){
        OffsetDateTime dataHora = OffsetDateTime.parse("2026-06-23T23:11:00-03:00");
        return Stream.of(
                Arguments.of(10.0, dataHora),
                Arguments.of(null, dataHora),
                Arguments.of(10.0, null),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("preenchimentoDeCampos")
    void deveValidarCamposPreenchidos(Double valor, OffsetDateTime dataHora) {

        ValidaCamposPreenchidosImpl validador = new ValidaCamposPreenchidosImpl();
        TransacaoRequestDTO requestDTO =  new TransacaoRequestDTO(valor, dataHora);

        if(valor == null || dataHora == null) {
            assertThrows(ExceptionCamposEmBranco.class, () -> validador.validar(requestDTO));
        } else{
            log.info("Validacao feita com sucesso");
        }
    }
}