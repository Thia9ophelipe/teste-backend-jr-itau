package com.example.apitransacao.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public record EstatisticaResponseDTO(
        @Schema(
                description = "Quantidade de transações registradas no período",
                example = "3"
        ) long Count,
        @Schema(
                description = "Valor total das transações registradas no período",
                example = "300"
        ) double sum,
        @Schema(
                description = "Valor médio das transações registardas no período",
                example = "150.75"
        ) double avg,
        @Schema(
                description = "Valor máximo das transações registradas",
                example = "400"
        ) double min,
        @Schema(
                description = "Valor minímo das transações registradas",
                example = "10.0"
        ) double max) {
}
