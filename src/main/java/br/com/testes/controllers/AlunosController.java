package br.com.testes.controllers;

import br.com.testes.domains.Aluno;
import br.com.testes.services.AlunoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunoServices alunoServices;

    @ResponseBody
    @GetMapping
    public ResponseEntity<?> obterAluno(){
        return ResponseEntity.ok(alunoServices.getAluno());
    }
}
