package com.example.apitransacao.service;

import com.example.apitransacao.entity.Transacao;
import com.example.apitransacao.dto.TransacaoRequestDTO;
import com.example.apitransacao.service.validacao.ValidarTransacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.ZoneOffset;
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

        log.info("Iniciando processo de salvar transacao");

        validacoes.forEach(v -> v.validar(transacaoRequestDTO));

        transacoes.add(new Transacao(transacaoRequestDTO.valor(),
                transacaoRequestDTO.dataHora().withOffsetSameInstant(ZoneOffset.UTC)));

        log.info("Transação salva com sucesso!");
    }

    public void deletarTransacoes() {

        log.info("Iniciando processo de deletar transacao");
        transacoes.clear();
        log.info("Transações deletada com sucesso!");
    }

    public List<Transacao> buscarTransacoes() {
        return transacoes;
    }
}
