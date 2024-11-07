package br.com.kaneko.produtosapi.controller;

import br.com.kaneko.produtosapi.model.Produto;
import br.com.kaneko.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
   
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Produto> listarProduto(){
        List<Produto> produtoList = produtoRepository.findAll();

        return produtoList;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        System.out.println("Produto Recebido " + produto);
        produtoRepository.save(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }


}
