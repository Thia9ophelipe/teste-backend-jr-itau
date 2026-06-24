package com.example.apitransacao.controller;

import com.example.apitransacao.dto.EstatisticaResponseDTO;
import com.example.apitransacao.service.EstatisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EstatisticaResponseDTO getEstatisticas(
            @RequestParam(value = "intervaloDeBusca",required = false, defaultValue = "60") Integer intervaloDeBusca) {

        EstatisticaResponseDTO estatisticas = estatisticaService.processarEstatisticas(intervaloDeBusca);

        return estatisticas;
    }
}
