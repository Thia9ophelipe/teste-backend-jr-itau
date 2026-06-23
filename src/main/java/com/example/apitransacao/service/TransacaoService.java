package com.example.apitransacao.service;

import com.example.apitransacao.entity.Transacao;
import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    private final List<ValidarTransacao> validacoes;

    public TransacaoService(List <ValidarTransacao> validacoes) {
        this.validacoes = validacoes;
    }

    public void salvarTransacao(TransacaoRequestDTO transacaoRequestDTO) {
        validacoes.forEach(validacao -> validacao.validar(transacaoRequestDTO));
        transacoes.add(new Transacao(transacaoRequestDTO.valor(), transacaoRequestDTO.dataHora()));
    }

    public void deletarTransacao() {
        transacoes.clear();
    }
}
