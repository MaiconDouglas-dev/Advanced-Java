package br.com.fiap.api_rest.model.enums;

public enum StatusPedido {
    EM_ANDAMENTO("Em andamento"),
    CANCELADO("Cancelado"),
    CONCLUIDO("Concluido");

    private String descricao;

    StatusPedido(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
