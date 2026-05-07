package br.com.fiap.api_rest.model;

import br.com.fiap.api_rest.entities.Pedidos;
import br.com.fiap.api_rest.model.enums.Categoria;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTOS")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "nome_produto")
    private String nome;
    @Column(name = "preco_produto")
    private BigDecimal preco;
    @Column(name = "data_validade")
    private LocalDate expiracao;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Categoria categoria;
    private int estoque;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedidos> pedidos;

    public Produto() {
    }

    public Produto(String nome, BigDecimal preco, LocalDate expiracao, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.expiracao = expiracao;
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(LocalDate expiracao) {
        this.expiracao = expiracao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
}
