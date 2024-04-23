package br.com.testes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testes")
public class TesteController {
	
	@GetMapping
	public String teste01() {
		return "Teste bem sucedido";
	}

}
