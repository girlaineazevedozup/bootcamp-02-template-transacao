package com.zup.transacao.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Cartao {

    @Id
    @Type(type="uuid-char")
    private UUID id = UUID.randomUUID();

    private String numero;

    private String email;

    @Deprecated
    public Cartao(){
    }

    public Cartao(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }
}
