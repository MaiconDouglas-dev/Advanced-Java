package br.com.fiap.api_rest.model.enums;

public enum Categoria {
    BEBIDA("Bebida"),
    ESSENCIA("Essencia"),
    NARGUILE("Nargile"),
    VAPE("Vape"),
    ACESSORIO("Acessorio"),
    TABACO("Eletrônicos"),
    CIGARRO("Cigarro");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
