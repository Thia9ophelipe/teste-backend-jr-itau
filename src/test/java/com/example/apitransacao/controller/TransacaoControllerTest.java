package com.example.apitransacao.controller;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


@ExtendWith(MockitoExtension.class)
public class TransacaoControllerTest {

    @Mock
    TransacaoService transacaoService;

    @InjectMocks
    TransacaoController transacaoController;

    @Test
    void devePassarAtributosParaTransacaoService(){

        //ARRANJE
        TransacaoRequestDTO dto = new TransacaoRequestDTO(10.0, OffsetDateTime.parse("2026-06-23T23:11:10-03:00"));

        //ACT
        transacaoService.salvarTransacao(dto);

        //ASSERT
        assertEquals(10.0, dto.valor());
        assertEquals(OffsetDateTime.parse("2026-06-23T23:11:10-03:00"), dto.dataHora());
    }
}
