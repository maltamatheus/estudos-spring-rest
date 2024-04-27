package br.com.testes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testes01")
public class Teste01Controller {
	
	@GetMapping
	public String teste01() {
		return "Teste 01 Bem sucedido";
	}

}
