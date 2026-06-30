package com.example.apitransacao.controller;

import com.example.apitransacao.dto.EstatisticaResponseDTO;
import com.example.apitransacao.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Processa estatisticas das transações salvas.",
            description = "Pode receber um intervalo de tempo para que sejam processadas estatísticas das " +
                    "transações salvas dentro do período informado. Caso não seja informado nenhum intervalo " +
                    "específico, o valor padrão esta definido para 60 segundos. As estatísticas processadas " +
                    "são: a quantidade de transações registradas no periodo, " +
                    "a soma de todas elas, " +
                    "a média," +
                    "o valor mínimo " +
                    "e o valor máximo"
    )
    public EstatisticaResponseDTO getEstatisticas(
            @Parameter(
                    description = "Intervalo de tempo, em segundos, considerado para o cálculo das estatísticas.",
                    example = "60"
            )
            @RequestParam(value = "intervaloDeBusca", required = false, defaultValue = "60")
            Integer intervaloDeBusca) {

        EstatisticaResponseDTO estatisticas = estatisticaService.processarEstatisticas(intervaloDeBusca);

        return estatisticas;
    }
}
