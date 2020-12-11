package com.zup.transacao.response;

import com.zup.transacao.model.Estabelecimento;

public class EstabelecimentoRequest {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoRequest(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
