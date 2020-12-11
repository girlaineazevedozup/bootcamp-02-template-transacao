package com.zup.transacao.kafka.event;

import com.zup.transacao.model.Cartao;

public class CartaoEvento {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }
}
