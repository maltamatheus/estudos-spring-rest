package br.com.testes.controllers;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class TestesDataController {
	@GetMapping("/retorna-instant")
	@ResponseBody
	public ResponseEntity<Instant> retornaInstant(){
		return ResponseEntity.ok(Instant.now());
	}
	
}
