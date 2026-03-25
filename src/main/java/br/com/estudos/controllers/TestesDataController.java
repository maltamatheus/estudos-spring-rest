package br.com.estudos.controllers;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class TestesDataController {
	@ResponseBody
	@GetMapping("/retorna-instant")
	public ResponseEntity<Instant> retornaInstant(){
		return ResponseEntity.ok(Instant.now());
	}
	
}
