package com.zup.transacao.infrastructure;

import com.zup.transacao.model.Cartao;
import com.zup.transacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    Optional<Transacao> findByCartao(Cartao cartao);
}
