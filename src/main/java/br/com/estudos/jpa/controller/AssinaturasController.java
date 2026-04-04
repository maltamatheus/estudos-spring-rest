package br.com.estudos.jpa.controller;

import br.com.estudos.jpa.domains.dto.AssinanteRequestDto;
import br.com.estudos.jpa.domains.entities.AssinanteEntity;
import br.com.estudos.jpa.services.AssinaturaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/assinaturas")
public class AssinaturasController {
    private AssinaturaService assinaturaService;

    @PostMapping("/criar-assinante")
    public ResponseEntity<AssinanteEntity> criarAssinante(@RequestBody AssinanteRequestDto novoAssinante){
        return ResponseEntity.ok(assinaturaService.criarAssinante(novoAssinante));
    }
}
