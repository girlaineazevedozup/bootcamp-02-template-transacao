package com.zup.transacao.kafka;

import com.zup.transacao.infrastructure.CartaoRepository;
import com.zup.transacao.infrastructure.EstabelecimentoRepository;
import com.zup.transacao.infrastructure.TransacaoRepository;
import com.zup.transacao.kafka.event.TransacaoEvento;
import com.zup.transacao.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoEvento transacaoEvento) {

        Transacao transacao = transacaoEvento.toModel(estabelecimentoRepository, cartaoRepository);
        transacaoRepository.save(transacao);
    }
}
