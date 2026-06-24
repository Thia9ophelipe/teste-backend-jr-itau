package com.example.apitransacao.dto;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.OffsetDateTime;

public record EstatisticaResponseDTO(Long Count,
                                    double sum,
                                    double avg,
                                    double min,
                                    double max) {
}
