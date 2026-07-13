package br.com.estudos.controllers;

import br.com.estudos.domains.Produto;
import br.com.estudos.domains.mappers.ProdutoMapper;
import br.com.estudos.domains.dto.ProdutoDTO;
import br.com.estudos.domains.generics.TrabalhandoComGenerics;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generics")
@AllArgsConstructor
public class TestesGenericsController {

    @Autowired
    private ProdutoMapper produtoMapper;

    @PostMapping("/mistura-de-hoje")
    public String obtemMisturaDeHoje(@RequestBody List<String> misturas){
        return TrabalhandoComGenerics.retornaMistura(misturas);
    }
    @PostMapping("/presente-da-lista")
    public Produto obtemPresenteDaLista(@RequestBody List<Produto> estoque){
        return TrabalhandoComGenerics.retornaProduto(estoque);
    }

    @PostMapping("/obter-produto")
    public Produto obterProduto(@RequestBody ProdutoDTO dto){
        return produtoMapper.toProduto()
    }
}
