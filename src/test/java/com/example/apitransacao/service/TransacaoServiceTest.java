package com.example.apitransacao.service;

import com.example.apitransacao.entity.Transacao;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {

    @Mock
    List<Transacao> transacoes;

    @Mock
    List<ValidarTransacao>  validarTransacoes;

    @InjectMocks
    private TransacaoService service;

    @Nested
    class salvarTransacao{

        @Test
        void deveValidarTransacao () {

            //ARRANGE
            //ACT

            //ASSERT
        }

        @Test
        void deveSalvarTransacao () {
        }

    }

    @Test
    void deletarTransacao() {
    }

    @Test
    void buscarTransacoes() {
    }
}