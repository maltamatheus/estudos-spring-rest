package br.com.testes.controllers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.testes.domains.Palavra;

@RestController
@RequestMapping("/testes")
public class TesteController {
	
	@GetMapping
	public String teste01() {
		return "Teste bem sucedido";
	}
	
	@GetMapping("/outroteste")
	public String teste02() {
		return "Outro Teste bem sucedido";
	}
	
	@GetMapping("/test")
	public List<String> getArrayInAlphabeticalOrder(@RequestBody List<Palavra> lista){
		
		List<String> termos = new ArrayList<String>();
		
		System.out.println("Antes da ordenação");
		
		for (Palavra palavra : lista) {
			
			System.out.println(palavra.getTermo());
			
			termos.add(palavra.getTermo());
		}
		
		System.out.println("Depois de ordenar");
		
		Collections.sort(termos);
		
		for (String string : termos) {
			System.out.println(string);
		}
		
		return termos;
	}

	@GetMapping("/retorna-instant")
	@ResponseBody
	public ResponseEntity<Instant> retornaInstant(){
		return ResponseEntity.ok(Instant.now());
	}
	
}
