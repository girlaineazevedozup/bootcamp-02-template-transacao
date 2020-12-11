package com.zup.transacao.response;

import com.zup.transacao.model.Cartao;

public class CartaoRequest {

    private String id;
    private String email;

    public CartaoRequest(Cartao cartao) {
        this.id = cartao.getNumero();
        this.email = cartao.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
