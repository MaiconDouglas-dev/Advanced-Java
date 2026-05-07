package br.com.fiap.api_rest.entities;

import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.model.enums.StatusPedido;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private StatusPedido status;
    private LocalDateTime dataPedido;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "produto_pedido",
            joinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_pedido", referencedColumnName = "id"))
    private List<Produto> produtos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}