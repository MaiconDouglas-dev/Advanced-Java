package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Autowired
    private ProdutoService;

    //CRUD - Create, Read, Update, Delete.
    //POST, GET, PUT, DELETE

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
        Produto produtoSalvo = produtoService.create(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @GetMapping("{/id}")
    public ResponseEntity<Produto> readProduto(@PathVariable UUID id) {
        Produto produto = produtoService.read(id);
        if (produto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> readProdutos(){
        List<Produto> = produtos = produtoService.read();
        if (produtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtoService.read(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> updateProdutos(@RequestBody Produto produto){
        Produto produtoExistente = produtoService.read(produto.getId());
        if (produtoExistente == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Produto produtoAtualizado = produtoService.update(produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable UUID id){
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
