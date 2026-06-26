package com.example.apitransacao.service.validacao.implementacao;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.exception.ExceptionDataHoraFutura;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ValidaDataHoraImplTest {

    @Nested
    class validaDataHora {
        @Test
        void deveLancarExcecaoDataHoraForFutura() {
            // ARRANGE
            OffsetDateTime dataHora = OffsetDateTime.now().plusDays(1);
            TransacaoRequestDTO dto = new TransacaoRequestDTO(10.0, dataHora);
            ValidaDataHoraImpl validaDataHora = new ValidaDataHoraImpl();

            // ACT
            ExceptionDataHoraFutura exception = assertThrows(
                    ExceptionDataHoraFutura.class,
                    () -> validaDataHora.validar(dto)
            );
        }

        @Test
        void naoDeveLancarExcecaoDataHoraForFutura() {
            // ARRANGE
            OffsetDateTime dataHora = OffsetDateTime.now().minusDays(1);
            TransacaoRequestDTO dto = new TransacaoRequestDTO(10.0, dataHora);
            ValidaDataHoraImpl validaDataHora = new ValidaDataHoraImpl();

            // ACT
            validaDataHora.validar(dto);

            //ASSERT
            assertTrue(OffsetDateTime.now().isAfter(dataHora));

            log.info("dataHora {} é anterior a data atual {}", dataHora, OffsetDateTime.now());
        }
    }
}


