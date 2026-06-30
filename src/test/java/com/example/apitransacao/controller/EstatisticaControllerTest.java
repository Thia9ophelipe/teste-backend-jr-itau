package com.example.apitransacao.controller;

import com.example.apitransacao.dto.EstatisticaResponseDTO;
import com.example.apitransacao.entity.Transacao;
import com.example.apitransacao.service.EstatisticaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EstatisticaControllerTest {

    @Mock
    private EstatisticaService service;

    @InjectMocks
    private EstatisticaController controller;

    @Test
    void deveRetornarEstatisticasDaService() {

        // ARRANGE
        EstatisticaResponseDTO dto =
                new EstatisticaResponseDTO(2L, 30.0, 15.0, 20.0, 60);

        Mockito.when(service.processarEstatisticas(60))
                .thenReturn(dto);

        // ACT
        EstatisticaResponseDTO resultado = controller.getEstatisticas(60);

        // ASSERT
        assertEquals(dto, resultado);
        Mockito.verify(service).processarEstatisticas(60);
    }
}
