package br.com.estudos.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import br.com.estudos.domains.testes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class TestesDataController {

	@Autowired
	private TaxaIOFMapper taxaIOFMapper;

	@ResponseBody
	@GetMapping("/retorna-instant")
	public ResponseEntity<Instant> retornaInstant(){
		return ResponseEntity.ok(Instant.now());
	}

	@GetMapping("/teste")
	public ResponseEntity<TaxaIOF> teste() {
		TaxaIOFDTO taxaDTO = new TaxaIOFDTO();
		taxaDTO.setGrupoRamo(1l);
		taxaDTO.setRamo(1l);
		taxaDTO.setPercentualIOF(new BigDecimal("10"));
		taxaDTO.setDataInicio(LocalDateTime.now());
		taxaDTO.setDataFimVigencia(LocalDateTime.now().plusDays(30));
		TaxaIOF taxa = taxaIOFMapper.dtoToPojo(taxaDTO);
		return ResponseEntity.ok(taxa);
	}
	@GetMapping("/teste2")
	public ResponseEntity<?> teste2() throws ParseException {
		String dataStr = "03/01/2008";
		Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataStr);

		return ResponseEntity.ok(data);
	}
}
