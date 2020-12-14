package com.zup.transacao.infrastructure;

import com.zup.transacao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
    Optional<Cartao> findByNumero(String numero);
}
