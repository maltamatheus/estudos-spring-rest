package br.com.estudos.jpa.controller;

import br.com.estudos.config.infra.services.UsuarioService;
import br.com.estudos.jpa.domains.entities.Promocao;
import br.com.estudos.jpa.services.PromocaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promocoes")
@AllArgsConstructor
public class PromocoesController {

    private PromocaoService service;

    @PostMapping("/nova")
    public ResponseEntity<Promocao> criarNova(Promocao nova){
        return ResponseEntity.ok(service.criarNovaPromocao(nova));
    }

    @GetMapping
    public ResponseEntity<List<Promocao>> obterPromocoes(){
        return ResponseEntity.ok(service.obterPromocoes(service.obterNivelPorRoleUsuario()));
    }
}
