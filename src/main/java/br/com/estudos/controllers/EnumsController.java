package br.com.estudos.controllers;

import br.com.estudos.domains.Produto;
import br.com.estudos.domains.ProdutoMapper;
import br.com.estudos.domains.dto.ProdutoDTO;
import br.com.estudos.domains.generics.enums.EnumTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController("/enums")
public class EnumsController {

    @Autowired
    private ProdutoMapper produtoMapper;

    @GetMapping("/valores")
    public List<String> obterValoresEnum(){
        return Arrays.asList(Arrays.stream(EnumTipoDocumento.values())
                .map(Enum::name)
                .toArray(String[]::new));
    }

    @GetMapping("/valor/{valor}")
    public EnumTipoDocumento obterValor(@PathVariable String valor){
        return EnumTipoDocumento.valueOf(valor.toUpperCase());
    }

    @PostMapping("/produtos")
    public List<Produto> listProdutos(@RequestBody List<ProdutoDTO> dtos){
        return produtoMapper.toListProduto(dtos);
    }
}
