package br.com.fiap.api_rest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ESTOQUE")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Integer idEstoque;

    @Column(name = "qtd_estoque", nullable = false)
    private Double qtdEstoque;

    public Estoque() {
    }

    public Estoque(Double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
