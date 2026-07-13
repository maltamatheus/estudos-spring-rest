package br.com.estudos.domains.testes;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxaIOFDTO extends InicioFimVigenciaDTO {
    private Long grupoRamo;
    private Long ramo;
    private BigDecimal percentualIOF;
}
