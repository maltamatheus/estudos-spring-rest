package br.com.estudos.controllers;

import br.com.estudos.domains.Produto;
import br.com.estudos.domains.mappers.ProdutoMapper;
import br.com.estudos.domains.dto.ProdutoDTO;
import br.com.estudos.domains.generics.enums.EnumTipoDocumento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/enums")
@Slf4j
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

    public static void main(String[]  args){
        int i = 1;
        log.info("Início: {}" , LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        while(i <= 1000){
            if(i%500 == 0){
                log.info("Chegou em {} às {}", i,LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                i++;
            }
        }
        log.info("Terminou às {}",LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
