package com.zup.transacao.controller;

import com.zup.transacao.infrastructure.CartaoRepository;
import com.zup.transacao.infrastructure.TransacaoRepository;
import com.zup.transacao.model.Cartao;
import com.zup.transacao.model.Transacao;
import com.zup.transacao.response.EstabelecimentoRequest;
import com.zup.transacao.response.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("cartoes/{id}/transacoes")
    @Transactional
    public ResponseEntity<?> detalhaTransacoes(@PathVariable("id") String id){
        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumero(id);

        Cartao cartao = cartaoOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado!"));

        Optional<Transacao> transacaoOptional = transacaoRepository.findByCartao(cartao);

        if(transacaoOptional.isEmpty())
            return ResponseEntity.notFound().build();

        Transacao transacao = transacaoOptional.get();

        TransacaoResponse transacaoResponse = new TransacaoResponse(transacao);

        return ResponseEntity.ok(transacaoResponse);
    }
}
