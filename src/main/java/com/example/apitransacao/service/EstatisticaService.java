package com.example.apitransacao.service;

import com.example.apitransacao.dto.EstatisticaResponseDTO;
import com.example.apitransacao.entity.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Slf4j
@Service
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {

        this.transacaoService = transacaoService;
    }

    public static String formatarParaSegundos(long milissegundos) {
        double segundos = milissegundos / 1000.0;

        return String.format(java.util.Locale.US, "%.3fs", segundos);
    }

    public EstatisticaResponseDTO processarEstatisticas(Integer intervaloEmSegundos) {

        log.info("Iniciando processamento de Estatisticas");

        long inicio = System.currentTimeMillis();

        OffsetDateTime limite = OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(intervaloEmSegundos);

        List<Transacao> transacoesNoPeriodo = transacaoService.buscarTransacoes()
                .stream()
                .filter(t -> t.getDataHora().isAfter(limite))
                .toList();

        DoubleSummaryStatistics estatisticas = transacoesNoPeriodo.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        double min = estatisticas.getCount() > 0 ? estatisticas.getMin() : 0.0;
        double max = estatisticas.getCount() > 0 ? estatisticas.getMax() : 0.0;

        long fim = System.currentTimeMillis();

        long tempoDeProcessamento = fim - inicio;

        String tempoFormatado = formatarParaSegundos(tempoDeProcessamento);

        log.info("Estatisticas processadas com sucesso em: " + tempoFormatado);

        return new EstatisticaResponseDTO(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                min,
                max
        );
    };
}
