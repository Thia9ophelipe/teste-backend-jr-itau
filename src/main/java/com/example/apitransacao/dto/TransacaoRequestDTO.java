package com.example.apitransacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(
        @Schema(
                description = "Valor da transação",
                example = "150.75"
        )
        Double valor,
        @Schema(
                description = "Data e hora da transação",
                example = "2026-06-30T15:00:00-03:00"
        )
        OffsetDateTime dataHora) {
}
