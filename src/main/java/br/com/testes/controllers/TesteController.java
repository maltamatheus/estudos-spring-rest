package br.com.testes.controllers;

import java.time.Instant;

import br.com.testes.domains.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testes")
public class TesteController {

	@GetMapping("/retorna-instant")
	@ResponseBody
	public ResponseEntity<Instant> retornaInstant(){
		return ResponseEntity.ok(Instant.now());
	}

}
