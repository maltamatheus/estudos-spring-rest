package br.com.testes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListasController {

    @GetMapping("/ordem-alfabetica")
    public ResponseEntity<List<String>> retornaListaOrdenada(@RequestBody List<String> list){
        List<String> lista = list;

        Collections.sort(lista);

        return ResponseEntity.ok(lista);
    }
}
