package com.example.apitransacao.controller;

import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO) {
        transacaoService.salvarTransacao(transacaoRequestDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void excluirTransacao()  {
        transacaoService.deletarTransacoes();
    }
}
