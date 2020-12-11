package com.zup.transacao.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String numero;

    private BigDecimal valor;

    @ManyToOne
    private Estabelecimento estabelecimento;

    @ManyToOne
    private Cartao cartao;

    private LocalDateTime evetivadaEm;

    @Deprecated
    public Transacao(){
    }

    public Transacao(String numero, BigDecimal valor, Estabelecimento estabelecimento,
                     Cartao cartao, LocalDateTime evetivadaEm) {
        this.numero = numero;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.evetivadaEm = evetivadaEm;
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEvetivadaEm() {
        return evetivadaEm;
    }
}
