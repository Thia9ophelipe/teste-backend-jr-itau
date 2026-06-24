package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionDataHoraFutura;
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
public class ValidaDataHoraImplTest {

    static Stream<Arguments> preenchimentoDeDatas(){

        OffsetDateTime dataValida = OffsetDateTime.parse("2026-06-24T13:52:00-03:00");
        OffsetDateTime datainvalida = OffsetDateTime.parse("2050-06-25T13:52:00-03:00");
        return Stream.of(
                Arguments.of(dataValida),
                Arguments.of(datainvalida)
        );
    }

    @ParameterizedTest
    @MethodSource("preenchimentoDeDatas")
    void deveValidarDataHora(OffsetDateTime dataHora) {

        TransacaoRequestDTO transacaoRequestDTO = new TransacaoRequestDTO(10.0, dataHora);
        ValidaDataHoraImpl validaDataHoraImpl = new ValidaDataHoraImpl();

        if(dataHora.isAfter(OffsetDateTime.parse("2026-06-24T13:53:00-03:00"))){
            assertThrows(ExceptionDataHoraFutura.class, () -> validaDataHoraImpl.validar(transacaoRequestDTO));
        }else {
            log.info("dataHora valida");
        }
    }
}


