package com.example.apitransacao.service;

import com.example.apitransacao.dto.EstatisticaResponseDTO;
import com.example.apitransacao.entity.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Slf4j
@Service
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {

        this.transacaoService = transacaoService;
    }

    public EstatisticaResponseDTO processarEstatisticas(Integer intervaloEmSegundos) {

        log.info("Iniciando processamento de Estatisticas");

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

        log.info("Estatisticas processadas com sucesso");

        return new EstatisticaResponseDTO(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                min,
                max
        );
    }
}
