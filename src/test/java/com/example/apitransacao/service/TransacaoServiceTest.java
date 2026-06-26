package com.example.apitransacao.service;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.entity.Transacao;
import com.example.apitransacao.exception.ExceptionCamposEmBranco;
import com.example.apitransacao.exception.ExceptionDataHoraFutura;
import com.example.apitransacao.exception.ExceptionValorNegativo;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {

    @Mock
    ValidarTransacao validaTransacoes;

    @Nested
    class salvarTransacao {

        @Test
        void deveSalvarTransacao() {

            // ARRANGE
            ValidarTransacao validacao = mock(ValidarTransacao.class);

            TransacaoService service = new TransacaoService(List.of(validacao));

            TransacaoRequestDTO dto = new TransacaoRequestDTO(100.0, OffsetDateTime.now().minusHours(1));

            // ACT
            service.salvarTransacao(dto);

            // ASSERT
            assertEquals(1, service.buscarTransacoes().size());
            verify(validacao).validar(dto);
        }

        @Test
        void deveLancarExcecaoCamposEmBranco() {

            // ARRANGE
            TransacaoRequestDTO dto = new TransacaoRequestDTO(100.0, OffsetDateTime.now().minusHours(1));

            ValidarTransacao valida = mock(ValidarTransacao.class);

            doThrow(new ExceptionCamposEmBranco()).when(valida).validar(dto);

            TransacaoService service = new TransacaoService(List.of(valida));

            // ACT + ASSERT
            assertThrows(RuntimeException.class, () -> service.salvarTransacao(dto));

            // ASSERT final (garantia de não salvou)
            assertEquals(0, service.buscarTransacoes().size());
        }

        @Test
        void deveLancarExcecaoDataHoraFutura() {

            // ARRANGE
            TransacaoRequestDTO dto = new TransacaoRequestDTO(100.0, OffsetDateTime.now().minusHours(1));

            ValidarTransacao valida = mock(ValidarTransacao.class);

            doThrow(new ExceptionDataHoraFutura()).when(valida).validar(dto);

            TransacaoService service = new TransacaoService(List.of(valida));

            // ACT + ASSERT
            assertThrows(RuntimeException.class, () -> service.salvarTransacao(dto));

            // ASSERT final (garantia de não salvou)
            assertEquals(0, service.buscarTransacoes().size());
        }

        @Test
        void deveLancarExcecaoValorNegativo() {

            // ARRANGE
            TransacaoRequestDTO dto = new TransacaoRequestDTO(100.0, OffsetDateTime.now().minusHours(1));

            ValidarTransacao valida = mock(ValidarTransacao.class);

            doThrow(new ExceptionValorNegativo()).when(valida).validar(dto);

            TransacaoService service = new TransacaoService(List.of(valida));

            // ACT + ASSERT
            assertThrows(RuntimeException.class, () -> service.salvarTransacao(dto));

            // ASSERT final (garantia de não salvou)
            assertEquals(0, service.buscarTransacoes().size());
        }

    }

    @Nested
    class deletarTransacao {

        @Test
        void deveDeletarTransacao() {

            //ARRANGE
            List<Transacao> transacoes = new ArrayList<>();
            TransacaoRequestDTO dto = new TransacaoRequestDTO(100.0, OffsetDateTime.now().minusHours(1));
            TransacaoService service = new TransacaoService(List.of(validaTransacoes));
            ;

            //ACT
            service.deletarTransacoes();

            //ASSERT
            assertEquals(0, transacoes.size());
        }

    }

}

