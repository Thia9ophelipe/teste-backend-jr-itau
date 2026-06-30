package com.example.apitransacao.service;

import com.example.apitransacao.dto.EstatisticaResponseDTO;
import com.example.apitransacao.entity.Transacao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EstatisticaServiceTest {

    @Mock
    TransacaoService transacaoService;

    @InjectMocks
    EstatisticaService estatisticaService;

    @Test
    void deveProcessarEstatisticas() {

// ARRANGE
        Integer intervaloEmSegundos = 10;

        OffsetDateTime agora = OffsetDateTime.now();

        List<Transacao> transacoes = List.of(
                new Transacao(10.0, agora.minusSeconds(5)),
                new Transacao(20.0, agora.minusSeconds(3)),
                new Transacao(30.0, agora.minusSeconds(15))
        );

        Mockito.when(transacaoService.buscarTransacoes())
                .thenReturn(transacoes);
        //ACT
        EstatisticaResponseDTO resultado = estatisticaService.processarEstatisticas(intervaloEmSegundos);
        //ASSERT

        assertEquals(2, resultado.Count());
        assertEquals(30.0, resultado.sum());
        assertEquals(15.0, resultado.avg());
        assertEquals(10.0, resultado.min());
        assertEquals(20.0, resultado.max());
    }
}