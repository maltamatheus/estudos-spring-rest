package br.com.testes.controllers;

import br.com.testes.domains.Interessado;
import br.com.testes.services.InteressadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interessados")
public class InteressadoController {

    @Autowired
    private InteressadoServices interessadoServices;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Interessado>> obterLista(){
        return ResponseEntity.ok(interessadoServices.obterLista());
    }

    @ResponseBody
    @GetMapping("/")
    public ResponseEntity<Interessado> obterGente(@RequestParam(name = "id") Long id){

        Optional<Interessado> optionalInteressado = interessadoServices.obterInteressado(id);

        if (optionalInteressado.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalInteressado.get());
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<Interessado> criarInteressado(@RequestBody Interessado interessado){
        return ResponseEntity.ok(interessadoServices.criarInteressado(interessado));
    }
}
