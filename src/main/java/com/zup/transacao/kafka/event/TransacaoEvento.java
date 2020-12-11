package com.zup.transacao.kafka.event;

import com.zup.transacao.infrastructure.CartaoRepository;
import com.zup.transacao.infrastructure.EstabelecimentoRepository;
import com.zup.transacao.model.Cartao;
import com.zup.transacao.model.Estabelecimento;
import com.zup.transacao.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class TransacaoEvento {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoEvento estabelecimento;
    private CartaoEvento cartao;
    private LocalDateTime evetivadaEm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstabelecimentoEvento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoEvento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public CartaoEvento getCartao() {
        return cartao;
    }

    public void setCartao(CartaoEvento cartao) {
        this.cartao = cartao;
    }

    public LocalDateTime getEvetivadaEm() {
        return evetivadaEm;
    }

    public void setEvetivadaEm(LocalDateTime evetivadaEm) {
        this.evetivadaEm = evetivadaEm;
    }

    public Transacao toModel(EstabelecimentoRepository estabelecimentoRepository,
                             CartaoRepository cartaoRepository) {

        Optional<Estabelecimento> estabelecimentoOp = estabelecimentoRepository.findByNome(estabelecimento.getNome());
        Estabelecimento estabelecimentoModel;
        if(estabelecimentoOp.isPresent())
            estabelecimentoModel = estabelecimentoOp.get();
        else
            estabelecimentoModel = estabelecimentoRepository.save(estabelecimento.toModel());

        Optional<Cartao> cartaoOp = cartaoRepository.findByNumero(cartao.getId());
        Cartao cartaoModel;
        if(estabelecimentoOp.isPresent())
            cartaoModel = cartaoOp.get();
        else
            cartaoModel = cartaoRepository.save(cartao.toModel());

        return new Transacao(id, valor, estabelecimentoModel, cartaoModel, evetivadaEm);
    }
}
