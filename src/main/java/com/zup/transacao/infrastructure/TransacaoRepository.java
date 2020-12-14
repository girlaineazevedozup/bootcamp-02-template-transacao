package com.zup.transacao.infrastructure;

import com.zup.transacao.model.Cartao;
import com.zup.transacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findTop10ByCartaoOrderByEfetivadaEmDesc(Cartao cartao);
}
