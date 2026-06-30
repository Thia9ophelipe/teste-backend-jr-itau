package com.example.apitransacao.controller;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Cadastrar transação",
            description = "Recebe uma transação e a armazena na memória."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Transação cadastrada"),
            @ApiResponse(responseCode = "400", description = "Os campos não foram preenchidos corretamente"),
            @ApiResponse(responseCode = "422", description = "Um ou mais critérios de aceite não foram atendidos")
    })
    public void salvarTransacao(
            @RequestBody
                    (description = "Exemplo de como os campos devem ser preenchidos",
                            content = @Content(
                                    examples = @ExampleObject(
                                            value = """
                                                    {
                                                      "valor": 150.50,
                                                      "dataHora": "2026-06-30T10:15:00-03:00"
                                                    }
                                                    """)
                            )
                    )
            TransacaoRequestDTO transacaoRequestDTO) {
        transacaoService.salvarTransacao(transacaoRequestDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Deletar transações",
            description = "Deleta todas as transações registradas na memória."
    )
    @ApiResponses(
            {@ApiResponse(responseCode = "200", description = "Transações deletadas")}
    )
    public void excluirTransacao() {
        transacaoService.deletarTransacoes();
    }
}
