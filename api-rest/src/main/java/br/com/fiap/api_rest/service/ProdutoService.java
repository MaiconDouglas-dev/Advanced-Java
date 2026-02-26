package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.repository.ProdutoReppository;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoReppository produtoReppository;

    //CRUD
    public Produto create(Produto produto) {
        return produtoReppository.save(produto);
    }

    public Produto read(UUID id) {
        Optional<Produto> produto = produtoReppository.findById(id);
        return produto.orElse(null);
    }

    public List<Produto> read() {
        return produtoReppository.findAll();
    }

    public Produto update(Produto produto) {
        return  produtoReppository.save(produto);
    }

    public void delete(UUID id) {
        produtoReppository.deleteById(id);
    }

    public Produto read(SingularAttribute<AbstractPersistable, Serializable> id) {
    }
}
