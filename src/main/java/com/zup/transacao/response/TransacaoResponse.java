package com.zup.transacao.response;

import com.zup.transacao.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoRequest estabelecimento;
    private CartaoRequest cartao;
    private LocalDateTime evetivadaEm;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getNumero();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoRequest(transacao.getEstabelecimento());
        this.cartao = new CartaoRequest(transacao.getCartao());
        this.evetivadaEm = transacao.getEvetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoRequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoRequest getCartao() {
        return cartao;
    }

    public LocalDateTime getEvetivadaEm() {
        return evetivadaEm;
    }
}
