package com.zup.transacao.infrastructure;

import com.zup.transacao.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    Optional<Estabelecimento> findByNome(String nome);
}