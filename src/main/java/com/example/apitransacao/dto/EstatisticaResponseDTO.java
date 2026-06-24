package com.example.apitransacao.dto;

public record EstatisticaResponseDTO(Long Count,
                                    double sum,
                                    double avg,
                                    double min,
                                    double max) {
}
